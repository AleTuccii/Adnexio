package com.azienda.Adnexio.businessLogic;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.Adnexio.dao.CarrelloDao;
import com.azienda.Adnexio.dao.OrdineDao;
import com.azienda.Adnexio.dao.ProdottoDao;
import com.azienda.Adnexio.dao.RuoloDao;
import com.azienda.Adnexio.dao.UtenteDao;
import com.azienda.Adnexio.exception.CarrelloVuotoException;
import com.azienda.Adnexio.exception.EmailEsistenteException;
import com.azienda.Adnexio.exception.ModificaIrregolareException;
import com.azienda.Adnexio.exception.PasswordErrataException;
import com.azienda.Adnexio.exception.ProdottoEsauritoException;
import com.azienda.Adnexio.exception.ProdottoPresenteException;
import com.azienda.Adnexio.exception.UtenteNonRegistratoException;
import com.azienda.Adnexio.exception.ValoreErratoException;
import com.azienda.Adnexio.model.Carrello;
import com.azienda.Adnexio.model.Ordine;
import com.azienda.Adnexio.model.Prodotto;
import com.azienda.Adnexio.model.Ruolo;
import com.azienda.Adnexio.model.Utente;
import com.azienda.Adnexio.util.Constants;
import com.azienda.Adnexio.util.EmailUtils;
import com.azienda.Adnexio.util.Validator;

public class BusinessLogic {

	private EntityManager manager;
	private CarrelloDao cD;
	private OrdineDao oD;
	private ProdottoDao pD;
	private RuoloDao rD;
	private UtenteDao uD;

	public BusinessLogic(EntityManager manager, CarrelloDao cD, OrdineDao oD, ProdottoDao pD, RuoloDao rD,
			UtenteDao uD) {
		this.manager = manager;
		this.cD = cD;
		this.oD = oD;
		this.pD = pD;
		this.rD = rD;
		this.uD = uD;
	}

	public void iscriviUtente(String nome, String cognome, String ddn, String metodoPagamento, String numeroTelefono,
			String email, String confermaEmail, String password, String confermaPassword) throws Exception {
		try {
			manager.getTransaction().begin();
			LocalDate data = LocalDate.parse(ddn);

			Validator.verificaAnagrafica(nome);
			Validator.verificaAnagrafica(cognome);
			Validator.verificaDdn(data);
			Validator.verificaTelefono(numeroTelefono);
			Validator.verificaEmail(email, confermaEmail);
			verificaUnicitaEmail(email);
			Validator.verificaPassword(password, confermaPassword);

			Carrello carrello = new Carrello();
			cD.create(carrello);
			Ruolo ruolo = ottieniRuolo();
			Utente utente = new Utente(email, nome, cognome, password, data, metodoPagamento, numeroTelefono);
			utente.setCarrello(carrello);
			utente.setRuolo(ruolo);
			uD.create(utente);
			manager.getTransaction().commit();
			EmailUtils.sendEmailRegistration(email);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	private Ruolo ottieniRuolo() {
		Ruolo ruolo = rD.retrieveByNomeRuolo(Constants.UTENTE_SEMPLICE);
		if (ruolo == null) {
			ruolo = rD.create(new Ruolo(Constants.UTENTE_SEMPLICE));
		}
		return ruolo;
	}

	private void verificaUnicitaEmail(String email) throws EmailEsistenteException {
		if (uD.retrieveEmail(email) != null) {
			throw new EmailEsistenteException("Email già associata a un utente", null);
		}
	}

	public Utente loginUtente(String email, String password) throws Exception {
		try {
			manager.getTransaction().begin();
			Utente utente = uD.retrieveByEmail(email);
			if (utente == null) {
				throw new UtenteNonRegistratoException("Email non associata ad alcun account", null);
			}
			if (!utente.getPassword().equals(password)) {
				throw new PasswordErrataException("La password è errata. Riprova.", null);
			}
			manager.getTransaction().commit();
			return utente;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void modificaUtente(String id, String nome, String cognome, String ddn, String metodoPagamento,
			String numeroTelefono, String email, String confermaEmail, String password, String confermaPassword)
			throws Exception {
		try {
			manager.getTransaction().begin();

			LocalDate data = LocalDate.parse(ddn);

			Validator.verificaAnagrafica(nome);
			Validator.verificaAnagrafica(cognome);
			Validator.verificaDdn(data);
			Validator.verificaTelefono(numeroTelefono);
			Validator.verificaEmail(email, confermaEmail);

			Utente utente = uD.retrieveByEmail(confermaEmail);
			if (utente != null) {
				if (utente.getId() != Integer.parseInt(id)) {
					verificaUnicitaEmail(email);
				}
			}
			Validator.verificaPassword(password, confermaPassword);

			uD.updateUtente(id, nome, cognome, data, metodoPagamento, numeroTelefono, email, password);
			manager.getTransaction().commit();
			EmailUtils.sendEmail(email);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void inserisciProdotto(String titolo, String genere, String piattaforma, String ddr, String sviluppatore,
			String editore, String localizzazione, String disponibilita, String pegi, String prezzo, Blob immagine,
			String nomeImmagine) throws Exception {
		try {
			manager.getTransaction().begin();
			Validator.verificaProdotto(titolo, genere, piattaforma, ddr, sviluppatore, editore, localizzazione,
					disponibilita, pegi, prezzo);
			LocalDate data = LocalDate.parse(ddr);
			Integer disp = Integer.parseInt(disponibilita);
			Float price = Float.parseFloat(prezzo);
			Prodotto prodotto = pD.retrieveByTitoloPiattaformaLocalizzazione(titolo, piattaforma, localizzazione);
			if (prodotto != null) {
				prodotto.setDisponibilita(prodotto.getDisponibilita() + disp);
			} else {
				prodotto = new Prodotto(titolo, genere, piattaforma, data, sviluppatore, editore, localizzazione, disp,
						pegi, price);
				prodotto.setImmagine(immagine);
				prodotto.setNomeImmagine(nomeImmagine);
				pD.create(prodotto);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public List<Prodotto> ricercaProdotti(String titolo, List<String> generi, List<String> piattaforme,
			List<String> localizzazione, List<String> pegi, String prezzoMinimo, String prezzoMassimo) {
		try {
			manager.getTransaction().begin();
			prezzoMinimo = (prezzoMinimo != "") ? prezzoMinimo : null;
			prezzoMassimo = (prezzoMassimo != "") ? prezzoMassimo : null;
			List<Prodotto> prodotti = pD.eseguiQueryRicerca(titolo, generi, piattaforme, localizzazione, pegi,
					prezzoMinimo, prezzoMassimo);
			for(Prodotto p : prodotti) {
				manager.refresh(p);
			}
			manager.getTransaction().commit();
			return prodotti;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public Prodotto ricercaProdottoAdmin(String titolo, String piattaforma, String localizzazione) {

		try {
			manager.getTransaction().begin();
			Prodotto prodotto = pD.retrieveByTitoloPiattaformaLocalizzazione(titolo, piattaforma, localizzazione);
			if (prodotto != null) {
				manager.refresh(prodotto);
			}
			manager.getTransaction().commit();
			return prodotto;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void modificaProdottoAdmin(String id, String titolo, String genere, String piattaforma,
			String localizzazione, String pegi, String ddr, String sviluppatore, String editore, String disponibilita,
			String prezzo, Blob immagine, String nomeImmagine) throws Exception {
		try {
			manager.getTransaction().begin();
			Validator.verificaProdotto(titolo, genere, piattaforma, ddr, sviluppatore, editore, localizzazione,
					disponibilita, pegi, prezzo);
			Prodotto prodotto = pD.retrieveByTitoloPiattaformaLocalizzazione(titolo, piattaforma, localizzazione);
			if (prodotto == null || (prodotto.getId() == Integer.parseInt(id))) {
				// inizio prova mantenere immagine vecchia
				if (immagine == null && nomeImmagine == null && prodotto != null) {
					Blob immagineVecchia = prodotto.getImmagine();
					String nomeImmagineVecchia = prodotto.getNomeImmagine();
					pD.updateAll(id, titolo, genere, piattaforma, localizzazione, pegi, ddr, sviluppatore, editore,
							disponibilita, prezzo, immagineVecchia, nomeImmagineVecchia);
				} else { // fine prova mantenere immagine vecchia
					pD.updateAll(id, titolo, genere, piattaforma, localizzazione, pegi, ddr, sviluppatore, editore,
							disponibilita, prezzo, immagine, nomeImmagine);
				}

			} else {
				throw new ModificaIrregolareException("Non è possibile modificare un prodotto in uno già esistente",
						null);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void rimuoviProdottoAdmin(String titolo, String piattaforma, String localizzazione) {
		try {
			manager.getTransaction().begin();
			Prodotto prodotto = pD.retrieveByTitoloPiattaformaLocalizzazione(titolo, piattaforma, localizzazione);
			if (prodotto != null) {

				for (Ordine ordine : prodotto.getOrdini()) {
					ordine.getProdotti().remove(prodotto);
				}

				for (Carrello carrello : prodotto.getCarrelli()) {
					carrello.getProdotti().remove(prodotto);
				}

				pD.delete(prodotto);
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public String creaAdmin(String email) throws Exception {
		try {
			manager.getTransaction().begin();
			Utente utente = uD.retrieveByEmail(email);
			if (utente == null) {
				throw new ValoreErratoException("Email non presente.", null);
			}
			Ruolo ruolo = rD.retrieveByNomeRuolo(Constants.UTENTE_ADMIN);
			if (ruolo == null) {
				ruolo = rD.create(new Ruolo(Constants.UTENTE_ADMIN));
			}
			utente.setRuolo(ruolo);
			manager.getTransaction().commit();
			return utente.getRuolo().getNome();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public String rimuoviAdmin(String email) throws Exception {
		try {
			manager.getTransaction().begin();
			Utente utente = uD.retrieveByEmail(email);
			if (utente == null) {
				throw new ValoreErratoException("Email non presente.", null);
			}
			if (utente.getEmail().equalsIgnoreCase("adnexio.gameshop@gmail.com")) {
				throw new ValoreErratoException("Impossibile rimuovere admin principale", null);
			}
			
			Ruolo ruolo = rD.retrieveByNomeRuolo(Constants.UTENTE_SEMPLICE);
			utente.setRuolo(ruolo);
			manager.getTransaction().commit();
			return utente.getRuolo().getNome();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void aggiungiAlCarrello(String id, Utente utente) throws ProdottoPresenteException, Exception {
		try {
			if (utente == null) {
				throw new UtenteNonRegistratoException("Per aggiungere un prodotto al carrello accedi e/o registrati",
						null);
			}

			Prodotto prodotto = pD.retrieveById(id);

			if (utente.getCarrello().getProdotti().contains(prodotto) || prodotto.getDisponibilita() <= 0) {
				throw new ProdottoPresenteException("Prodotto già presente nel carrello o non disponibile", null);
			}

			manager.getTransaction().begin();
			utente.getCarrello().getProdotti().add(prodotto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			if (manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
			throw e;
		}
	}

	public void rimuoviDalCarrello(String id, Utente utente) {
		try {
			manager.getTransaction().begin();
			Prodotto prodotto = pD.retrieveById(id);
			utente.getCarrello().getProdotti().remove(prodotto);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public void acquista(Utente utente) throws Exception {
		try {
			manager.getTransaction().begin();
			List<Prodotto> prodotti = utente.getCarrello().getProdotti();
			List<Prodotto> prodottiOrdinati = new ArrayList<Prodotto>();
			float importo = 0f;
			if (prodotti.size() > 0) {

				for (int i = 0; i < prodotti.size(); i++) {
					if (prodotti.get(i).getDisponibilita() > 0) {
						prodotti.get(i).setDisponibilita(prodotti.get(i).getDisponibilita() - 1);
						importo = importo + (prodotti.get(i).getPrezzo());
						prodotti.get(i).setNumeroAcquisti(prodotti.get(i).getNumeroAcquisti() + 1);
						prodotti.get(i).setRicavo(prodotti.get(i).getRicavo() + prodotti.get(i).getPrezzo());
						prodottiOrdinati.add(prodotti.get(i));
						utente.getCarrello().getProdotti().remove(i);
						i--;
					} else {
						throw new ProdottoEsauritoException(
								"Il prodotto " + prodotti.get(i).getTitolo() + " non è più disponibile", null);
					}
				}
			} else {
				throw new CarrelloVuotoException("Impossibile procedere con l'ordine. Il carrello è vuoto", null);
			}
			LocalDate data = LocalDate.now();
			String resoconto = prodottiOrdinati.toString();
			Float importoOrdine = (Float) importo;
			Ordine ordine = new Ordine(data, importoOrdine, resoconto);
			ordine.setProdotti(prodottiOrdinati);
			ordine.setUtente(utente);
			utente.getOrdini().add(ordine);
			oD.create(ordine);
			manager.getTransaction().commit();
			EmailUtils.sendEmail(utente.getEmail(), ordine);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public List<Utente> visualizzaUtenti() {
		try {
			manager.getTransaction().begin();
			List<Utente> utenti = uD.retrieve();
			manager.getTransaction().commit();
			return utenti;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public List<Ordine> visualizzaOrdini(String id) {
		try {
			manager.getTransaction().begin();
			Utente utente = uD.retrieveById(id);
			List<Ordine> ordini = utente.getOrdini();
			manager.getTransaction().commit();
			return ordini;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public List<Prodotto> visualizzaProdotti() {
		try {
			manager.getTransaction().begin();
			List<Prodotto> prodotti = pD.retrieve();

//			for (Prodotto p : prodotti) {
//				if (p != null) {
//					manager.refresh(p);
//				}
//			}

			manager.getTransaction().commit();
			return prodotti;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}

	public Prodotto retrieveById(String id) {
		try {
			manager.getTransaction().begin();
			Prodotto prodotto = pD.retrieveById(id);
			manager.getTransaction().commit();
			return prodotto;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
}

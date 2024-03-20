package com.azienda.Adnexio.dao;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.azienda.Adnexio.model.Prodotto;
import com.azienda.Adnexio.util.QueryBuilder;

public class ProdottoDao implements DaoInterface<Prodotto> {

	private EntityManager manager;

	public ProdottoDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Prodotto create(Prodotto ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<Prodotto> retrieve() {
		return manager.createQuery("Select x from Prodotto x", Prodotto.class).getResultList();
	}

	@Override
	public Prodotto update(Prodotto ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(Prodotto ref) {
		manager.remove(ref);

	}

	public Prodotto retrieveByTitoloPiattaformaLocalizzazione(String titolo, String piattaforma,
			String localizzazione) {
		List<Prodotto> prodotti = manager.createQuery(
				"Select x from Prodotto x where x.titolo=:titolo AND x.piattaforma=:piattaforma AND x.localizzazione=:localizzazione",
				Prodotto.class).setParameter("titolo", titolo).setParameter("piattaforma", piattaforma)
				.setParameter("localizzazione", localizzazione).getResultList();
		if (!prodotti.isEmpty()) {
			return prodotti.get(0);
		} else {
			return null;
		}
	}

	public Prodotto retrieveById(String id) {
		List<Prodotto> prodotti = manager.createQuery("Select x from Prodotto x where x.id=:id", Prodotto.class)
				.setParameter("id", Integer.parseInt(id)).getResultList();
		if (!prodotti.isEmpty()) {
			return prodotti.get(0);
		} else {
			return null;
		}
	}

	public List<Prodotto> eseguiQueryRicerca(String titolo, List<String> generi, List<String> piattaforme,
			List<String> localizzazione, List<String> pegi, String prezzoMinimo, String prezzoMassimo) {

		String query = QueryBuilder.creaQueryRicerca(titolo, generi, piattaforme, localizzazione, pegi, prezzoMinimo,
				prezzoMassimo);

		TypedQuery<Prodotto> typedQuery = manager.createQuery(query, Prodotto.class);

		return typedQuery.getResultList();
	}

	public void updateAll(String id, String titolo, String genere, String piattaforma, String localizzazione,
			String pegi, String ddr, String sviluppatore, String editore, String disponibilita, String prezzo,
			Blob immagine, String nomeImmagine) {
		manager.createQuery("UPDATE Prodotto SET titolo = :titolo, genere = :genere, piattaforma = :piattaforma, "
				+ "localizzazione = :localizzazione, pegi = :pegi, ddr = :ddr, sviluppatore = :sviluppatore, "
				+ "editore = :editore, disponibilita = :disponibilita, prezzo = :prezzo, immagine= :immagine, nomeImmagine=:nomeImmagine WHERE id = :id")
				.setParameter("titolo", titolo).setParameter("genere", genere).setParameter("piattaforma", piattaforma)
				.setParameter("localizzazione", localizzazione).setParameter("pegi", pegi)
				.setParameter("ddr", LocalDate.parse(ddr)).setParameter("sviluppatore", sviluppatore)
				.setParameter("editore", editore).setParameter("disponibilita", Integer.parseInt(disponibilita))
				.setParameter("prezzo", Float.parseFloat(prezzo)).setParameter("immagine", immagine)
				.setParameter("nomeImmagine", nomeImmagine).setParameter("id", Integer.parseInt(id)).executeUpdate();

	}

}

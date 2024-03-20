package com.azienda.Adnexio.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.Adnexio.model.Utente;

public class UtenteDao implements DaoInterface<Utente> {

	private EntityManager manager;

	public UtenteDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Utente create(Utente ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<Utente> retrieve() {
		return manager.createQuery("Select x from Utente x", Utente.class).getResultList();
	}

	@Override
	public Utente update(Utente ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(Utente ref) {
		manager.remove(ref);

	}

	public String retrieveEmail(String email) {
		List<Utente> utenti = manager.createQuery("Select x from Utente x where x.email=:email", Utente.class)
				.setParameter("email", email).getResultList();
		if (!utenti.isEmpty()) {
			return utenti.get(0).getEmail();
		} else {
			return null;
		}
	}

	public Utente retrieveByEmail(String email) {
		List<Utente> utenti = manager.createQuery("Select x from Utente x where x.email=:email", Utente.class)
				.setParameter("email", email).getResultList();
		if (!utenti.isEmpty()) {
			return utenti.get(0);
		} else {
			return null;
		}
	}

	public Utente retrieveById(String id) {
		List<Utente> utenti = manager.createQuery("Select x from Utente x where x.id=:id", Utente.class)
				.setParameter("id", Integer.parseInt(id)).getResultList();
		if (!utenti.isEmpty()) {
			return utenti.get(0);
		} else {
			return null;
		}
	}

	public List<Utente> retrieveByRuolo() {
		List<Utente> utenti = manager.createQuery("Select x from Utente x where x.ruolo_id=:ruolo", Utente.class)
				.setParameter("ruolo", 2).getResultList();
		if (!utenti.isEmpty()) {
			return utenti;
		} else {
			return null;
		}
	}

	public void updateUtente(String id, String nome, String cognome, LocalDate ddn, String metodoPagamento,
			String numeroTelefono, String email, String password) {
		manager.createQuery(
				"Update Utente Set nome = :nome, cognome = :cognome, ddn = :ddn, metodoDiPagamento = :pagamento, numeroTelefono = :telefono, email = :email, password = :password Where id = :id")
				.setParameter("nome", nome).setParameter("cognome", cognome).setParameter("ddn", ddn)
				.setParameter("pagamento", metodoPagamento).setParameter("telefono", numeroTelefono)
				.setParameter("email", email).setParameter("password", password)
				.setParameter("id", Integer.parseInt(id)).executeUpdate();
	}

}

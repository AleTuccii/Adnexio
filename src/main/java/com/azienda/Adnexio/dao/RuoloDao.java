package com.azienda.Adnexio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.Adnexio.model.Ruolo;

public class RuoloDao implements DaoInterface<Ruolo> {

	private EntityManager manager;

	public RuoloDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Ruolo create(Ruolo ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<Ruolo> retrieve() {
		return manager.createQuery("Select x from Ruolo x", Ruolo.class).getResultList();
	}

	@Override
	public Ruolo update(Ruolo ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(Ruolo ref) {
		manager.remove(ref);

	}

	public Ruolo retrieveByNomeRuolo(String nomeRuolo) {
		List<Ruolo> ruoli = manager.createQuery("Select x from Ruolo x where x.nome=:ruolo", Ruolo.class)
				.setParameter("ruolo", nomeRuolo).getResultList();
		if (!ruoli.isEmpty()) {
			return ruoli.get(0);
		} else {
			return null;
		}
	}

}

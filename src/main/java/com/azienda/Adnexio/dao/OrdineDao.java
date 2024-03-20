package com.azienda.Adnexio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.Adnexio.model.Ordine;

public class OrdineDao implements DaoInterface<Ordine> {

	private EntityManager manager;

	public OrdineDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Ordine create(Ordine ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<Ordine> retrieve() {
		return manager.createQuery("Select x from Ordine x", Ordine.class).getResultList();
	}

	@Override
	public Ordine update(Ordine ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(Ordine ref) {
		manager.remove(ref);

	}

}

package com.azienda.Adnexio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.azienda.Adnexio.model.Carrello;

public class CarrelloDao implements DaoInterface<Carrello> {

	private EntityManager manager;

	public CarrelloDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Carrello create(Carrello ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public List<Carrello> retrieve() {
		return manager.createQuery("Select x from Carrello x", Carrello.class).getResultList();

	}

	@Override
	public Carrello update(Carrello ref) {
		manager.persist(ref);
		return ref;
	}

	@Override
	public void delete(Carrello ref) {
		manager.remove(ref);

	}

}

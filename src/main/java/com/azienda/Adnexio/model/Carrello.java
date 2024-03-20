package com.azienda.Adnexio.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrello {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(mappedBy = "carrello")
	private Utente utente;
	@ManyToMany
	@JoinTable(name = "Carrello_Prodotto", joinColumns = @JoinColumn(name = "Carrello_id"), inverseJoinColumns = @JoinColumn(name = "Prodotto_id"))
	private List<Prodotto> prodotti = new ArrayList<Prodotto>();

	public Carrello() {

	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	@Override
	public String toString() {

		return "" + id;
	}

}

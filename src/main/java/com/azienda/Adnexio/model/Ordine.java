package com.azienda.Adnexio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private LocalDate dda;
	@Column(nullable = false)
	private Float importo;
	@Lob
	private String resoconto;
	@ManyToOne
	private Utente utente;
	@ManyToMany
	@JoinTable(name = "Ordine_Prodotto", joinColumns = @JoinColumn(name = "Ordine_id"), inverseJoinColumns = @JoinColumn(name = "Prodotto_id"))
	private List<Prodotto> prodotti = new ArrayList<Prodotto>();

	public Ordine() {

	}

	public Ordine(LocalDate dda, Float importo, String resoconto) {
		this.dda = dda;
		this.importo = importo;
		this.resoconto = resoconto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDda() {
		return dda;
	}

	public void setDda(LocalDate dda) {
		this.dda = dda;
	}

	public Float getImporto() {
		return importo;
	}

	public void setImporto(Float importo) {
		this.importo = importo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public String getResoconto() {
		return resoconto;
	}

	public void setResoconto(String resoconto) {
		this.resoconto = resoconto;
	}

	@Override
	public String toString() {
		return id + " " + dda + " " + importo + " " + resoconto;
	}

}

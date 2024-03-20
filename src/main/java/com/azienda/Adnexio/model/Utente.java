package com.azienda.Adnexio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private LocalDate ddn;
	@Column(nullable = false)
	private String metodoDiPagamento;
	private String numeroTelefono;
	@OneToOne
	private Carrello carrello;
	@ManyToOne
	private Ruolo ruolo;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utente")
	private List<Ordine> ordini = new ArrayList<Ordine>();

	public Utente() {

	}

	public Utente(String email, String nome, String cognome, String password, LocalDate ddn, String metodoDiPagamento,
			String numeroTelefono) {
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.ddn = ddn;
		this.metodoDiPagamento = metodoDiPagamento;
		this.numeroTelefono = numeroTelefono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDdn() {
		return ddn;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}

	public String getMetodoDiPagamento() {
		return metodoDiPagamento;
	}

	public void setMetodoDiPagamento(String metodoDiPagamento) {
		this.metodoDiPagamento = metodoDiPagamento;
	}

	public Carrello getCarrello() {
		return carrello;
	}

	public void setCarrello(Carrello carrello) {
		this.carrello = carrello;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	@Override
	public String toString() {

		return id + " " + nome + " " + cognome + " " + email + " " + password + " " + ddn + " " + metodoDiPagamento
				+ " " + numeroTelefono;
	}

}

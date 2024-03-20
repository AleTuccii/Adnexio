package com.azienda.Adnexio.model;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "titolo", "piattaforma", "localizzazione" }) })
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String titolo;
	@Column(nullable = false)
	private String genere;
	@Column(nullable = false)
	private String piattaforma;
	@Column(nullable = false)
	private LocalDate ddr;
	@Column(nullable = false)
	private String sviluppatore;
	@Column(nullable = false)
	private String editore;
	@Column(nullable = false)
	private String localizzazione;
	@Column(nullable = false)
	private Integer disponibilita;
	@Column(nullable = false)
	private String pegi;
	@Column(nullable = false)
	private Float prezzo;
	@Column(nullable = false)
	private Integer numeroAcquisti = 0;
	@Column(nullable = false)
	private Float ricavo = 0f;
	private Blob immagine;
	private String nomeImmagine;

	@ManyToMany(mappedBy = "prodotti")
	private List<Carrello> carrelli = new ArrayList<Carrello>();
	@ManyToMany(mappedBy = "prodotti")
	private List<Ordine> ordini = new ArrayList<Ordine>();

	public Prodotto() {

	}

	public Prodotto(String titolo, String genere, String piattaforma, LocalDate ddr, String sviluppatore,
			String editore, String localizzazione, Integer disponibilita, String pegi, Float prezzo) {
		this.titolo = titolo;
		this.genere = genere;
		this.piattaforma = piattaforma;
		this.ddr = ddr;
		this.sviluppatore = sviluppatore;
		this.editore = editore;
		this.localizzazione = localizzazione;
		this.disponibilita = disponibilita;
		this.pegi = pegi;
		this.prezzo = prezzo;
	}

	public Integer getNumeroAcquisti() {
		return numeroAcquisti;
	}

	public void setNumeroAcquisti(Integer numeroAcquisti) {
		this.numeroAcquisti = numeroAcquisti;
	}

	public Blob getImmagine() {
		return immagine;
	}

	public void setImmagine(Blob immagine) {
		this.immagine = immagine;
	}

	public String getNomeImmagine() {
		return nomeImmagine;
	}

	public void setNomeImmagine(String nomeImmagine) {
		this.nomeImmagine = nomeImmagine;
	}

	public Integer getId() {
		return id;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getPiattaforma() {
		return piattaforma;
	}

	public void setPiattaforma(String piattaforma) {
		this.piattaforma = piattaforma;
	}

	public LocalDate getDdr() {
		return ddr;
	}

	public void setDdr(LocalDate ddr) {
		this.ddr = ddr;
	}

	public String getSviluppatore() {
		return sviluppatore;
	}

	public void setSviluppatore(String sviluppatore) {
		this.sviluppatore = sviluppatore;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public String getLocalizzazione() {
		return localizzazione;
	}

	public void setLocalizzazione(String localizzazione) {
		this.localizzazione = localizzazione;
	}

	public Integer getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(Integer disponibilita) {
		this.disponibilita = disponibilita;
	}

	public String getPegi() {
		return pegi;
	}

	public void setPegi(String pegi) {
		this.pegi = pegi;
	}

	public List<Carrello> getCarrelli() {
		return carrelli;
	}

	public void setCarrelli(List<Carrello> carrelli) {
		this.carrelli = carrelli;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public Float getRicavo() {
		return ricavo;
	}

	public void setRicavo(Float ricavo) {
		this.ricavo = ricavo;
	}

	@Override
	public String toString() {

		return titolo + " " + piattaforma + " " + localizzazione + " " + prezzo + "&euro;";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Prodotto prodotto = (Prodotto) o;
		return Objects.equals(id, prodotto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

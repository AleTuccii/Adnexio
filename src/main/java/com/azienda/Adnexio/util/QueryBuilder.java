package com.azienda.Adnexio.util;

import java.util.List;

public class QueryBuilder {

	public static String creaQueryRicerca(String titolo, List<String> generi, List<String> piattaforme,
			List<String> localizzazione, List<String> pegi, String prezzoMinimo, String prezzoMassimo) {

		StringBuilder query = new StringBuilder("SELECT p FROM Prodotto p WHERE 1 = 1");

		if (titolo != null && !titolo.isEmpty()) {
			query.append(" AND p.titolo LIKE '").append("%" + titolo + "%").append("'");
		}

		if (generi != null && !generi.isEmpty()) {
			query.append(" AND p.genere IN (").append(creaStringaLista(generi)).append(")");
		}

		if (piattaforme != null && !piattaforme.isEmpty()) {
			query.append(" AND p.piattaforma IN (").append(creaStringaLista(piattaforme)).append(")");
		}

		if (localizzazione != null && !localizzazione.isEmpty()) {
			query.append(" AND p.localizzazione IN (").append(creaStringaLista(localizzazione)).append(")");
		}

		if (pegi != null && !pegi.isEmpty()) {
			query.append(" AND p.pegi IN (").append(creaStringaLista(pegi)).append(")");
		}

		if (prezzoMinimo != null && !prezzoMinimo.isEmpty()) {
			query.append(" AND p.prezzo >= ").append(prezzoMinimo);
		}

		if (prezzoMassimo != null && !prezzoMassimo.isEmpty()) {
			query.append(" AND p.prezzo <= ").append(prezzoMassimo);
		}

		return query.toString();
	}

	private static String creaStringaLista(List<String> lista) {
		StringBuilder stringaLista = new StringBuilder();
		for (int i = 0; i < lista.size(); i++) {
			stringaLista.append("'").append(lista.get(i)).append("'");
			if (i < lista.size() - 1) {
				stringaLista.append(", ");
			}
		}
		return stringaLista.toString();
	}

}

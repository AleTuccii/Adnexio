package com.azienda.Adnexio.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.azienda.Adnexio.exception.EmailDiverseException;
import com.azienda.Adnexio.exception.EtaException;
import com.azienda.Adnexio.exception.FormatoEmailException;
import com.azienda.Adnexio.exception.FormatoPasswordException;
import com.azienda.Adnexio.exception.PasswordDiverseException;
import com.azienda.Adnexio.exception.ValoreErratoException;

public class Validator {

	public static void verificaAnagrafica(String input) throws ValoreErratoException {
		controllaStringaVuota(input, "Il campo non può essere vuoto");

	}

	public static void verificaDdn(LocalDate ddn) throws EtaException {
		LocalDate oggi = LocalDate.now();
		Period periodo = Period.between(ddn, oggi);
		int age = periodo.getYears();
		if (age < 14) {
			throw new EtaException("L'età minima è 14 anni", null);
		}
	}

	public static void verificaTelefono(String numeroTelefono) throws ValoreErratoException {
		controllaStringaVuota(numeroTelefono, "Numero di telefono mancante.");
		if (!numeroTelefono.matches("\\d{10}")) {
			throw new ValoreErratoException("Il numero di telefono deve avere esattamente 10 caratteri.", null);
		}
	}

	public static void verificaEmail(String email, String confermaEmail)
			throws EmailDiverseException, FormatoEmailException, ValoreErratoException {
		controllaStringaVuota(email, "Email mancante.");
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			if (!email.equals(confermaEmail)) {
				throw new EmailDiverseException("Le email non corrispondono", null);
			}
		} else {
			throw new FormatoEmailException("Il formato della email non è valido", null);
		}
	}

	public static void verificaPassword(String password, String confermaPassword)
			throws PasswordDiverseException, FormatoPasswordException {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			if (!password.equals(confermaPassword)) {
				throw new PasswordDiverseException("Le password non corrispondono", null);
			}
		} else {
			throw new FormatoPasswordException(
					"La password deve contenere almeno 8 caratteri, un numero, una lettera maiuscola, una lettera minuscola e un carattere speciale",
					null);
		}
	}

	public static void verificaProdotto(String titolo, String genere, String piattaforma, String ddr,
			String sviluppatore, String editore, String localizzazione, String disponibilita, String pegi,
			String prezzo) throws ValoreErratoException {

		controllaStringaVuota(titolo, "Titolo Mancante");
		controllaStringaVuota(genere, "Genere Mancante");
		controllaStringaVuota(piattaforma, "Piattaforma Mancante");
		controllaStringaVuota(sviluppatore, "Sviluppatore Mancante");
		controllaStringaVuota(editore, "Editore Mancante");
		controllaStringaVuota(localizzazione, "Localizzazione Mancante");
		controllaStringaVuota(ddr, "Data di rilascio Mancante");

		Integer disp = controllaInteger(disponibilita, "Disponibilità Mancante",
				"La disponibilità non è nel formato numerico");
		if (disp < 0) {
			throw new ValoreErratoException("La disponibilità non può avere valori minori di 0", null);
		}
		Integer peg = controllaInteger(pegi, "Pegi Mancante", "Pegi non nel formato numerico");

		if (peg != 3 && peg != 7 && peg != 12 && peg != 16 && peg != 18) {
			throw new ValoreErratoException("Pegi non valido", null);
		}
		Float price = controllaFloat(prezzo, "Prezzo mancante", "Prezzo non è nel formato numerico");
		if (price < 0) {
			throw new ValoreErratoException("Il prezzo non può avere valori minori di 0", null);
		}

	}

	public static void controllaStringaVuota(String input, String message) throws ValoreErratoException {
		if (input == null || input.trim().isEmpty()) {
			throw new ValoreErratoException(message, null);
		}
	}

	public static Integer controllaInteger(String input, String message, String message2) throws ValoreErratoException {
		controllaStringaVuota(input, message);
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			throw new ValoreErratoException(message2, null);
		}
	}

	public static Float controllaFloat(String input, String message, String message2) throws ValoreErratoException {
		controllaStringaVuota(input, message);
		try {
			return Float.parseFloat(input);
		} catch (Exception e) {
			throw new ValoreErratoException(message2, null);
		}
	}

	public static List<String> creaListaRicerca(String input1, String input2, String input3, String input4) {
		List<String> result = new ArrayList<String>();
		if (input1 != null) {
			result.add(input1);
		}
		if (input2 != null) {
			result.add(input2);
		}
		if (input3 != null) {
			result.add(input3);
		}
		if (input4 != null) {
			result.add(input4);
		}
		if (!result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}

	public static List<String> creaListaRicerca(String input1, String input2, String input3, String input4,
			String input5) {
		List<String> result = new ArrayList<String>();
		if (input1 != null) {
			result.add(input1);
		}
		if (input2 != null) {
			result.add(input2);
		}
		if (input3 != null) {
			result.add(input3);
		}
		if (input4 != null) {
			result.add(input4);
		}
		if (input5 != null) {
			result.add(input5);
		}
		if (!result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}

	public static List<String> creaListaRicerca(String input1, String input2, String input3, String input4,
			String input5, String input6, String input7, String input8, String input9, String input10) {
		List<String> result = new ArrayList<String>();
		if (input1 != null) {
			result.add(input1);
		}
		if (input2 != null) {
			result.add(input2);
		}
		if (input3 != null) {
			result.add(input3);
		}
		if (input4 != null) {
			result.add(input4);
		}
		if (input5 != null) {
			result.add(input5);
		}
		if (input6 != null) {
			result.add(input6);
		}
		if (input7 != null) {
			result.add(input7);
		}
		if (input8 != null) {
			result.add(input8);
		}
		if (input9 != null) {
			result.add(input9);
		}
		if (input10 != null) {
			result.add(input10);
		}
		if (!result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}
}

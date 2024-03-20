package com.azienda.Adnexio.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.azienda.Adnexio.model.Ordine;

public class EmailUtils {
	public static void sendEmail(String to, Ordine ordine) throws Exception {
		Properties prop = new Properties();
		InputStream is = EmailUtils.class.getClassLoader().getResourceAsStream("email.properties");
		prop.load(is);
		String emailEnabled = prop.getProperty("enabled");
		if (emailEnabled != null && emailEnabled.equalsIgnoreCase("true")) {
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(prop.getProperty("username"), prop.getProperty("password"));
				}
			});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(prop.getProperty("from")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Grazie da Adnexio S.p.A.!");
			String serialCharPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			List<String> seriali = new ArrayList<String>();

			for (int i = 0; i < ordine.getProdotti().size(); i++) {
				StringBuilder seriale = new StringBuilder();
				for (int j = 0; j < 16; j++) {
					seriale.append(serialCharPool.charAt((int) (Math.floor(Math.random() * serialCharPool.length()))));
				}

				seriali.add(ordine.getProdotti().get(i).getTitolo() + ": " + seriale);

			}

			message.setContent("Grazie da Adnexio per il tuo acquisto! <br><br> Ecco il riepilogo del tuo ordine: <br>"
					+ ordine.getResoconto() + "<br> totale speso:   " + ordine.getImporto()
					+ "<br><br> Ecco il/i tuo/tuoi codice/i <br> <br> " + componiTesto(seriali)
					+ "<br><br>Speriamo di rivederti presto!<br><br><br> <a href='http://localhost:8080/Adnexio/'>Adnexio</a>",
					"text/html");
			Transport.send(message);
		}
	}

	public static void sendEmail(String to) throws Exception {
		Properties prop = new Properties();
		InputStream is = EmailUtils.class.getClassLoader().getResourceAsStream("email.properties");
		prop.load(is);
		String emailEnabled = prop.getProperty("enabled");
		if (emailEnabled != null && emailEnabled.equalsIgnoreCase("true")) {
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(prop.getProperty("username"), prop.getProperty("password"));
				}
			});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(prop.getProperty("from")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Grazie da Adnexio S.p.A.!");
			// message.setText("Grazie da CatalogoProdotti S.p.A. per aver comprato il
			// prodotto " + prodotto.getNome() + "! ");
			message.setContent(
					"Credenziali aggiornate con successo!   <br><br>Speriamo di rivederti presto!<br><br><br> <a href='http://localhost:8080/Adnexio/'>Adnexio</a>",
					"text/html");
			Transport.send(message);
		}
	}

	public static void sendEmailRegistration(String to) throws Exception {
		Properties prop = new Properties();
		InputStream is = EmailUtils.class.getClassLoader().getResourceAsStream("email.properties");
		prop.load(is);
		String emailEnabled = prop.getProperty("enabled");
		if (emailEnabled != null && emailEnabled.equalsIgnoreCase("true")) {
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(prop.getProperty("username"), prop.getProperty("password"));
				}
			});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(prop.getProperty("from")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Grazie da Adnexio S.p.A.!");
			// message.setText("Grazie da CatalogoProdotti S.p.A. per aver comprato il
			// prodotto " + prodotto.getNome() + "! ");
			message.setContent(
					"Collegamento avvenuto con successo!<br><br> Benvenuto nella community di Adnexio!   <br><br> <a href='http://localhost:8080/Adnexio/'>Adnexio</a>",
					"text/html");
			Transport.send(message);
		}
	}

	private static String componiTesto(List<String> seriali) {
		StringBuilder testoCompleto = new StringBuilder();
		for (int i = 0; i < seriali.size(); i++) {
			testoCompleto.append(seriali.get(i) + "<br>");
		}
		return testoCompleto.toString();
	}
}

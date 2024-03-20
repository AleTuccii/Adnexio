package com.azienda.Adnexio.web;

import java.io.IOException;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.exception.EmailDiverseException;
import com.azienda.Adnexio.exception.EmailEsistenteException;
import com.azienda.Adnexio.exception.EtaException;
import com.azienda.Adnexio.exception.FormatoEmailException;
import com.azienda.Adnexio.exception.FormatoPasswordException;
import com.azienda.Adnexio.exception.PasswordDiverseException;
import com.azienda.Adnexio.exception.ValoreErratoException;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modificaCredenziali")
public class ModificaCredenzialiServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BusinessLogic bL = (BusinessLogic) getServletContext().getAttribute(Constants.CHIAVE_INIT);

			String id = (String) req.getParameter(Constants.UTENTE_ID);
			String nome = (String) req.getParameter(Constants.FORM_NOME);
			String cognome = (String) req.getParameter(Constants.FORM_COGNOME);
			String ddn = (String) req.getParameter(Constants.FORM_DATA);
			String metodoPagamento = (String) req.getParameter(Constants.FORM_PAGAMENTO);
			String numeroTelefono = (String) req.getParameter(Constants.FORM_TELEFONO);
			String email = (String) req.getParameter(Constants.FORM_EMAIL);
			String confermaEmail = (String) req.getParameter(Constants.FORM_CONFERMA_EMAIL);
			String password = (String) req.getParameter(Constants.FORM_PASSWORD);
			String confermaPassword = (String) req.getParameter(Constants.FORM_CONFERMA_PASSWORD);
			bL.modificaUtente(id, nome, cognome, ddn, metodoPagamento, numeroTelefono, email, confermaEmail, password,
					confermaPassword);
			req.setAttribute(Constants.CHIAVE_MODIFICA_CREDENZIALI, "Modifica avvenuta con successo");
			req.getRequestDispatcher("/jsp/privata/utente/homePrivata.jsp").forward(req, resp);
		} catch (ValoreErratoException | EmailDiverseException | EmailEsistenteException | EtaException
				| FormatoEmailException | FormatoPasswordException | PasswordDiverseException e) {
			e.printStackTrace();
			req.setAttribute(Constants.CHIAVE_ERRORE_MODIFICA_CREDENZIALI, e.getMessage());
			req.getRequestDispatcher("/jsp/privata/utente/modificaCredenziali.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}
}

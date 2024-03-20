package com.azienda.Adnexio.web;

import java.io.IOException;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.exception.PasswordErrataException;
import com.azienda.Adnexio.exception.UtenteNonRegistratoException;
import com.azienda.Adnexio.model.Utente;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BusinessLogic bL = (BusinessLogic) getServletContext().getAttribute(Constants.CHIAVE_INIT);
			String email = (String) req.getParameter(Constants.LOGIN_EMAIL);
			String password = (String) req.getParameter(Constants.LOGIN_PASSWORD);
			Utente utente = bL.loginUtente(email, password);
			if (utente.getRuolo().getNome().equals(Constants.UTENTE_ADMIN)) {
				req.getSession().setAttribute(Constants.CHIAVE_SESSIONE_UTENTE, utente);
				req.getRequestDispatcher("/jsp/privata/admin/homePrivataAdmin.jsp").forward(req, resp);
			} else {
				req.getSession().setAttribute(Constants.CHIAVE_SESSIONE_UTENTE, utente);
				req.getRequestDispatcher("/jsp/privata/utente/homePrivata.jsp").forward(req, resp);
			}
		} catch (UtenteNonRegistratoException | PasswordErrataException e) {
			e.printStackTrace();
			req.setAttribute(Constants.CHIAVE_ERRORE_LOGIN, e.getMessage());
			req.getRequestDispatcher("/jsp/pubblica/login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}

}

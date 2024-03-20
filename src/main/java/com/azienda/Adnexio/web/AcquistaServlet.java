package com.azienda.Adnexio.web;

import java.io.IOException;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.exception.CarrelloVuotoException;
import com.azienda.Adnexio.exception.ProdottoEsauritoException;
import com.azienda.Adnexio.model.Utente;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/acquista")
public class AcquistaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BusinessLogic bL = (BusinessLogic) getServletContext().getAttribute(Constants.CHIAVE_INIT);
			Utente utente = (Utente) req.getSession().getAttribute(Constants.CHIAVE_SESSIONE_UTENTE);
			bL.acquista(utente);
			req.getRequestDispatcher("/jsp/privata/utente/ordini.jsp").forward(req, resp);
		} catch (ProdottoEsauritoException | CarrelloVuotoException e) {
			req.setAttribute(Constants.CHIAVE_ERRORE_ACQUISTO, e.getMessage());
			req.getRequestDispatcher("/jsp/privata/utente/carrello.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}
}

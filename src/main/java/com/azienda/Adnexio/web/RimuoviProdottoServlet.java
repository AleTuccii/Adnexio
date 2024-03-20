package com.azienda.Adnexio.web;

import java.io.IOException;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rimuoviProdotto")
public class RimuoviProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BusinessLogic bL = (BusinessLogic) getServletContext().getAttribute(Constants.CHIAVE_INIT);
			String titolo = (String) (req.getParameter(Constants.TITOLO));
			String piattaforma = (String) (req.getParameter(Constants.PIATTAFORMA));
			String localizzazione = (String) (req.getParameter(Constants.LOCALIZZAZIONE));
			bL.rimuoviProdottoAdmin(titolo, piattaforma, localizzazione);
			req.setAttribute(Constants.CHIAVE_RIMOZIONE_PRODOTTO, "Prodotto rimosso con successo");
			req.getRequestDispatcher("/jsp/privata/admin/homePrivataAdmin.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}
}

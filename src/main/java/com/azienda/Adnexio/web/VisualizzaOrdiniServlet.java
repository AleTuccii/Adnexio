package com.azienda.Adnexio.web;

import java.io.IOException;
import java.util.List;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.model.Ordine;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/visualizzaOrdini")
public class VisualizzaOrdiniServlet extends HttpServlet {

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
			List<Ordine> ordini = bL.visualizzaOrdini(id);
			req.setAttribute(Constants.CHIAVE_LISTA_ORDINI, ordini);
			req.getRequestDispatcher("/jsp/privata/admin/visualizzaOrdini.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}
}

package com.azienda.Adnexio.web;

import java.io.IOException;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.exception.ValoreErratoException;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/assegnaAdmin")
public class AssegnaAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BusinessLogic bL = (BusinessLogic) getServletContext().getAttribute(Constants.CHIAVE_INIT);
			String email = (String) (req.getParameter(Constants.FORM_EMAIL));
			String action = req.getParameter("action");

			if ("Promuovi".equals(action)) {
				String ruolo = bL.creaAdmin(email);
				req.setAttribute(Constants.UTENTE_ADMIN, ruolo);
			} else if ("Rimuovi".equals(action)) {
				String ruolo = bL.rimuoviAdmin(email);
				req.setAttribute(Constants.UTENTE_SEMPLICE, ruolo);
			}
			
			req.getRequestDispatcher("/jsp/privata/admin/homePrivataAdmin.jsp").forward(req, resp);
		} 
		catch (ValoreErratoException e) {
			e.printStackTrace();
			req.setAttribute(Constants.CHIAVE_RICERCA_RISULTATO, e.getMessage());
			req.getRequestDispatcher("/jsp/privata/admin/homePrivataAdmin.jsp").forward(req, resp);
		}
		catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}

}

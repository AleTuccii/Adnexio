package com.azienda.Adnexio.web;

import java.io.IOException;

import com.azienda.Adnexio.model.Utente;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/jsp/privata/utente/*")
public class FiltroAccessiUtente implements Filter{



		@Override
		public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
				throws IOException, ServletException {
			try {
				HttpServletRequest req = (HttpServletRequest) arg0;
				Utente utente = (Utente) req.getSession().getAttribute(Constants.CHIAVE_SESSIONE_UTENTE);
				if (utente != null && (utente.getRuolo().getNome().equals(Constants.UTENTE_SEMPLICE) || utente.getRuolo().getNome().equals(Constants.UTENTE_ADMIN))) {
					arg2.doFilter(arg0, arg1);
				}
				else {
					arg0.setAttribute(Constants.CHIAVE_ERRORE_LOGIN, "Fai il login o registrati per accedere a questa sessione");
					arg0.getRequestDispatcher("/jsp/pubblica/login.jsp").forward(arg0, arg1);
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
				arg0.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(arg0, arg1);
			}
			
		}

	
}

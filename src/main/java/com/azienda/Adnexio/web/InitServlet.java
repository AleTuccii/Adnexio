package com.azienda.Adnexio.web;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.dao.CarrelloDao;
import com.azienda.Adnexio.dao.OrdineDao;
import com.azienda.Adnexio.dao.ProdottoDao;
import com.azienda.Adnexio.dao.RuoloDao;
import com.azienda.Adnexio.dao.UtenteDao;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(value = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		EntityManager manager = null;
		try {
			EntityManagerFactory eMF = Persistence.createEntityManagerFactory("Paperino");
			manager = eMF.createEntityManager();
			CarrelloDao cD = new CarrelloDao(manager);
			OrdineDao oD = new OrdineDao(manager);
			ProdottoDao pD = new ProdottoDao(manager);
			RuoloDao rD = new RuoloDao(manager);
			UtenteDao uD = new UtenteDao(manager);
			BusinessLogic bL = new BusinessLogic(manager, cD, oD, pD, rD, uD);
			getServletContext().setAttribute(Constants.CHIAVE_INIT, bL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

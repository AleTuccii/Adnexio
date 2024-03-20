package com.azienda.Adnexio.web;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.model.Prodotto;
import com.azienda.Adnexio.util.BlobConverter;
import com.azienda.Adnexio.util.Constants;
import com.azienda.Adnexio.util.Validator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ricerca")
public class RicercaServlet extends HttpServlet {

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
			String genere1 = (String) (req.getParameter(Constants.GENERE_ACTION));
			String genere2 = (String) (req.getParameter(Constants.GENERE_ARCADE));
			String genere3 = (String) (req.getParameter(Constants.GENERE_ADVENTURE));
			String genere4 = (String) (req.getParameter(Constants.GENERE_PUZZLE));
			String genere5 = (String) (req.getParameter(Constants.GENERE_PLATFORM));
			String genere6 = (String) (req.getParameter(Constants.GENERE_ROGUELIKE));
			String genere7 = (String) (req.getParameter(Constants.GENERE_FPS));
			String genere8 = (String) (req.getParameter(Constants.GENERE_CARDGAME));
			String genere9 = (String) (req.getParameter(Constants.GENERE_GDR));
			String genere10 = (String) (req.getParameter(Constants.GENERE_SIMULAZIONE));
			String piattaforma1 = (String) (req.getParameter(Constants.PIATTAFORMA_PS5));
			String piattaforma2 = (String) (req.getParameter(Constants.PIATTAFORMA_XBOX));
			String piattaforma3 = (String) (req.getParameter(Constants.PIATTAFORMA_PC));
			String piattaforma4 = (String) (req.getParameter(Constants.PIATTAFORMA_SWITCH));
			String localizzazione1 = (String) (req.getParameter(Constants.LOCALIZZAZIONE_EUROPEA));
			String localizzazione2 = (String) (req.getParameter(Constants.LOCALIZZAZIONE_GIAPPONESE));
			String localizzazione3 = (String) (req.getParameter(Constants.LOCALIZZAZIONE_GLOBALE));
			String localizzazione4 = (String) (req.getParameter(Constants.LOCALIZZAZIONE_INDIANA));
			String localizzazione5 = (String) (req.getParameter(Constants.LOCALIZZAZIONE_CINESE));
			String pegi3 = (String) (req.getParameter(Constants.PEGI_3));
			String pegi7 = (String) (req.getParameter(Constants.PEGI_7));
			String pegi12 = (String) (req.getParameter(Constants.PEGI_12));
			String pegi16 = (String) (req.getParameter(Constants.PEGI_16));
			String pegi18 = (String) (req.getParameter(Constants.PEGI_18));
			String prezzoMin = (String) (req.getParameter(Constants.RICERCA_PREZZO_MIN));
			String prezzoMax = (String) (req.getParameter(Constants.RICERCA_PREZZO_MAX));

			List<String> generi = Validator.creaListaRicerca(genere1, genere2, genere3, genere4, genere5, genere6,
					genere7, genere8, genere9, genere10);
			List<String> piattaforme = Validator.creaListaRicerca(piattaforma1, piattaforma2, piattaforma3,
					piattaforma4);
			List<String> localizzazioni = Validator.creaListaRicerca(localizzazione1, localizzazione2, localizzazione3,
					localizzazione4, localizzazione5);
			List<String> pegi = Validator.creaListaRicerca(pegi3, pegi7, pegi12, pegi16, pegi18);

			List<Prodotto> result = bL.ricercaProdotti(titolo, generi, piattaforme, localizzazioni, pegi, prezzoMin,
					prezzoMax);
			req.setAttribute(Constants.CHIAVE_RICERCA_RISULTATO, result);

			aggiungiImmagini(req, result);

			req.getRequestDispatcher("/jsp/pubblica/ricerca.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}

	private void aggiungiImmagini(HttpServletRequest request, List<Prodotto> listResult) throws Exception {
		Map<Integer, String> imagesPath = new HashMap<Integer, String>();
		if (listResult.size() > 0) {
			String uploadPath = getServletContext().getRealPath("") + File.separator + Constants.UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			for (Prodotto p : listResult) {
				String baseHttpUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath();
				Blob blob = p.getImmagine();
				if (blob != null) {
					String filePath = uploadPath + File.separator + p.getId() + "_" + p.getNomeImmagine();
					BlobConverter.saveFile(blob, filePath);
					imagesPath.put(p.getId(), baseHttpUrl + File.separator + Constants.UPLOAD_DIRECTORY + File.separator
							+ p.getId() + "_" + p.getNomeImmagine());
				} else {
					imagesPath.put(p.getId(),
							baseHttpUrl + File.separator + "assets" + File.separator + "AdNEXIO.F.P.png");
				}
			}
		}
		request.setAttribute(Constants.CHIAVE_MAPPA_IMMAGINI, imagesPath);
	}

}

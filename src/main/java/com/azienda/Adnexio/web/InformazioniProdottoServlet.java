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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/prodotto")
public class InformazioniProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BusinessLogic bL = (BusinessLogic) getServletContext().getAttribute(Constants.CHIAVE_INIT);
			String id = (String) req.getParameter(Constants.PRODOTTO_ID);
			Prodotto prodotto = bL.retrieveById(id);
			req.setAttribute(Constants.CHIAVE_PRODOTTO, prodotto);
			aggiungiImmagini(req, List.of(prodotto));
			req.getRequestDispatcher("/jsp/pubblica/prodotto.jsp").forward(req, resp);
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

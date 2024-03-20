package com.azienda.Adnexio.web;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;

import com.azienda.Adnexio.businessLogic.BusinessLogic;
import com.azienda.Adnexio.exception.ModificaIrregolareException;
import com.azienda.Adnexio.exception.ValoreErratoException;
import com.azienda.Adnexio.util.BlobConverter;
import com.azienda.Adnexio.util.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/modificaProdotto")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 10 * 5)
public class ModificaProdottoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BusinessLogic bL = (BusinessLogic) getServletContext().getAttribute(Constants.CHIAVE_INIT);

			String id = (String) (req.getParameter(Constants.PRODOTTO_ID));
			String titolo = (String) (req.getParameter(Constants.TITOLO));
			String genere = (String) (req.getParameter(Constants.GENERE));
			String piattaforma = (String) (req.getParameter(Constants.PIATTAFORMA));
			String localizzazione = (String) (req.getParameter(Constants.LOCALIZZAZIONE));
			String pegi = (String) (req.getParameter(Constants.PEGI));
			String ddr = (String) (req.getParameter(Constants.DDR));
			String sviluppatore = (String) (req.getParameter(Constants.SVILUPPATORE));
			String editore = (String) (req.getParameter(Constants.EDITORE));
			String disponibilita = (String) (req.getParameter(Constants.DISPONIBILITA));
			String prezzo = (String) (req.getParameter(Constants.PREZZO));
			String uploadPath = getServletContext().getRealPath("") + File.separator + Constants.UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			Blob immagine = null;
			String nomeImmagine = null;
			String filePath = null;
			for (Part part : req.getParts()) {
				String fileName = part.getSubmittedFileName();
				if (fileName != null && !fileName.isEmpty()) {
					filePath = uploadPath + File.separator + fileName;
					part.write(filePath);
					immagine = BlobConverter.generateBlob(filePath);
					nomeImmagine = fileName;
				}
			}
		
			bL.modificaProdottoAdmin(id, titolo, genere, piattaforma, localizzazione, pegi, ddr, sviluppatore, editore,
					disponibilita, prezzo, immagine, nomeImmagine);
			
			req.setAttribute(Constants.CHIAVE_MODIFICA_PRODOTTO, "Prodotto modificato con successo");
			
			req.getRequestDispatcher("/jsp/privata/admin/homePrivataAdmin.jsp").forward(req, resp);
		} catch (ValoreErratoException e) {
			req.setAttribute(Constants.CHIAVE_ERRORE_INSERIMENTO_PRODOTTO, e.getMessage());
			req.getRequestDispatcher("/jsp/privata/admin/homePrivataAdmin.jsp").forward(req, resp);
		} catch (ModificaIrregolareException e) {
			req.setAttribute(Constants.CHIAVE_ERRORE_MODIFICA, e.getMessage());
			req.getRequestDispatcher("/jsp/privata/admin/ricercaAdmin.jsp").forward(req, resp); 

		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}

}

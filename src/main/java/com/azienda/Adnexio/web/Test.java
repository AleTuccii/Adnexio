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
import com.azienda.Adnexio.util.BlobConverter;

public class Test {

	public static void main(String[] args) {

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
			bL.iscriviUtente("Mario", "Rossi", "2000-01-15", "Paypal", "3333333333", "adnexio.gameshop@gmail.com",
					"adnexio.gameshop@gmail.com", "Blablabla1!", "Blablabla1!");
			bL.iscriviUtente("Gregorio", "Catalano", "1994-04-28", "Paypal", "3333333333",
					"mrgregoriocatalano@gmail.com", "mrgregoriocatalano@gmail.com", "Blablabla1!", "Blablabla1!");
			bL.iscriviUtente("Alessandro", "Tuccella", "1996-09-20", "Paypal", "3333333333",
					"tuccella.alessandro@gmail.com", "tuccella.alessandro@gmail.com", "Blablabla1!", "Blablabla1!");
			bL.iscriviUtente("Mirko", "Fasone", "1998-01-10", "Paypal", "3333333333", "infabolous@gmail.com",
					"infabolous@gmail.com", "Blablabla1!", "Blablabla1!");
			bL.iscriviUtente("Antonio", "Russo", "1996-12-10", "Paypal", "3333333333", "1996.antonio.russo@gmail.com",
					"1996.antonio.russo@gmail.com", "Blablabla1!", "Blablabla1!");
			bL.iscriviUtente("Lorenzo", "Borrello", "1996-12-07", "Paypal", "3333333333",
					"borrello.lorenzo96@gmail.com", "borrello.lorenzo96@gmail.com", "Blablabla1!", "Blablabla1!");
			bL.iscriviUtente("Luigi", "Ferro", "1999-10-25", "Paypal", "3333333333", "ferroluigi18@gmail.com",
					"ferroluigi18@gmail.com", "Blablabla1!", "Blablabla1!");
			bL.creaAdmin("adnexio.gameshop@gmail.com");
			
			bL.inserisciProdotto("Hades", "RogueLike", "ps5", "2020-09-17", "Supergiant Games", "Supergiant Games",
					"Europea", "50", "12", "30.00", BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Hades.png"),
					"Hades.png");
			
			bL.inserisciProdotto("Hades", "RogueLike", "pc", "2020-09-17", "Supergiant Games", "Supergiant Games",
					"indiana", "50", "12", "30.00", BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Hades.png"),
					"Hades.png");
			
			bL.inserisciProdotto("Metal Gear Solid", "Action", "ps5", "1998-09-03", "Konami", "Konami", "giapponese",
					"50", "16", "30.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/metal-gear-solid-.jpg"),
					"metal-gear-solid-.jpg");
			
			bL.inserisciProdotto("Halo", "fps", "xbox", "2021-11-11", "Xbox Game Studios", "Xbox Game Studios",
					"Europea", "50", "16", "40.00", BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/halo.jpg"),
					"halo.jpg");
			
			
			bL.inserisciProdotto("GTA V", "simulazione", "pc", "2013-11-11", "Rockstar North", "Rockstar Games",
					"Globale", "50", "16", "30.00", BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/GTA V.jpg"),
					"GTA V.jpg");
			bL.inserisciProdotto("GTA VI", "simulazione", "ps5", "2025-11-11", "Rockstar North", "Rockstar Games",
					"Europea", "0", "16", "80.00",
					BlobConverter
							.generateBlob("C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/GTA 6.webp"),
					"GTA 6.webp");
			bL.inserisciProdotto("Call of Duty: Modern Warfare III", "fps", "ps5", "2023-11-10", "Sledgehammer Games",
					" Activision", "Europea", "50", "16", "60.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/cod mw3.jpg"),
					"cod mw3.jpg");
			
			
			bL.inserisciProdotto("Hollow Knight", "Platform", "switch", "2017-02-24", "Team Cherry", "Team Cherry",
					"Europea", "50", "7", "30.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/hollowKnight.webp"),
					"hollowKnight.webp");
			
			
			bL.inserisciProdotto("Prince of Persia", "Platform", "xbox", "2024-01-18", "Ubisoft", "Ubisoft", "Europea",
					"50", "16", "50.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/prince of persia.jpg"),
					"prince of persia.jpg");
			
			bL.inserisciProdotto("Ready Or Not", "fps", "pc", "2023-12-13", "VOID Interactive", "VOID Interactive",
					"Europea", "50", "16", "30.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/ReadyOrNot.webp"),
					"ReadyOrNot.webp");
			bL.inserisciProdotto("Cyberpunk 2077", "gdr", "ps5", "2020-12-10", "CD Projekt", "CD Projekt", "Europea",
					"50", "16", "30.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Cyberpunk.jpeg"),
					"Cyberpunk.jpeg");
			
			
			bL.inserisciProdotto("Baldur's Gate III", "gdr", "xbox", "2021-11-11", "Larian Studios", "Larian Studios",
					"cinese", "50", "16", "49.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/baldur_s.jpg"),
					"baldur_s.jpg");
			
			bL.inserisciProdotto("Baldur's Gate III", "gdr", "pc", "2021-11-11", "Larian Studios", "Larian Studios",
					"globale", "50", "16", "49.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/baldur_s.jpg"),
					"baldur_s.jpg");
			
			bL.inserisciProdotto("Palworld", "simulazione", "xbox", "2024-01-19", "Pocket Pair, Inc.",
					"Pocket Pair, Inc.", "Europea", "50", "16", "39.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/palworld.jpg"),
					"palworld.jpg");
			bL.inserisciProdotto("Stargate", "adventure", "pc", "2024-01-23", "Slitherine Ltd.", "Slitherine Ltd.",
					"Europea", "50", "16", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/stargate.jpeg"),
					"stargate.jpeg");
			bL.inserisciProdotto("The Binding of Isaac", "RogueLike", "pc", "2021-09-28", "Edmund McMillen", "Steam",
					"Europea", "50", "16", "30.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/The Binding of Isaac.webp"),
					"The Binding of Isaac.webp");
			
			
			bL.inserisciProdotto("Avatar Frontiers Of Pandora", "adventure", "xbox", "2023-12-11", "Ubisoft", "Ubisoft",
					"Europea", "50", "16", "30.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/avatar.avif"),
					"avatar.avif");
			
			bL.inserisciProdotto("Total War: Warhammer III", "RogueLike", "pc", "2022-02-17", "Sega", "Sega", "indiana",
					"50", "16", "49.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/total war warhammer 3.jpg"),
					"total war warhammer 3.jpg");
			
			bL.inserisciProdotto("Elden Ring", "gdr", "xbox", "2022-02-25", "FromSoftware", "FromSoftware", "cinese",
					"50", "16", "59.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/elden ring.jpg"),
					"elden ring.jpg");
			bL.inserisciProdotto("Inscryption", "Cardgame", "ps5", "2021-11-11", "Daniel Mullins Games",
					"Devolver Digital", "Europea", "50", "7", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Inscryption.webp"),
					"Inscryption.webp");
			
			
			
			bL.inserisciProdotto("Valorant", "fps", "pc", "2020-06-02", "Riot Games", "Riot Games", "Indiana", "50",
					"16", "30.00",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/valorant.jpeg"),
					"valorant.jpeg");
			
			bL.inserisciProdotto("Cuphead", "Platform", "xbox", "2017-09-27", "Studio MDHR", "Studio MDHR", "Europea",
					"50", "3", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Cuphead.jpg"),
					"Cuphead.jpg");
			bL.inserisciProdotto("Cuphead", "Platform", "pc", "2017-09-27", "Studio MDHR", "Studio MDHR", "indiana",
					"50", "3", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Cuphead.jpg"),
					"Cuphead.jpg");
			
			
			
			bL.inserisciProdotto("Dead Cells", "roguelike", "ps5", "2018-08-07", "Motion Twin", "Motion Twin",
					"Europea", "50", "16", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/DeadCells.jpg"),
					"DeadCells.jpg");
			
			
		
			bL.inserisciProdotto("Returnal", "roguelike", "ps5", "2021-04-30", "Housemark", "PlayStation PC LLC",
					"Giapponese", "20", "16", "59.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/returnal.webp"),
					"returnal.webp");
			
			bL.inserisciProdotto("Celeste", "platorm", "pc", "2018-01-25", "Maddy Makes Games Inc",
					"Maddy Makes Games Inc", "Europea", "50", "16", "14.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Celeste.jpg"),
					"Celeste.jpg");
			
			
			bL.inserisciProdotto("Hi-Fi Rush", "arcade", "xbox", "2023-01-23", "Tango Gameworks", "Bethesda Softwork",
					"Globale", "50", "16", "19.49",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/WiFiRush.jpeg"),
					"WiFiRush.jpeg");
			bL.inserisciProdotto("Terraria", "arcade", "pc", "2011-05-16", "Re-Logic", "Re-Logic", "Indiana", "50",
					"16", "7.49",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Terraria.jpg"),
					"Terraria.jpg");
			
			bL.inserisciProdotto("Metal Slug 3", "arcade", "ps5", "2015-02-14", "SNK CORPORATION", "SNK CORPORATION",
					"Indiana", "50", "16", "7.49",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/metalslug3.jpeg"),
					"metalslug3.jpeg");
			bL.inserisciProdotto("Metal Slug 3", "arcade", "pc", "2015-02-14", "SNK CORPORATION", "SNK CORPORATION",
					"Globale", "50", "16", "7.49",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/metalslug3.jpeg"),
					"metalslug3.jpeg");
			
			bL.inserisciProdotto("Portal 2", "puzzle", "pc", "2011-04-19", "Valve", "Valve", "Globale", "50", "3",
					"8.49",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Portal2.jpg"),
					"Portal2.jpg");
			
			
			bL.inserisciProdotto("Tetris", "puzzle", "pc", "2021-08-21", "Monstars Inc", "Enhance", "Indiana", "50",
					"3", "30.49",
					BlobConverter
							.generateBlob("C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Tetris.jpg"),
					"Tetris.jpg");
			bL.inserisciProdotto("Fc24", "simulazione", "pc", "2023-09-23", "EA Sports FC", "EA Sports FC", "Indiana",
					"50", "3", "29.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Fifa24.webp"),
					"Fifa24.webp");
			
			bL.inserisciProdotto("Fc24", "simulazione", "xbox", "2023-09-23", "EA Sports FC", "EA Sports FC", "globale",
					"50", "3", "29.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/Fifa24.webp"),
					"Fifa24.webp");
			bL.inserisciProdotto("Tekken 8", "action", "pc", "2024-01-25", "Arika", "Bandai Namco", "Globale", "50",
					"16", "49.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/tekken 8.webp"),
					"tekken 8.webp");
			
			bL.inserisciProdotto("Tekken 8", "action", "pc", "2024-01-25", "Arika", "Bandai Namco", "europea", "50",
					"16", "49.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/tekken 8.webp"),
					"tekken 8.webp");
			
			bL.inserisciProdotto("Dead By Daylight", "action", "switch", "2016-06-14", "Behaviour Interactive",
					"505 Games", "europea", "50", "16", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/dead by daylight.webp"),
					"dead by daylight.webp");
			bL.inserisciProdotto("The Front", "fps", "pc", "2023-09-03", "Samar Games", "Samar Games", "europea", "50",
					"16", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/the front.jpg"),
					"the front.jpg");
			
			
			bL.inserisciProdotto("Sunkenland", "adventure", "pc", "2023-08-03", "Vector 3", "Vector 3", "globale", "50",
					"7", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/sunkenland.jpg"),
					"sunkenland.jpg");
			bL.inserisciProdotto("Sunkenland", "adventure", "pc", "2023-08-03", "Vector 3", "Vector 3", "giapponese",
					"50", "7", "19.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/sunkenland.jpg"),
					"sunkenland.jpg");
			bL.inserisciProdotto("For the King 2", "gdr", "pc", "2023-01-01", "Iron Oak", "Iron Oak", "europea", "50",
					"7", "24.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/for the king II.jpg"),
					"for the king II.jpg");
			
			
			bL.inserisciProdotto("Sea of Stars", "gdr", "pc", "2023-08-29", "Sabotage Studio", "Sabotage Studio",
					"Globale", "50", "7", "33.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/SeaofStars.jpg"),
					"SeaofStars.jpg");
			
			bL.inserisciProdotto("Slay the Spire", "cardgame", "xbox", "2017-11-14", "Mega Crit Games",
					"Mega Crit Games", "Giapponese", "50", "7", "24.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/SlayTheSpire.png"),
					"SlayTheSpire.png");
			
			
			bL.inserisciProdotto("Gran Turismo 7", "simulazione", "ps5", "2022-03-04", "Polyphony Digital",
					"Sony Interactive Entertainment", "Giapponese", "50", "3", "59.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/gran turismo 7.webp"),
					"gran turismo 7.webp");
			bL.inserisciProdotto("Microsoft Flight Simulator", "simulazione", "pc", "2020-08-18", "Asobo Studio",
					"Xbox Game Studios", "Globale", "50", "3", "69.99",
					BlobConverter.generateBlob(
							"C:/Users/samsung/OneDrive/Documenti/Jaita100/Adnexio/src/main/webapp/assets/FlightSimulator.jpg"),
					"FlightSimulator.jpg");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			System.exit(0);
		}
	}


		

}



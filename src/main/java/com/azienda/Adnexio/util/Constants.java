package com.azienda.Adnexio.util;

public interface Constants {
	// Costanti Form Iscrizione
	String FORM_NOME = "nome";
	String FORM_COGNOME = "cognome";
	String FORM_DATA = "data";
	String FORM_PAGAMENTO = "pagamento";
	String FORM_TELEFONO = "telefono";
	String FORM_EMAIL = "email";
	String FORM_CONFERMA_EMAIL = "confermaEmail";
	String FORM_PASSWORD = "password";
	String FORM_CONFERMA_PASSWORD = "confermaPassword";
	String CHIAVE_REGISTRAZIONE = "registrazione";
	String MESSAGGIO_REGISTRAZIONE = "Registrazione avvenuta con successo!";
	// Costante InitServlet
	String CHIAVE_INIT = "chiaveInit";
	// Costanti Ruolo
	String UTENTE_SEMPLICE = "Utente Semplice";
	String UTENTE_ADMIN = "Admin";
	// Chiavi errore
	String CHIAVE_ERRORE_REGISTRAZIONE = "erroreRegistrazione";
	String CHIAVE_ERRORE_LOGIN = "erroreLogin";
	String CHIAVE_ERRORE_MODIFICA = "erroreModifica";
	String CHIAVE_ERRORE_INSERIMENTO_PRODOTTO = "erroreInserimentoProdotto";

	// Costanti Form Login
	String LOGIN_EMAIL = "emailLogin";
	String LOGIN_PASSWORD = "passwordLogin";
	// Chiavi Sessione
	String CHIAVE_SESSIONE_UTENTE = "sessioneUtente";
	// Form Ricerca
	String TITOLO = "titolo";
	String GENERE_ACTION = "action";
	String GENERE_ARCADE = "arcade";
	String GENERE_ADVENTURE = "adventure";
	String GENERE_PUZZLE = "puzzle";
	String GENERE_PLATFORM = "platform";
	String GENERE_ROGUELIKE = "roguelike";
	String GENERE_FPS = "fps";
	String GENERE_CARDGAME = "cardgame";
	String GENERE_GDR = "gdr";
	String GENERE_SIMULAZIONE = "simulazione";
	String PIATTAFORMA_PS5 = "ps5";
	String PIATTAFORMA_XBOX = "xbox";
	String PIATTAFORMA_PC = "pc";
	String PIATTAFORMA_SWITCH = "switch";
	String LOCALIZZAZIONE_EUROPEA = "europea";
	String LOCALIZZAZIONE_GIAPPONESE = "giapponese";
	String LOCALIZZAZIONE_GLOBALE = "globale";
	String LOCALIZZAZIONE_INDIANA = "indiana";
	String LOCALIZZAZIONE_CINESE = "cinese";
	String PEGI_3 = "3";
	String PEGI_7 = "7";
	String PEGI_12 = "12";
	String PEGI_16 = "16";
	String PEGI_18 = "18";
	String RICERCA_PREZZO_MIN = "prezzoMax";
	String RICERCA_PREZZO_MAX = "prezzoMin";
	String PREZZO = "prezzo";
	String EDITORE = "editore";
	String DISPONIBILITA = "disponibilita";
	String SVILUPPATORE = "sviluppatore";
	String DDR = "ddr";
	// Chiave Risultati Ricerca
	String CHIAVE_RICERCA_RISULTATO = "chiaveRicerca";

	// Home privata admin
	String PEGI = "pegi";
	String GENERE = "genere";
	String PIATTAFORMA = "piattaforma";
	String LOCALIZZAZIONE = "localizzazione";
	String PRODOTTO_ID = "id";
	String UTENTE_ID = "utenteId";

	// Chiave Messaggio Inserimento prodotto con successo
	String CHIAVE_PRODOTTO_INSERITO = "prodottoInserito";
	// Chiave prodotti carrello utente
	String CHIAVE_PRODOTTI_CARRELLO = "prodottiCarrello";
	// Chiave errore acquisto prodotti
	String CHIAVE_ERRORE_ACQUISTO = "erroreAcquisto";
	// Chiave Lista Utenti
	String CHIAVE_LISTA_UTENTI = "listaUtenti";
	// Chiave Lista Ordini
	String CHIAVE_LISTA_ORDINI = "listaOrdini";
	// Costanti formato login
	String PATTERN_TELEFONO = "[0-9]{10}";
	String PATTERN_EMAIL = "^[a-zA-Z0-9_+&*-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}";
	String PATTERN_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

	String CHIAVE_MODIFICA_CREDENZIALI = "modificaCredenziali";
	String CHIAVE_ERRORE_MODIFICA_CREDENZIALI = "erroreModificaCredenziali";

	String UPLOAD_DIRECTORY = "upload";
	String FILE = "file";
	String CHIAVE_MAPPA_IMMAGINI = "mappaImmagini";
	String CHIAVE_PRODOTTO = "prodotto";
	
	String CHIAVE_RIMOZIONE_PRODOTTO = "rimuoviProdotto";
	String CHIAVE_MODIFICA_PRODOTTO = "modificaProdotto";

	
}

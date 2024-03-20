<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Privata Admin</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/homePrivataAdmin.css">
</head>
<body>

<%

		String successoModifica = (String) request.getAttribute(Constants.CHIAVE_MODIFICA_PRODOTTO);
		String messaggioSuccessoModifica = successoModifica != null ? successoModifica : "";

		String errore = (String) request.getAttribute(Constants.CHIAVE_ERRORE_INSERIMENTO_PRODOTTO);
		String messaggioErrore = errore != null ? errore : "";
		
		String successo = (String) request.getAttribute(Constants.CHIAVE_PRODOTTO_INSERITO);
		String messaggioSuccesso = successo != null ? successo : "";
		
		String erroreAdmin = (String) request.getAttribute(Constants.CHIAVE_RICERCA_RISULTATO);
		String messaggioErroreAdmin = erroreAdmin != null ? erroreAdmin : "";
		
		String erroreModifica = (String) request.getAttribute(Constants.CHIAVE_ERRORE_MODIFICA);
		String messaggioErroreModifica = erroreModifica != null ? erroreModifica : "";
		
		
		
		String successoAdmin = (String) request.getAttribute(Constants.UTENTE_ADMIN);
		String messaggioSuccessoAdmin = successoAdmin != null ? "Utente promosso con successo" : "";
		
		String successoUtente = (String) request.getAttribute(Constants.UTENTE_SEMPLICE);
		String messaggioSuccessoUtente = successoUtente != null ? "Admin declassato con successo!" : "";
	%>
	


	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>
			<div class="cont-msg">
            <div class="successo"><%=messaggioSuccessoModifica%></div>
        </div>

		<div class="body-2">
			<div class="container">
                <header id="titolo">Inserisci il tuo prodotto:</header>
				<form enctype="multipart/form-data" action="<%=request.getContextPath() + "/inserisciProdotto"%>" method="Post">
					<div class="form first">
						<div class="details personal">

							<div class="fields">

								<div class="input-field">
									<label for="<%=Constants.FILE%>">Seleziona file:</label>
									<input type="file" name="<%=Constants.FILE%>" class="customfile">
								</div>
								<div class="input-field">
									<label for="<%=Constants.TITOLO%>">Titolo:</label> <input
										type="text" name="<%=Constants.TITOLO%>" required>
								</div>
								<div class="input-field">
									<label for="<%=Constants.GENERE%>">Genere:</label> <select
										name="<%=Constants.GENERE%>" required>
										<option></option>
										<option value="action">Action</option>
										<option value="arcade">Arcade</option>
										<option value="adventure">Adventure</option>
										<option value="puzzle">Puzzle</option>
										<option value="platform">Platform</option>
										<option value="roguelike">RogueLike</option>
										<option value="fps">FPS</option>
										<option value="gdr">GDR</option>
										<option value="card game">Card Game</option>
										<option value="simulazione">Simulazione</option>
									</select>
								</div>
								<div class="input-field">
									<label for="<%=Constants.PIATTAFORMA%>">Piattaforma:</label> <select
										name="<%=Constants.PIATTAFORMA%>" required>
										<option></option>
										<option value="ps5">PS5</option>
										<option value="xbox">XBOX</option>
										<option value="pc">PC</option>
										<option value="switch">Switch</option>
									</select>
								</div>
								<div class="input-field">
									<label for="<%=Constants.LOCALIZZAZIONE%>">Localizzazione:</label>
									<select name="<%=Constants.LOCALIZZAZIONE%>" required>
										<option></option>
										<option value="europea">Europea</option>
										<option value="giapponese">Giapponese</option>
										<option value="globale">Globale</option>
										<option value="indiana">Indiana</option>
										<option value="cinese">Cinese</option>
									</select>
								</div>
								<div class="input-field">
									<label for="<%=Constants.PEGI%>">Pegi:</label> <select
										name="<%=Constants.PEGI%>" required>
										<option></option>
										<option value="3">PEGI 3</option>
										<option value="7">PEGI 7</option>
										<option value="12">PEGI 12</option>
										<option value="16">PEGI 16</option>
										<option value="18">PEGI 18</option>
									</select>
								</div>
								<div class="input-field">
									<label for="<%=Constants.DDR%>">Data di Rilascio:</label> <input
										type="date" name="<%=Constants.DDR%>" required>
								</div>
								<div class="input-field">
									<label for="<%=Constants.SVILUPPATORE%>">Sviluppatore:</label>
									<input type="text" name="<%=Constants.SVILUPPATORE%>" required>
								</div>
								<div class="input-field">
									<label for="<%=Constants.EDITORE%>">Editore:</label> <input
										type="text" name="<%=Constants.EDITORE%>" required>
								</div>
								<div class="input-field">
									<label for="<%=Constants.DISPONIBILITA%>">Disponibilita':</label>
									<input type="number" name="<%=Constants.DISPONIBILITA%>"
										required>
								</div>
								<div class="input-field">
									<label for="<%=Constants.PREZZO%>">Prezzo:</label> <input
										type="text" name="<%=Constants.PREZZO%>" required>
								</div>
								<div class="reg">
                                    <input type="submit" value="Inserisci">
                                </div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		
        <div class="cont-msg">
            <div class="successo" id="titolo"><%=messaggioSuccesso%></div>
        </div>
        
        <div class="cont-msg">
            <div class="errore" id="titolo"><%=messaggioErrore%></div>
        </div>
        
	<div class="body-2">
		<div class="container" >
            <header id="titolo">Modifica o Rimuovi Prodotto</header>
			<form action="<%=request.getContextPath() + "/ricercaAdmin"%>" method="Post">
				<div class="form first">
					<div class="details personal">
						<div class="fields">
							<div class="input-field">
								<label for="<%=Constants.TITOLO%>">Titolo:</label> <input
									type="text" name="<%=Constants.TITOLO%>">
							</div>
							<div class="input-field">
								<label for="<%=Constants.PIATTAFORMA%>">Piattaforma:</label> <select
									name="<%=Constants.PIATTAFORMA%>" required>
									<option value="ps5">PS5</option>
									<option value="xbox">XBOX</option>
									<option value="pc">PC</option>
									<option value="switch">Switch</option>
								</select>
							</div>
                            <div class="input-field">
                                <label for="<%=Constants.LOCALIZZAZIONE%>">Localizzazione:</label>
								<select name="<%=Constants.LOCALIZZAZIONE%>" required>
									<option value="europea">Europea</option>
									<option value="globale">Globale</option>
									<option value="giapponese">Giapponese</option>
									<option value="indiana">Indiana</option>
									<option value="cinese">Cinese</option>
								</select>
                            </div>
							<div class="reg">
                                <input type="submit" value="Modifica">
                            </div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>


<div class="cont-msg">
    <div class="errore"><%=messaggioErroreModifica%></div>
</div>

<div class="body-2">
    <div class="container">
        <header id="titolo">Assegna Ruolo</header>
            <form action="<%=request.getContextPath() + "/assegnaAdmin" %>" method="post">
                <div class="form first">
                    <div class="details personal">
                        <span class="title">inserisci un'email di un utente da promuovere ad Admin o da declassare</span>

                        <div class="fields">
                            <div class="input-field">
                                <label for="<%=Constants.FORM_EMAIL%>">Email:</label>
                                <input type="text" name="<%=Constants.FORM_EMAIL%>">
                            </div>
                            <div class="reg-2">
                                <input type="submit" name="action" value="Promuovi">
                            </div>
                            <div class="reg-2">
                                <input type="submit" name="action" value="Rimuovi">
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
</div>

<div class="cont-msg">
    <div class="errore" id="titolo"><%=messaggioErroreAdmin%></div>
</div>

<div class="cont-msg">
    <div class="successo" id="titolo">
        <%=messaggioSuccessoAdmin%>
    </div>
</div>

<div class="cont-msg">
    <div class="successo" id="titolo">
        <%=messaggioSuccessoUtente%>
    </div>
    
</div>

<footer>
	<div class="container-fluid">
		<div class="col-12">
			<p>| ADNEXIO |</p>
		</div>
	</div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- Script js -->
    <script src="<%=request.getContextPath()%>/javascript/header.js"></script>
</body>
</html>
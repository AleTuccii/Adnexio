<%@page import="java.io.File"%>
<%@page import="java.util.Map"%>
<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@page import="com.azienda.Adnexio.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Admin</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ricercaAdmin.css">
</head>
<body>

	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>


    <%
    String successo = (String) request.getAttribute(Constants.CHIAVE_PRODOTTO_INSERITO);
	String messaggioSuccesso = successo != null ? successo : "";
	
	String errore = (String) request.getAttribute(Constants.CHIAVE_ERRORE_INSERIMENTO_PRODOTTO);
	String messaggioErrore = errore != null ? errore : "";
	
	
	
	String erroreModifica = (String) request.getAttribute(Constants.CHIAVE_ERRORE_MODIFICA); 
	String messaggioErroreModifica = erroreModifica != null ? erroreModifica : "";
	
	String successoRimozione = (String) request.getAttribute(Constants.CHIAVE_RIMOZIONE_PRODOTTO);
	String messaggioSuccessoRimozione = successoRimozione != null ? successoRimozione : "";
		
		Prodotto result= (Prodotto)request.getAttribute(Constants.CHIAVE_RICERCA_RISULTATO);
    	Map <Integer, String> mappaImmagini = (Map <Integer, String>) request.getAttribute(Constants.CHIAVE_MAPPA_IMMAGINI);
		if(result==null && mappaImmagini == null){
			
	%>

		<div class="no-result" id="titolo"><p>La ricerca non ha prodotto risultati</p></div>
	<%
		}else{
	%>	
	
	
  
<div class="fk-body">


    <div class="container">
        <header id="titolo">Modifica il tuo prodotto:</header>

        <form enctype="multipart/form-data" action="<%=request.getContextPath() + "/modificaProdotto"%>" method="Post">
            <div class="form first">
                <div class="details personal">

                    <div class="fields">
                        <div class="input-field">
                            <label for="<%=Constants.FILE%>">Seleziona file:</label>
									<input type="file" name="<%=Constants.FILE%>" class="customfile">
                        </div>
                        <div class="input-field">
                            <label for="">ID:</label>
                            <input type="text" name="<%=Constants.PRODOTTO_ID%>" value="<%=result.getId()%>" readonly>
                        </div>
                        <div class="input-field">
                            <label for="<%=Constants.TITOLO%>">Titolo:</label>
                            <input type="text" name="<%=Constants.TITOLO%>" value="<%=result.getTitolo()%>" required>
                        </div>
                        <div class="input-field">
                            <label for="<%=Constants.GENERE%>">Genere:</label>
                            <select name="<%=Constants.GENERE%>" required>
                                <option value="<%=result.getGenere()%>"><%=result.getGenere()%></option>
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
                            <label for="<%=Constants.PIATTAFORMA%>">Piattaforma:</label>
                            <select name="<%=Constants.PIATTAFORMA%>" required>
                                <option value="<%=result.getPiattaforma()%>"><%=result.getPiattaforma()%></option>
                                <option value="ps5">PS5</option>
                                <option value="xbox">XBOX</option>
                                <option value="pc">PC</option>
                                <option value="switch">Switch</option>
                            </select>
                        </div>
                        <div class="input-field">
                            <label for="<%=Constants.LOCALIZZAZIONE%>">Localizzazione:</label>
		                    <select name="<%=Constants.LOCALIZZAZIONE%>" required>
                                <option value="<%=result.getLocalizzazione()%>"><%=result.getLocalizzazione()%></option>
                                <option value="europea">Europea</option>
                                <option value="giapponese">Giapponese</option>
                                <option value="globale">Globale</option>
                                <option value="indiana">Indiana</option>
                                <option value="cinese">Cinese</option>
                            </select>
                        </div>
                        <div class="input-field">
                            <label for="<%=Constants.PEGI%>">Pegi:</label>
                            <select name="<%=Constants.PEGI%>" required>
                                <option value="<%=result.getPegi()%>"><%=result.getPegi()%></option>
                                <option value="3">PEGI 3</option>
                                <option value="7">PEGI 7</option>
                                <option value="12">PEGI 12</option>
                                <option value="16">PEGI 16</option>
                                <option value="18">PEGI 18</option>
                            </select>
                        </div>

                        <div class="input-field">
                            <label for="<%=Constants.DDR%>">Data di rilascio:</label>
                            <input type="date" name="<%=Constants.DDR%>" value="<%=result.getDdr()%>" required>
                        </div>
                        <div class="input-field">
                            <label for="<%=Constants.SVILUPPATORE%>">Sviluppatore:</label>
                            <input type="text" name="<%=Constants.SVILUPPATORE%>" value="<%=result.getSviluppatore()%>" required>
                        </div>
                        <div class="input-field">
                            <label for="<%=Constants.EDITORE%>">Editore:</label>
                            <input type="text" name="<%=Constants.EDITORE%>" value="<%=result.getEditore()%>" required>
                        </div>

                        <div class="input-field">
                            <label for="<%=Constants.DISPONIBILITA%>">Disponibilita':</label>
                            <input type="number" name="<%=Constants.DISPONIBILITA%>" value="<%=result.getDisponibilita()%>" required>
                        </div>

                        <div class="input-field">
                            <label for="<%=Constants.PREZZO%>">Prezzo:</label>
                            <input type="text" name="<%=Constants.PREZZO%>" value="<%=result.getPrezzo()%>" required>
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


<div class="cont-msg">
    <div class="errore" id="titolo"><%=messaggioErroreModifica%></div> 
</div>






<div class="fk-body">



<div class="container-2">
    <header id="titolo">Elimina il tuo prodotto</header>

    <form action="<%=request.getContextPath() + "/rimuoviProdotto"%>" method="Post">
        <div class="form first">
            <div class="details personal">

                <div class="fields">
                    <div class="input-field">
                        <label for="<%=Constants.PRODOTTO_ID%>">ID:</label>
                        <input type="text" name="<%=Constants.PRODOTTO_ID%>" value="<%=result.getId()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.TITOLO%>">Titolo:</label>
                        <input type="text" name="<%=Constants.TITOLO%>" value="<%= result.getTitolo()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.GENERE%>">Genere:</label>
                        <input type="text" name="<%=Constants.GENERE%>" value="<%= result.getGenere()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.PIATTAFORMA%>">Piattaforma:</label>
                        <input type="text" name="<%=Constants.PIATTAFORMA%>" value="<%=result.getPiattaforma()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.LOCALIZZAZIONE%>">Localizzazione:</label>
                        <input type="text" name="<%=Constants.LOCALIZZAZIONE%>" value="<%=result.getLocalizzazione()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.PEGI%>">PEGI:</label>
                        <input type="text" name="<%=Constants.PEGI%>" value="<%=result.getPegi()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.DDR%>">Data di Rilascio:</label>
                        <input type="text" name="<%=Constants.DDR%>" value="<%= result.getDdr()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.SVILUPPATORE%>">Sviluppatore:</label>
                        <input type="text" name="<%=Constants.SVILUPPATORE%>" value="<%= result.getSviluppatore()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.EDITORE%>">Editore:</label>
                        <input type="text" name="<%=Constants.EDITORE%>" value="<%= result.getEditore()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.DISPONIBILITA%>">Disponibilità:</label>
                        <input type="text" name="<%=Constants.DISPONIBILITA%>" value="<%= result.getDisponibilita()%>" readonly>
                    </div>
                    <div class="input-field">
                        <label for="<%=Constants.PREZZO%>">Prezzo:</label>
                        <input type="text" name="<%=Constants.PREZZO%>" value="<%= result.getPrezzo()%>" readonly>
                    </div>
                    <div class="reg">
                        <input type="submit" value="Elimina">
                    </div>

                </div>
            </div>
        </div>
    </form>
</div>
</div>

<div class="cont-msg">
    <div class="successo" id="titolo"><%=messaggioSuccessoRimozione%></div>
</div>

<%
		}
	%>	
 
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
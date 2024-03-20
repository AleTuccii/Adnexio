<%@page import="java.util.Map"%>
<%@page import="com.azienda.Adnexio.model.Utente"%>
<%@page import="com.azienda.Adnexio.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizza Ordini</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/visualizzaProdotti.css">
</head>
<body>

	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>

<%	
		Utente utente= (Utente)request.getSession().getAttribute(Constants.CHIAVE_SESSIONE_UTENTE);
		List<Prodotto> result= (List)request.getAttribute(Constants.CHIAVE_RICERCA_RISULTATO);
		Map <Integer, String> mappaImmagini = (Map <Integer, String>) request.getAttribute(Constants.CHIAVE_MAPPA_IMMAGINI);
		if(result==null || result.isEmpty()){
			
	%>
	<div class="no-result" id="titolo">
		<p>La ricerca non ha prodotto risultati</p>
	</div>
<%
	}else{
%>



	<div class="fk-body">
	<div class="container">
		<header id="titolo">Lista Prodotti:</header>
		<div class="form">
			<div class="fields">

	<%
		for(int i=0; i<result.size(); i++){
			
	%>	

						<div class="prodotto">
	<div class="cont-img">
		<div class="img-visual">
			<img src="<%= mappaImmagini.get(result.get(i).getId())%>">
		</div>
	</div>
	<div class="cont-input">
						<div class="input-field">	
							<label>Titolo:</label>
							<input type="text" value="<%=result.get(i).getTitolo()%>" readonly>
						</div>
	
						<div class="input-field">	
							<label>Piattaforma:</label>
							<input type="text" value="<%=result.get(i).getPiattaforma()%>" readonly>
						</div>
	
						<div class="input-field">	
							<label>Numero Acquisti:</label>
							<input type="text" value="<%= result.get(i).getNumeroAcquisti()%>" readonly>
						</div>
						
						<div class="input-field">	
							<label>Ricavo Lordo Totale:</label>
							<input type="text" value="<%=result.get(i).getRicavo()+ "&euro;"%>" readonly>
						</div>

					</div>
				</div>

	<%
		}
	%>
</div>
</div>
</div>
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
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
<title>Ricerca</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
	 <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <link
        rel="stylesheet"
        href="https://site-assets.fontawesome.com/releases/v6.5.1/css/all.css"
      >
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/ricerca.css">
</head>
<body>

<jsp:include page="/jsp/utility/header.jsp"></jsp:include>

	<div class="body-ricerca">
		<div class="container-0">
				
		</div>

		</div>

 <%
		 List<Prodotto> result= (List)request.getAttribute(Constants.CHIAVE_RICERCA_RISULTATO);
		Map <Integer, String> mappaImmagini = (Map <Integer, String>) request.getAttribute(Constants.CHIAVE_MAPPA_IMMAGINI);
		if(result==null || result.isEmpty()){
		%>
		<div class="msg-errore" id="titolo">
			<p>La ricerca non ha prodotto risultati</p>
		</div>


		<%
		} else {
		%>




		<div class="fk-body" id="1">
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
								<img src="<%= mappaImmagini.get(result.get(i).getId())%>" width="50px" height="50px">
								
							</div>
						</div>
						<div class="cont-input">
						<div class="input-field">	
						<label>Titolo:</label>
						<input type="text" value="<%=result.get(i).getTitolo()%>" readonly>
						</div>

						<div class="input-field">	
						<label>Genere:</label>
						<input type="text" value="<%=result.get(i).getGenere()%>" readonly>
						</div>

						<div class="input-field">	
						<label>Piattaforma:</label>
						<input type="text" value="<%=result.get(i).getPiattaforma()%>" readonly>
						</div>
					
						<div class="input-field">	
						<label>Sviluppatore:</label>
						<input type="text" value="<%=result.get(i).getSviluppatore()%>" readonly> 
						</div>

						<div class="input-field">	
						<label>Localizzazione:</label>
						<input type="text" value="<%=result.get(i).getLocalizzazione()%>" readonly> 
						</div>

						<div class="input-field">	
						<label>Disponibilità:</label>
						<input type="text" value="<%=result.get(i).getDisponibilita()%>" readonly> 
						</div>

						<div class="input-field">	
						<label>Pegi:</label>
						<input type="text" value="<%=result.get(i).getPegi()%>" readonly> 
						</div>

						<div class="input-field">	
						<label>Prezzo:</label>
						<input type="text" value="<%=result.get(i).getPrezzo()%>" readonly> 
						</div>

						<form action="<%=request.getContextPath() + "/carrello" %>" method="post">
						<input type="hidden" name="<%=Constants.PRODOTTO_ID%>" value="<%=result.get(i).getId()%>">
						<input type="submit" value="Aggiungi al carrello">
						</form>

						<form action="<%=request.getContextPath() + "/prodotto" %>" method="post">
						<input type="hidden" name="<%=Constants.PRODOTTO_ID%>" value="<%=result.get(i).getId()%>">
						<input type="submit" value="Visualizza">
						</form>
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

<div class="torna-su">
<a href="#" id="tornaSuBtn"><i class="fa-solid fa-chevron-up"></i></a>
</div>
	<!-- Footer -->
	<jsp:include page="/jsp/utility/footer.jsp"></jsp:include>
	<!-- Script icone -->
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<!-- Script Bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
		
		    <script src="<%=request.getContextPath()%>/javascript/header.js"></script>
		    
		    <script src="<%=request.getContextPath()%>/javascript/ricerca.js"></script>
		
</body>
</html>
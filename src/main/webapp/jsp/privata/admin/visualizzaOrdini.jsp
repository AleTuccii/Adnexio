<%@page import="java.text.DecimalFormat"%>
<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@page import="com.azienda.Adnexio.model.Ordine"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordini Utenti</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/visualizzaOrdini.css"></head>
<body>

	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>

	<%	
		float importoTotale=0.000f;
    DecimalFormat formato = new DecimalFormat("#.##");
		List<Ordine> result= (List)request.getAttribute(Constants.CHIAVE_LISTA_ORDINI);
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
		<header id="titolo">Dettagli ordine:</header>
			<form>

	<%
		for(int i=0; i<result.size(); i++){
			
	%>
	


				<div class="fields">
					<div class="input-field">	
						<label for="">N&deg; Ordine:</label>
						<input type="text" value="<%= i+1%>" readonly>
					</div>

					<div class="input-field" id="resoconto">	
						<label for="">Resoconto:</label>
						<p><%= result.get(i).getResoconto()%></p>
					</div>

					<div class="input-field">	
						<label for="">Importo Ordine</label>
						<input type="text" value="<%= result.get(i).getImporto() + "&euro;"%>" readonly> 
					</div>
					<div class="margin"></div>

	<%

   


	
	
		importoTotale= importoTotale+ result.get(i).getImporto();
		
		}
		String numeroFormattato = formato.format(importoTotale);
	%>
	
	


					
				</div>
			</form>
			
			<div class="cont-imp">
				<div class="input-field-importo">	
					<label for="">Importo Totale</label>
					<input type="text" value="<%= numeroFormattato + "&euro;"%>" readonly>
				</div>
			</div>
			
	</div>
</div>
	<%
		}
	%>

	
			
				

	
    
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- Script js -->
    <script src="<%=request.getContextPath()%>/javascript/header.js"></script>
</body>
</html>
<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@page import="com.azienda.Adnexio.model.Ordine"%>
<%@page import="java.util.List"%>
<%@page import="com.azienda.Adnexio.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordini</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/ordini.css">
</head>
<body>
	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>
	<%
	Utente utente= (Utente) request.getSession().getAttribute(Constants.CHIAVE_SESSIONE_UTENTE);
	List<Ordine> result= utente.getOrdini();
	if(result==null || result.isEmpty()){
		
%>
	<div class="cont-msg" id="titolo">
		<div class="errore"><p>Non hai effettuato ordini</p></div>
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
	<div class="input-field" id="resoconto">	
		<label for="">Resoconto: </label>
		<p><%= result.get(i).getResoconto()%></p>
	</div>

	<div class="input-field">	
		<label for="">Data di Acquisto</label>
		<input type="text" value="<%= result.get(i).getDda()%>" readonly>
	</div>

	<div class="input-field">	
		<label for="">Importo</label>
		<input type="text" value="<%= result.get(i).getImporto()%>" readonly>
	</div>
</div>
	
<%
	}
%>

			</form>
	</div>
</div>
	
<%
	}
%>
<jsp:include page="/jsp/utility/footer.jsp"></jsp:include>
<!-- Script js -->
    <script src="<%=request.getContextPath()%>/javascript/header.js"></script>

</body>
</html>
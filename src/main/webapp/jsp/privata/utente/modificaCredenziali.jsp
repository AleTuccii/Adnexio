<%@page import="com.azienda.Adnexio.model.Utente"%>
<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica credenziali</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/modificaCredenziali.css">
<body>

	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>
	
	<%
		Utente utente= (Utente)request.getSession().getAttribute(Constants.CHIAVE_SESSIONE_UTENTE);
		
		String errore = (String) request.getAttribute(Constants.CHIAVE_ERRORE_MODIFICA_CREDENZIALI);
		String messaggioErrore = errore != null ? errore : "";
	%>
	<div class="fk-body">
	<div class="box">
        <div class="square" style="--i:0;"></div>
        <div class="square" style="--i:1;"></div>
        <div class="square" style="--i:2;"></div>
        <div class="square" style="--i:3;"></div>
        <div class="square" style="--i:4;"></div>
        <div class="square" style="--i:5;"></div>
        <div class="square" style="--i:6;"></div>
        <div class="square" style="--i:7;"></div>
        <div class="square" style="--i:8;"></div>
    <div class="container">
        <header id="titolo">Modifica le tue credenziali:</header>
		

	<form action="<%=request.getContextPath()+"/modificaCredenziali"%>" method="post">
		<div class="form first">
			<div class="details personal">
				<span class="title">Dettagli Personali:</span>
				<div class="fields">
		<input type="hidden" name="<%=Constants.UTENTE_ID%>" value="<%=utente.getId()%>">

		<div class="input-field">
			<label for="">Nome:</label>
		<input type="text" name="<%=Constants.FORM_NOME%>" value="<%=utente.getNome()%>" required>
		</div>

		<div class="input-field">
			<label for="">Cognome:</label>
		<input type="text" name="<%=Constants.FORM_COGNOME%>" value="<%=utente.getCognome()%>" required>
		</div>

		<div class="input-field">
			<label for="">Email::</label>
		<input type="email" name="<%=Constants.FORM_EMAIL%>" value="<%=utente.getEmail()%>" required>
		</div>

		
		<div class="input-field">
			<label for="">Conferma Email:</label>
		<input type="text" name="<%=Constants.FORM_CONFERMA_EMAIL%>" placeholder="nuova-email" required>
		</div>

		<div class="input-field">
			<label for="">Password:</label>
		<input type="text" name="<%=Constants.FORM_PASSWORD%>" value="<%=utente.getPassword()%>" required>
		</div>

		<div class="input-field">
			<label for="">Conferma Password:</label>
		<input type="text" name="<%=Constants.FORM_CONFERMA_PASSWORD%>" placeholder="nuova-password" required>
		</div>
<div class="input-field">
	<label for="">Numero Telefono::</label>
		<input type="text" name="<%=Constants.FORM_TELEFONO%>" value="<%=utente.getNumeroTelefono()%>" placeholder="nuovo-tel" required>
</div>
		<div class="input-field">
			<label for="">Data di nascita:</label>
		<input type="date" name="<%=Constants.FORM_DATA %>" value="<%=utente.getDdn()%>" required>
		</div>
		<div class="input-field">
			<label for="">Metodo di pagamento:</label>
		<select name="<%=Constants.FORM_PAGAMENTO%>" required >
			<option id="white" value="<%=utente.getMetodoDiPagamento()%>"><%=utente.getMetodoDiPagamento()%></option>
			<option value="PayPal">Paypal</option>
			<option value="Carta di credito">Carta di credito</option>
			<option value="Carta di debito">Carta di debito</option>
			<option value="Apple Pay">Apple Pay</option>
			<option value="Google Pay">Google Pay</option>
			<option value="Samsung Pay">Samsung Pay</option>
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

<div class="cont-msg"><div class="errore" id="titolo"><p><%=messaggioErrore%></p></div></div>
	
	<!-- Script js -->
    <script src="<%=request.getContextPath()%>/javascript/header.js"></script>
    
</body>
</html>

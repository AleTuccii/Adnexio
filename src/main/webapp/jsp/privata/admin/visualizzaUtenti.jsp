<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@page import="com.azienda.Adnexio.model.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Utenti Registrati</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/visualizzaUtenti.css">
</head>
<body>

	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>

<%	
		Utente utente= (Utente)request.getSession().getAttribute(Constants.CHIAVE_SESSIONE_UTENTE);
		List<Utente> result= (List)request.getAttribute(Constants.CHIAVE_LISTA_UTENTI);
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
			<header id="titolo">Lista Utenti:</header>
				<div class="fk-form">
					<div class="fields">

	<%
		for(int i=0; i<result.size(); i++){
			
	%>	


						<div class="input-field">	
							<label>Nome:</label>
							<input type="text" value="<%= result.get(i).getNome()%>" readonly>
						</div>
	
						<div class="input-field">	
							<label>Cognome:</label>
							<input type="text" value="<%= result.get(i).getCognome()%>" readonly>
						</div>
	
						<div class="input-field">	
							<label>Email:</label>
							<input type="text" value="<%= result.get(i).getEmail()%>" readonly>
						</div>
						
						<div class="input-field">	
							<label>Data di nascita:</label>
							<input type="text" value="<%= result.get(i).getDdn()%>" readonly>
						</div>

						<div class="input-field">	
							<label>Numero di telefono:</label>
							<input type="text" value="<%= result.get(i).getNumeroTelefono()%>" readonly>
						</div>

						<div class="input-field">	
							<label>Metodo di pagamento:</label>
							<input type="text" value="<%= result.get(i).getMetodoDiPagamento()%>" readonly>
						</div>

						<div class="input-field">	
							<label>Ruolo:</label>
							<input type="text" value="<%= result.get(i).getRuolo().getNome()%>" readonly>
						</div>

						<div class="input-field">
							<form action="<%=request.getContextPath() + "/visualizzaOrdini" %>" method="post">
								<input type="hidden" name="<%=Constants.UTENTE_ID%>" value="<%=result.get(i).getId()%>">
								<input type="submit" value="Visualizza Ordini">
							</form>
						</div>
						
						<div class="margin"></div>
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
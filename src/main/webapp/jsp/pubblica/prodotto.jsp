<%@page import="java.util.Map"%>
<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@page import="com.azienda.Adnexio.model.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotto</title>
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()+"/css/prodotto.css"%>">
</head>
<body>

	 <%
		Prodotto prodotto= (Prodotto) request.getAttribute(Constants.CHIAVE_PRODOTTO);
		Map <Integer, String> mappaImmagini = (Map <Integer, String>) request.getAttribute(Constants.CHIAVE_MAPPA_IMMAGINI);
	%> 
<jsp:include page="/jsp/utility/header.jsp"></jsp:include>
	
	
    <div class="content" >
    
        <img src="<%= mappaImmagini.get(prodotto.getId())%>" alt="">

        
    </div>

    <div class="container">
        <div class="cont-img">
            
            <img src="<%= mappaImmagini.get(prodotto.getId())%>" alt="">
        </div>
        <div class="cont-txt">
            <div class="titolo">
                <p><%=prodotto.getTitolo()%></p> 
            </div>
            <div class="info">
                <p><%=prodotto.getPiattaforma()%></p>
                <p><%=prodotto.getLocalizzazione()%></p>
            </div>
            <div class="prezzo">
                <p><%=prodotto.getPrezzo()+"&euro;"%></p>
            </div>
            

            <form action="<%=request.getContextPath()+"/carrello" %>" method="post">
				<input type="hidden" name="<%=Constants.PRODOTTO_ID%>" value="<%=prodotto.getId()%>">
                <button type="submit">Aggiungi al carrello<ion-icon name="cart-outline" id="icona"></ion-icon></button>
                
			</form>
        </div>
        
    </div>

    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
	    <script src="<%=request.getContextPath()%>/javascript/header.js"></script>
	

</body>
</html>
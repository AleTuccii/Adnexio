<%@page import="com.azienda.Adnexio.model.Utente"%>
<%@page import="com.azienda.Adnexio.util.Constants"%>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()+"/css/header.css"%>">
</head>
<%
	Utente utente=(Utente) request.getSession().getAttribute(Constants.CHIAVE_SESSIONE_UTENTE);
	if(utente== null){
%>
<nav>
            <img src="<%=request.getContextPath()%>/assets/Logo91.png" alt="ADNEXIO" class="logo">
            <ul class="navbar">
                <li><a href="<%=request.getContextPath()%>/jsp/pubblica/home.jsp">Home</a></li>
                <li><a href="<%=request.getContextPath()+"/ricerca"%>">Catalogo</a></li>
                <li><a href="<%=request.getContextPath()%>/jsp/pubblica/login.jsp">Registrati</a></li>
            </ul>
            <div class="btnGlow"><a href="<%=request.getContextPath()%>/jsp/pubblica/login.jsp"
                    style="--clr:#b50664"><span>Login</span><i></i></a></div>
            <div class="bx bx-menu" id="menu-icon"></div>
</nav>

<%
	}else if(utente!= null && utente.getRuolo().getNome().equals(Constants.UTENTE_SEMPLICE)){
%>
<nav>
            <img src="<%=request.getContextPath() %>/assets/Logo91.png" alt="ADNEXIO" class="logo">
            <ul class="navbar">
                <li><a href="<%=request.getContextPath()%>/jsp/pubblica/home.jsp">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/jsp/privata/utente/homePrivata.jsp">Area riservata</a></li>
                <li><a href="<%=request.getContextPath()+"/ricerca"%>">Catalogo</a></li>
                <li><a href="<%=request.getContextPath()%>/jsp/privata/utente/carrello.jsp">Carrello</a></li>
                <li><a href="<%=request.getContextPath()%>/jsp/privata/utente/ordini.jsp">Ordini</a></li>
                <li><a href="<%=request.getContextPath()%>/jsp/privata/utente/modificaCredenziali.jsp">Modifica credenziali</a></li>
            </ul>
            <div class="btnGlow"><a href="<%=request.getContextPath()+"/logout"%>"
                    style="--clr:#b50664"><span>Logout</span><i></i></a></div>
            <div class="bx bx-menu" id="menu-icon"></div>
</nav>
<%
	}else if(utente!= null && utente.getRuolo().getNome().equals(Constants.UTENTE_ADMIN)){
%>
<nav>
            <img src="<%=request.getContextPath()%>/assets/Logo91.png" alt="ADNEXIO" class="logo">
            <ul class="navbar">
                <li><a href="<%=request.getContextPath()%>/jsp/pubblica/home.jsp">Home</a></li>
                <li><a href="<%=request.getContextPath()%>/jsp/privata/admin/homePrivataAdmin.jsp">Pannello</a></li>
                <li><a href="<%=request.getContextPath()+"/ricerca"%>">Catalogo</a></li>
                <li><a href="<%=request.getContextPath()%>/jsp/privata/utente/carrello.jsp">Carrello</a></li>
                <li><a href="<%=request.getContextPath() +"/visualizzaProdotti"%>">Prodotti</a></li>
                <li><a href="<%=request.getContextPath() +"/visualizzaUtenti"%>">Utenti</a></li>
                <li><a href="<%=request.getContextPath()%>/jsp/privata/utente/modificaCredenziali.jsp">Modifica credenziali</a></li>    
            </ul>
            <div class="btnGlow"><a href="<%=request.getContextPath()+"/logout"%>"
                    style="--clr:#b50664"><span>Logout</span><i></i></a></div>
            <div class="bx bx-menu" id="menu-icon"></div>
</nav>
<%
	}
%>
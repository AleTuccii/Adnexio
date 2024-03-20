<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">


<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
</head>

<body>
<header class="hdr">
	<nav class="nv">
	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>
	</nav>
</header>
	<%
		String registrazione = (String)request.getAttribute(Constants.CHIAVE_REGISTRAZIONE);
		String messaggioRegistrazione = registrazione != null ? registrazione : "";
		
		String erroreRegistrazione = (String)request.getAttribute(Constants.CHIAVE_ERRORE_REGISTRAZIONE);
		String messaggioErroreRegistrazione = erroreRegistrazione != null ? erroreRegistrazione : "";
		
		String errore = (String) request.getAttribute(Constants.CHIAVE_ERRORE_LOGIN);
		String messaggioErrore = errore!= null ? errore : "";
	%>
	<div class="cont-msg"><div class="successo"><p><%=messaggioRegistrazione %></p></div></div>
	<div class="cont-msg"><div class="errore"><p><%=messaggioErroreRegistrazione %></p></div></div>
	
	  <div class="cont-msg"> <div class="errore"><p><%=messaggioErrore%></p></div></div>
	
	
	<div class="background-container">
        <img class="background-image" src="<%=request.getContextPath()%>/assets/valorant.png" alt="">
        <div class="container" id="container">
            <div class="form-container iscrizione">
                
                    <form action="<%=request.getContextPath()+ "/registrazione"%>"method="post"> 
                    <h1>Crea Account</h1>
                    <label for="<%=Constants.FORM_NOME%>">Nome:</label>
                    <input type="text" name="<%=Constants.FORM_NOME%>" placeholder="Mario" required>
                    <label for="<%=Constants.FORM_COGNOME%>">Cognome:</label>
                    <input type="text" name="<%=Constants.FORM_COGNOME%>" placeholder="Rossi" required>
                    <label for="<%=Constants.FORM_EMAIL%>">Email:</label>
                    <input type="email" name="<%=Constants.FORM_EMAIL%>"
                        pattern="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}"
                        title="Inserisci una email valida" placeholder="mario.rossi@example.com" required>
                    <label for="<%=Constants.FORM_CONFERMA_EMAIL%>">Conferma Email:</label>
                    <input type="email" name="<%=Constants.FORM_CONFERMA_EMAIL%>"
                        pattern="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}"
                        title="Inserisci una email valida" required>
                    <label for="<%=Constants.FORM_PASSWORD%>">Password:</label>
                    <input type="password" name="<%=Constants.FORM_PASSWORD %>"
                        pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!])(?=\S+$).{8,}$"
                        title="Inserisci una password valida (minimo 8 caratteri, una lettera maiuscola, una lettera minuscola, un numero e un carattere speciale)"
                        required>
                    <label for="<%=Constants.FORM_CONFERMA_PASSWORD%>">Conferma Password:</label>
                    <input type="password" name="<%=Constants.FORM_CONFERMA_PASSWORD %>"
                        pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!])(?=\S+$).{8,}$"
                        title="Inserisci una password valida (minimo 8 caratteri, una lettera maiuscola, una lettera minuscola, un numero e un carattere speciale)"
                        required>
                    <label for="<%=Constants.FORM_DATA%>">Data di nascita:</label>
                    <input type="date" name="<%=Constants.FORM_DATA%>" required>
                    <label for="<%=Constants.FORM_TELEFONO%>">Numero di telefono:</label>
                    <input type="text" name="<%=Constants.FORM_TELEFONO%>" pattern="[0-9]{10}" placeholder="3333333333">
                    <span>Metodo di pagamento:</span>
                    <select name="<%=Constants.FORM_PAGAMENTO%>" required>
                        <option value=""></option>
                        <option value="PayPal">Paypal</option>
                        <option value="Carta di credito">Carta di credito</option>
                        <option value="Carta di debito">Carta di debito</option>
                        <option value="Apple Pay">Apple Pay</option>
                        <option value="Google Pay">Google Pay</option>
                        <option value="Samsung Pay">Samsung Pay</option>
                    </select>
                    <button type="submit" value="Registrati">Iscriviti</button>
                </form>
            </div>
            <div class="form-container registrazione">
                
                    <form action="<%=request.getContextPath()+"/login"%>" method="POST"> 
                    <h1>Accedi</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-instagram"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-x-twitter"></i>
                            <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    <span>Inserisci i tuoi dati personali</span>
                    <input type="email" placeholder="Email" name="<%=Constants.LOGIN_EMAIL%>" required>
                    <div class="password-toggle">
                        <input id="password" type="password" name="<%=Constants.LOGIN_PASSWORD%>" placeholder="Password" required>
                        <i class="fa-solid fa-eye" id="occhioAperto"></i>
                        <i class="fa-solid fa-eye-slash" id="occhioChiuso"></i>
                    </div>
                    <button type="submit" value="Login">Login</button>
                    <span class="mr">Torna alla Home.<a href="<%=request.getContextPath()%>/jsp/pubblica/home.jsp"> Clicca
                            Qui</a></span>
                </form>
            </div>
            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>Benvenuto!</h1>
                        <p>Inserisci i tuoi dati personali</p>
                        <button class="hidden" id="login" type="submit" value="Login">Login</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>Crea il tuo Account</h1>
                        <p>Registrati con i tuoi dati personali</p>
                        <button class="hidden" id="register">Iscriviti</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
   
	
	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.1.3/TweenMax.min.js"></script>
	<script src="<%=request.getContextPath()%>/javascript/header.js"></script>
	<script src="<%=request.getContextPath()%>/javascript/login.js"></script>
	
	

</body>
</html>
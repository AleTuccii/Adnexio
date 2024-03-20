<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/registrazione.css">
</head>
<body>
	<%
		String errore = (String) request.getAttribute(Constants.CHIAVE_ERRORE_REGISTRAZIONE);
		String messaggioErrore = errore != null ? errore : "";
	%>

	<div class="box">
		<div class="square" style="--i: 0;"></div>
		<div class="square" style="--i: 1;"></div>
		<div class="square" style="--i: 2;"></div>
		<div class="square" style="--i: 3;"></div>
		<div class="square" style="--i: 4;"></div>
		<div class="square" style="--i: 5;"></div>
		<div class="square" style="--i: 6;"></div>
		<div class="square" style="--i: 7;"></div>
		<div class="square" style="--i: 8;"></div>
		<div class="container">
			<header>Registrazione</header>

			<form action="<%=request.getContextPath()+ "/registrazione"%>"
				method="post">
				<div class="form first">
					<div class="details personal">
						<span class="title">Dettagli Personali:</span>

						<div class="fields">
							<div class="input-field">
								<label for="<%=Constants.FORM_NOME%>">Nome:</label> <input
									type="text" name="<%=Constants.FORM_NOME%>" placeholder="Mario"
									required>
							</div>
							<div class="input-field">
								<label for="<%=Constants.FORM_COGNOME%>">Cognome:</label> <input
									type="text" name="<%=Constants.FORM_COGNOME%>"
									placeholder="Rossi" required>
							</div>
							<div class="input-field">
								<label for="<%=Constants.FORM_DATA%>">Data di nascita:</label> <input
									type="date" name="<%=Constants.FORM_DATA%>" required>
							</div>

							<div class="input-field">
								<label>Metodo di pagamento:</label> <select
									name="<%=Constants.FORM_PAGAMENTO%>" required>
									<option value=""></option>
									<option value="PayPal">Paypal</option>
									<option value="Carta di credito">Carta di credito</option>
									<option value="Carta di debito">Carta di debito</option>
									<option value="Apple Pay">Apple Pay</option>
									<option value="Google Pay">Google Pay</option>
									<option value="Samsung Pay">Samsung Pay</option>
								</select>
							</div>
							<div class="input-field">
								<label for="<%=Constants.FORM_TELEFONO%>">Numero di
									telefono:</label> <input type="text"
									name="<%=Constants.FORM_TELEFONO%>" pattern="[0-9]{10}"
									placeholder="3333333333">
							</div>
							<div class="input-field">
								<label for="<%=Constants.FORM_EMAIL%>">Email:</label> <input
									type="email" name="<%=Constants.FORM_EMAIL%>"
									pattern="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}"
									title="Inserisci una email valida"
									placeholder="mario.rossi@example.com" required>
							</div>

							<div class="input-field">
								<label for="<%=Constants.FORM_CONFERMA_EMAIL%>">Conferma
									Email:</label> <input type="email"
									name="<%=Constants.FORM_CONFERMA_EMAIL%>"
									pattern="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}"
									title="Inserisci una email valida" required>
							</div>
							<div class="input-field">
								<label for="<%=Constants.FORM_PASSWORD%>">Password:</label> <input
									type="password" name="<%=Constants.FORM_PASSWORD %>"
									pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!])(?=\S+$).{8,}$"
									title="Inserisci una password valida (minimo 8 caratteri, una lettera maiuscola, una lettera minuscola, un numero e un carattere speciale)"
									required>
							</div>
							<div class="input-field">
								<label for="<%=Constants.FORM_CONFERMA_PASSWORD%>">Conferma
									Password:</label> <input type="password"
									name="<%=Constants.FORM_CONFERMA_PASSWORD %>"
									pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!])(?=\S+$).{8,}$"
									title="Inserisci una password valida (minimo 8 caratteri, una lettera maiuscola, una lettera minuscola, un numero e un carattere speciale)"
									required>
							</div>
							<div class="reg">
								<input type="submit" value="Registrati">
							</div>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div>
		<p><%=messaggioErrore%></p>
	</div>


</body>
</html>
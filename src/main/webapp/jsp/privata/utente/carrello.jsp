<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.azienda.Adnexio.model.Utente"%>
<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@page import="com.azienda.Adnexio.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrello</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/carrello.css">
</head>
<body>

	<jsp:include page="/jsp/utility/header.jsp"></jsp:include>

<%


	String successo = (String) request.getAttribute(Constants.CHIAVE_PRODOTTO_INSERITO);
	String messaggioSuccesso = successo != null ? successo : "";
	
	String errore = (String) request.getAttribute(Constants.CHIAVE_ERRORE_INSERIMENTO_PRODOTTO);
	String messaggioErrore = errore != null ? errore : "";
	
	
	Utente utente= (Utente) request.getSession().getAttribute(Constants.CHIAVE_SESSIONE_UTENTE);
	List<Prodotto> result= utente.getCarrello().getProdotti();
	
	%>
	
	<div class="cont-msg">
	<div class="successo" id="titolo"><%=messaggioSuccesso%></div>
</div>
<div class="cont-msg">
	<div class="errore" id="titolo"><%=messaggioErrore%></div>
</div>
	
	
	<%
	
	Map <Integer, String> mappaImmagini = (Map <Integer, String>) request.getAttribute(Constants.CHIAVE_MAPPA_IMMAGINI);
	
	if (mappaImmagini == null) {
	    mappaImmagini = new HashMap<Integer, String>();
	    for (Prodotto prodotto : result) {
	        if (prodotto.getImmagine() != null && prodotto.getNomeImmagine() != null){
	        	mappaImmagini.put(prodotto.getId(), request.getContextPath()+ "/assets/" + prodotto.getNomeImmagine());
	        } else {
	        	mappaImmagini.put(prodotto.getId(), request.getContextPath()+ "/assets/" + "AdNEXIO.F.P.png");
	        }
	        
	    }
	}
	
	if(result==null || result.isEmpty()){
		
%>
	<div class="vuoto" id="titolo">
		<p>Carrello vuoto</p>
		<img src="<%=request.getContextPath()%>/assets/Transition_Isaac.webp" alt="">
	</div>
<%
	}else{
%>

<div class="fk-body">
	<div class="container">
		<header id="titolo">Il tuo Carrello:</header>
		<div class="form">
			<div class="fields">
	<%
		for(int i=0; i<result.size(); i++){				
	%> 
			<div class="prodotto">
				
			<div class="img-visual">
				<img src="<%= mappaImmagini.get(result.get(i).getId())%>" width="50px" height="50px">
				
			</div>
			<div class="input-field">
				<label>Titolo</label>
				<input type="text" value="<%= result.get(i).getTitolo()%>" readonly >
			</div>
			<div class="input-field">
				<label>Genere</label>
				<input type="text" value="<%= result.get(i).getGenere()%>" readonly>
			</div>
			<div class="input-field">
				<label>Piattaforma</label>
				<input type="text" value="<%= result.get(i).getPiattaforma()%>" readonly>
			</div>
			<div class="input-field">
				<label>Prezzo</label>
				<input type="text" value="<%= result.get(i).getPrezzo()%>" readonly>
			</div>
			<form action="<%=request.getContextPath() + "/rimuoviProdottoCarrello" %>" method="post" id="form">
				<input type="hidden" name="<%=Constants.PRODOTTO_ID%>" value="<%=result.get(i).getId()%>">
				<input type="submit" value="Rimuovi">
			</form>	
		</div>

<%
	}
%>
<div class="acquista">
	<form  id="myForm" action="<%=request.getContextPath() + "/acquista"%>" method="post">
        <button type="submit">
			<div class="demo">
				<div class="demo__drone-cont demo__drone-cont--takeoff">
					<div class="demo__drone-cont demo__drone-cont--shift-x">
						<div class="demo__drone-cont demo__drone-cont--landing">
							<svg viewBox="0 0 136 112" class="demo__drone">
								<g class="demo__drone-leaving">
									<path class="demo__drone-arm" d="M52,46 c0,0 -15,5 -15,20 l15,10" />
									<path class="demo__drone-arm demo__drone-arm--2" d="M52,46 c0,0 -15,5 -15,20 l15,10" />
									<path class="demo__drone-yellow"
										d="M28,36 l20,0 a20,9 0,0,1 40,0 l20,0 l0,8 l-10,0 c-10,0 -15,0 -23,10 l-14,0 c-10,-10 -15,-10 -23,-10 l-10,0z" />
									<path class="demo__drone-green" d="M16,12 a10,10 0,0,1 20,0 l-10,50z" />
									<path class="demo__drone-green" d="M100,12 a10,10 0,0,1 20,0 l-10,50z" />
									<path class="demo__drone-yellow" d="M9,8 l34,0 a8,8 0,0,1 0,16 l-34,0 a8,8 0,0,1 0,-16z" />
									<path class="demo__drone-yellow" d="M93,8 l34,0 a8,8 0,0,1 0,16 l-34,0 a8,8 0,0,1 0,-16z" />
								</g>
								<path class="demo__drone-package demo__drone-green" d="M50,70 l36,0 l-4,45 l-28,0z" />
							</svg>
						</div>
					</div>
				</div>
				<div class="demo__circle">
					<div class="demo__circle-inner">
						<svg viewBox="0 0 16 20" class="demo__circle-package">
							<path d="M0,0 16,0 13,20 3,20z" />
						</svg>
						<div class="demo__circle-grabbers"></div>
					</div>
					<svg viewBox="0 0 40 40" class="demo__circle-progress">
						<path class="demo__circle-progress-line" d="M20,0 a20,20 0 0,1 0,40 a20,20 0 0,1 0,-40" />
						<path class="demo__circle-progress-checkmark" d="M14,19 19,24 29,14" />
					</svg>
				</div>
				<div class="demo__text-fields">
					<div class="demo__text demo__text--step-0" style="color: white;">Acquista</div>
					<div class="demo__text demo__text--step-1" style="color: white;">
						Controllo
						<span class="demo__text-dots"><span>.</span></span>
					</div>
					<div class="demo__text demo__text--step-2" style="color: white;">
						Ci siamo quasi
						<span class="demo__text-dots"><span>.</span></span>
					</div>
					<div class="demo__text demo__text--step-3" style="color: white;">Un momento...</div>
					<div class="demo__text demo__text--step-4" style="color: white;">Acquistato!</div>
				</div>
				<div class="demo__revert-line"></div>
			</div>

		</button>
    </form>
</div>

	</div>
</div>
</div>
</div>

<%
	}
%>

<jsp:include page="/jsp/utility/footer.jsp"></jsp:include>

<!-- Script js -->
    <script src="<%=request.getContextPath()%>/javascript/header.js"></script>
    <script src="<%=request.getContextPath()%>/javascript/carrello.js"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
</body>
</html>
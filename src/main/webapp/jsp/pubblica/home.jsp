<%@page import="com.azienda.Adnexio.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <title>Home</title>
    <!-- Link Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <!-- Link CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
   	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css">
</head>
<body>
	<header>
            <!-- Navbar -->
            
            <jsp:include page="/jsp/utility/header.jsp"></jsp:include>
    
            <!-- Primo container -->
            <div class="container-0">
                <div class="content-0">
                    <h1>Catalogo<br>Giochi del Mese</h1>
                    <p>Registrati ed accedi ad una vasta libreria di giochi, immergiti nel mondo di Adnexio
                        e fatti avvolgere dai contenuti. Cerca la tua prossima avventura di gioco in base al genere:
                    </p>
                </div>
            </div>
        </header>
    
        <!--Slider Immagini Giochi-->
        <div class="container-1">
            <div class="content-1">
                <h2>Accedi a una Vasta selezione di Giochi</h2>
            </div>
            <div class="wrapper">
                <div class="container">
                    <input type="radio" name="slide" id="c1" class="input" checked>
                    <label for="c1" class="card">
                        <div class="row">
                            <div class="icon">1</div>
                            <div class="description">
                               <a href="<%=request.getContextPath() +"/ricerca?titolo=hollow knight"%>"><h4>Hollow Knight</h4></a>
                                <p>2D ACTION ADVENTURE</p>
                            </div>
                        </div>
                    </label>
                    <input type="radio" name="slide" id="c2" class="input">
                    <label for="c2" class="card">
                        <div class="row">
                            <div class="icon">2</div>
                            <div class="description">
                              <a href="<%=request.getContextPath() +"/ricerca?titolo=hades"%>"><h4>Hades</h4></a>
                                <p>God-like Rogue-like Dungeon</p>
                            </div>
                        </div>
                    </label>
                    <input type="radio" name="slide" id="c3" class="input">
                    <label for="c3" class="card">
                        <div class="row">
                            <div class="icon">3</div>
                            <div class="description">
                                <a href="<%=request.getContextPath() +"/ricerca?titolo=cyberpunk"%>"><h4>CYBERPUNK</h4></a>
                                <p>GDR Openworld futuristico</p>
                            </div>
                        </div>
                    </label>
                    <input type="radio" name="slide" id="c4" class="input">
                    <label for="c4" class="card">
                        <div class="row">
                            <div class="icon">4</div>
                            <div class="description">
                                <a href="<%=request.getContextPath() +"/ricerca?ps5=ps5"%>"><h4>E molto altro ancora</h4></a>
                                <p>Tutto cio' che cerchi a portata di un click</p>
                            </div>
                        </div>
                    </label>
                </div>
            </div>
        </div>
    
        <!-- Container Video Avventura -->
        <div class="container-2">
            <div class="content-2">
                <h3>Inizia la tua avventura</h3>
                <video autoplay muted loop id="myVideo">
                    <source
                        src="https://gaming-cdn.com/videos/products/15737/800x450/assetto-corsa-competizione-gt2-pack-pc-game-steam-preview.webm?v=1706028557"
                        type="video/mp4">
                </video>
            </div>
        </div>
    
        <!-- Container ricerca da modificare con javascript -->
        <section class="container-home3">

            <div class="container-3">
                
                <h2 id="sp-font">Cerca il tuo gioco:</h2>
    
                
    
                <form id="moduloRicerca" action="<%=request.getContextPath()%>/ricerca" method="post" class="form-ricerca">
                    <label for="ricercaBase">Titolo:</label>
                    <input class="input-titolo" type="text" name="<%=Constants.TITOLO%>">
                    <div id="contenitoreRicercaAvanzata" style="display: none;">
                        <!-- Campi di input nascosti per la ricerca avanzata -->
                        <div class="genere" id="fo">
                            <h4> Seleziona il Genere</h4>
                                <div class="ck-back">
                                    <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_ACTION%>" value="action">
                                   <label for="<%=Constants.GENERE_ACTION%>">Action</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_ARCADE%>" value="arcade">
                                   <label for="<%=Constants.GENERE_ARCADE%>">Arcade</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_ADVENTURE%>" value="adventure">
                                   <label for="<%=Constants.GENERE_ADVENTURE%>">Adventure</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_PUZZLE%>" value="puzzle">
                                   <label for="<%=Constants.GENERE_PUZZLE%>">Puzzle</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_PLATFORM%>" value="platform">
                                   <label for="<%=Constants.GENERE_PLATFORM%>">Platform</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_ROGUELIKE%>" value="roguelike">
                                   <label for="<%=Constants.GENERE_ROGUELIKE%>">RogueLike</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_FPS%>" value="fps">
                                   <label for="<%=Constants.GENERE_FPS%>">FPS</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_CARDGAME%>" value="cardgame">
                                   <label for="<%=Constants.GENERE_CARDGAME%>">CardGame</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_GDR%>" value="gdr">
                                   <label for="<%=Constants.GENERE_GDR%>">GDR</label>
                           
                                   <input type="checkbox" class="op-input checkbox" name="<%=Constants.GENERE_SIMULAZIONE%>" value="simulazione">
                                   <label for="<%=Constants.GENERE_SIMULAZIONE%>">Simulazione</label>
                                </div>
                        </div>
                           
                           
                       <div class="piattaforma" id="fo">
                           <h4>Seleziona la piattaforma</h4>
                           
                           <div class="ck-back">
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PIATTAFORMA_PS5%>" value="ps5">
                           <label for="<%=Constants.PIATTAFORMA_PS5%>">PS5</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PIATTAFORMA_XBOX%>" value="xbox">
                           <label for="<%=Constants.PIATTAFORMA_XBOX%>">XBOX</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PIATTAFORMA_PC%>" value="pc">
                           <label for="<%=Constants.PIATTAFORMA_PC%>">PC</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PIATTAFORMA_SWITCH%>" value="switch">
                           <label for="<%=Constants.PIATTAFORMA_SWITCH%>">Switch</label>
                           </div>
                       </div>
                       
                       <div class="localizzazione" id="fo">
                           <h4>Seleziona la localizzazione</h4>
                           <div class="ck-back">
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.LOCALIZZAZIONE_EUROPEA%>" value="europea">
                           <label for="<%=Constants.LOCALIZZAZIONE_EUROPEA%>">Europea</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.LOCALIZZAZIONE_GIAPPONESE%>" value="giapponese">
                           <label for="<%=Constants.LOCALIZZAZIONE_GIAPPONESE%>">Giapponese</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.LOCALIZZAZIONE_GLOBALE%>" value="globale">
                           <label for="<%=Constants.LOCALIZZAZIONE_GLOBALE%>">Globale</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.LOCALIZZAZIONE_INDIANA%>" value="indiana">
                           <label for="<%=Constants.LOCALIZZAZIONE_INDIANA%>">Indiana</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.LOCALIZZAZIONE_CINESE%>" value="cinese">
                           <label for="<%=Constants.LOCALIZZAZIONE_CINESE%>">Cinese</label>
                           </div>
                       </div>
                       
                       <div class="pegi" id="fo">
                           <h4>Scegli il PEGI</h4>
                           <div class="ck-back">
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PEGI_3%>" value="3">
                           <label for="<%=Constants.PEGI_3%>">PEGI 3</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PEGI_7%>" value="7">
                           <label for="<%=Constants.PEGI_7%>">PEGI 7</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PEGI_12%>" value="12">
                           <label for="<%=Constants.PEGI_12%>">PEGI 12</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PEGI_16%>" value="16">
                           <label for="<%=Constants.PEGI_16%>">PEGI 16</label>
                           
                           <input type="checkbox" class="op-input checkbox" name="<%=Constants.PEGI_18%>" value="18">
                           <label for="<%=Constants.PEGI_18%>">PEGI 18</label>
                           </div>
                       </div>
                       
                       <div class="prezzo" id="fp">
                           <h4>Ricerca per prezzo</h4>
                           <label for="<%=Constants.RICERCA_PREZZO_MIN%>">Prezzo minimo:</label>
                           <input type="number" name="<%=Constants.RICERCA_PREZZO_MIN%>">
                           
                           <label for="<%=Constants.RICERCA_PREZZO_MAX%>">Prezzo massimo:</label>
                           <input type="number" name="<%=Constants.RICERCA_PREZZO_MAX%>">
                       </div>
                        
                        
                        <!-- Aggiungi ulteriori campi di input nascosti se necessario -->
            
                
                    </div>
                    <div class="bottone">
                        <button type="button" id="mostraNascondi">+</button>
                    </div>
                   
                    <div class="button">
                        <input type="submit" value="Ricerca">
                    </div>
                </form>
                
            </div>
        </section>
    
    
                <script>
                    document.addEventListener('DOMContentLoaded', function() { 
        var contenitoreRicercaAvanzata = document.getElementById('contenitoreRicercaAvanzata');
        var pulsanteMostraNascondi = document.getElementById('mostraNascondi');
    
        // Aggiungi un gestore di eventi al pulsante
        pulsanteMostraNascondi.addEventListener('click', function() {
            // Cambia la visibilità del contenitore della ricerca avanzata
            if (contenitoreRicercaAvanzata.style.display === 'none') {
                contenitoreRicercaAvanzata.style.display = 'block';
                
            } else {
                contenitoreRicercaAvanzata.style.display = 'none';
            }
        });
    });
                </script>
    
        <!-- Container 4 Video -->
        <div class="container-4">
            <div class="content-4">
                <h3>Unisciti alla battaglia!</h3>
                <video autoplay muted loop id="myVideo">
                    <source
                        src="https://gaming-cdn.com/videos/products/9579/800x450/tekken-8-pc-game-steam-preview.webm?v=1705597733"
                        type="video/mp4">
                </video>
            </div>
        </div>
    
        <div class="container-5">
            <h3 id="sw-title">Scegli il tuo lato della Forza..</h3>
            <div class="container--star">
                <div class="sw-container">
                    <div class="star-wars-section">
                        <input type="range" id="slider" min="0" max="100" step="1" value="0">
                        <div class="character-container">
                            <img src="<%=request.getContextPath()%>/assets/sw-anakin.png" alt="Jedi" id="character-image"> 
                            
                        </div>
                    </div>
                
                    <div class="bundle-container">
                        <p>..e ottieni sconti e altri vantaggi!</p>
                        <p>Entra a far parte della community di Adnexio insieme a migliaia di altri giocatori! </p>
                
                        <a href="<%=request.getContextPath()%>/jsp/pubblica/login.jsp">Iscriviti Subito</a>
                
                        <p id="iscr-msg">Per la Repubblica!</p>
                    </div>
                </div>
            </div>
    
            <div class="container--faq">
                <h3 id="faq-title">FAQ</h3>
                <div class="faq-container">
                    <div class="faq-item">
                        <div class="question" onclick="toggleAnswer('answer1')">Cosa e' Adnexio?
                           
                            <img src="<%=request.getContextPath()%>/assets/AdNexioGamepadLogo.png">
                        </div>
                        <div class="answer" id="answer1">Adnexio e' un sito di vendita di videogiochi per varie piattaforme
                        </div>
                    </div>
                
                    <div class="faq-item">
                        <div class="question" onclick="toggleAnswer('answer2')">Le CD-Key sono ufficiali e legali?
                            
                            <img src="<%=request.getContextPath()%>/assets/AdNexioGamepadLogo.png" width="20px" height="20px">
                        </div>
                        <div class="answer" id="answer2">Questa e' una domanda che sorge spontanea quando si acquista su un sito
                            di questo tipo. Siate certi che le nostre CD-Key sono ufficiali poiche' acquistate da rivenditori
                            autorizzati: Origin, Steam, Battle.net, NCSoft o Uplay. Tutte le nostre carte sono SCANSIONATE dal
                            quelle ufficiali.</div>
                    </div>
                
                    <div class="faq-item">
                        <div class="question" onclick="toggleAnswer('answer3')">Come attivo una CD KEY?
                            
                            <img src="<%=request.getContextPath()%>/assets/AdNexioGamepadLogo.png" width="20px" height="20px">
                        </div>
                        <div class="answer" id="answer3">Una volta scaricato il gioco e' possibile attivarlo nel software. Basta
                            cliccare su "Attiva questo gioco" e inserire il codice per sbloccare il gioco completo. <br> Per
                            esempio per un gioco Origin: e' necessario disporre di un account EA e il software Origin
                            installato. Una volta lanciato, effettua il login, quindi selezionare l'icona ingranaggio, poi
                            "Riscatta codice prodotto." Quindi, dopo aver attivato la CD-key, non dimenticare di aggiornare la
                            lista dei giochi per farlo apparire nella tua libreria.
                        </div>
                    </div>
                
                    <div class="faq-item">
                        <div class="question" onclick="toggleAnswer('answer4')">Perche' acquistare su Adnexio?
                          
                            <img src="<%=request.getContextPath()%>/assets/AdNexioGamepadLogo.png" width="20px" height="20px">
                        </div>
                        <div class="answer" id="answer4">Su Adnexio puoi trovare le CD-KEY dei tuoi giochi preferiti e delle
                            ultime uscite a prezzi scontati grazie alle nostre partership. Potrai inoltre interagire e ricevere
                            consigli dalla nostra community.</div>
                    </div>
                
                    <div class="faq-item">
                        <div class="question" onclick="toggleAnswer('answer5')">E' necessario creare un account per l'acquisto
                            di una CD-KEY?
                           
                            <img src="<%=request.getContextPath()%>/assets/AdNexioGamepadLogo.png" width="20px" height="20px">
                        </div>
                        <div class="answer" id="answer5">Si, per vari motivi: sia per ottenere la CD chiave nella sezione "Il
                            tuo account", ma anche per contattarci tramite il sistema ticket, nel caso richiedesse
                            un'autenticazione.Per creare un account, utilizzare il pannello a destra della pagina principale:
                            https://www.Adnexio.gameshop.com/
                        </div>
                    </div>
                
                    <div class="faq-item">
                        <div class="question" onclick="toggleAnswer('answer6')">Quando si potra' acquistare dal sito?
                            
                            <img src="<%=request.getContextPath()%>/assets/AdNexioGamepadLogo.png" width="20px" height="20px">
                
                        </div>
                        <div class="answer" id="answer6">Non appena ci finanziano ed il backend finisce di fare tuttecose</div>
                    </div>
                
                    <div class="faq-item">
                        <div class="question" onclick="toggleAnswer('answer7')">E la seconda colazione?
                            
                            <img src="<%=request.getContextPath()%>/assets/AdNexioGamepadLogo.png" width="20px" height="20px">
                        </div>
                        <div class="answer" id="answer7">
                            
                            <img src="<%=request.getContextPath()%>/assets/marry&pipin.webp" width="500px" height="auto" id="marry-pipin">
                        </div>
                    </div>
                
                </div>
            </div>
           </div>
    
            <!-- Footer -->
            <jsp:include page="/jsp/utility/footer.jsp"></jsp:include>
            <!-- Script js -->
            <script src="<%=request.getContextPath()%>/javascript/header.js"></script>
    
            <script>
                const slider = document.getElementById('slider');
                const characterImage = document.getElementById('character-image');
                const starWarsSection = document.querySelector('.star-wars-section');
                const bundleContainer = document.querySelector('.bundle-container');
                const msg = document.getElementById('iscr-msg');
                slider.addEventListener('input', () => {
                    const sliderValue = slider.valueAsNumber;
                    const gradientColor = sliderValue > 50 ? 'rgb(206, 0, 0)' : '#87CEEB';
                    const oppositeGradientColor = sliderValue > 50 ? 'rgb(0, 0, 0)' : '#000080';
                    const gradientColor2 = sliderValue > 50 ? 'rgb(206, 0, 0)' : '#87CEEB';
                    const oppositeGradientColor2 = sliderValue > 50 ? 'rgb(0, 0, 0)' : '#000080';
                    characterImage.src = sliderValue > 50 ? '<%=request.getContextPath()%>/assets/vader.png' : '<%=request.getContextPath()%>/assets/sw-anakin.png';
                    
                    starWarsSection.style.backgroundImage = `linear-gradient(to left, ${gradientColor} ${sliderValue}%, ${oppositeGradientColor} ${sliderValue}%)`;
                    bundleContainer.style.backgroundImage = `linear-gradient(to right, ${gradientColor2} ${sliderValue}%, ${oppositeGradientColor2} ${sliderValue}%)`;
    
                    // Aggiungi o rimuovi la classe 'dark-side' in base allo slider
                    if (sliderValue > 50) {
                        starWarsSection.classList.add('dark-side');
                        bundleContainer.classList.add('bundle-container-ds');
                        msg.innerHTML = 'Abbiamo i biscottini';
                    } else {
                        starWarsSection.classList.remove('dark-side');
                        bundleContainer.classList.remove('bundle-container-ds');
                        msg.innerHTML = 'Per la Repubblica!';
                    }
                });
            </script>
            <script src="/header/script.js"></script>
            <script src="<%=request.getContextPath()%>/javascript/home.js"></script>
            <!-- Script icone -->
            <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
            <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>
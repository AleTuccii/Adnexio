<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Privata</title>
	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/homePrivata.css">
</head>
<body>


            
    <div class="content">
            
            
            <jsp:include page="/jsp/utility/header.jsp"></jsp:include>
            

            <div class="testo">
                <h6>Out Now</h6>
                <a href="<%=request.getContextPath() +"/ricerca?titolo=sea of stars"%>"><h5>Prenota</h5></a>
                <p>44.79&euro;</p>
            </div>


        </div>
    
    <span><h3> Trending </h3></span>
<div class="flex-container">
    <div class="container-1">
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/14324/380x218/prince-of-persia-the-lost-crown-pc-game-ubisoft-connect-europe-cover.jpg?v=1706112000" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=prince of persia"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/14324/800x450/prince-of-persia-the-lost-crown-pc-game-ubisoft-connect-europe-preview.webm?v=1705655068" autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Prince of Persia</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/2075/380x218/ready-or-not-pc-game-steam-cover.jpg?v=1706112000" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=ready or not"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/2075/800x450/ready-or-not-pc-game-steam-preview.webm?v=1657027479" autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Ready or not</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/14769/380x218/cyberpunk-2077-ultimate-edition-ultimate-edition-pc-game-gog-com-cover.jpg?v=1706112000" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=cyberpunk"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/14769/800x450/cyberpunk-2077-ultimate-edition-ultimate-edition-pc-game-gog-com-preview.webm?v=1691678661"  autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Cyberpunk</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/4804/616x353/baldur-s-gate-iii-pc-gioco-gog-com-cover.jpg?v=1701269874" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=Baldur"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/4804/800x450/baldur-s-gate-iii-pc-game-gog-com-preview.webm?v=1677240334"  autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Baldur's Gate III</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://www.instant-gaming.com/images/products/8982/380x218/8982.jpg?v=1705942170" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=palworld"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/8982/800x450/palworld-pc-game-steam-preview.webm?v=1705673187"  autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Palworld</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/15456/380x218/stargate-timekeepers-pc-game-steam-europe-cover.jpg?v=1706112000" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=stargate"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/15456/800x450/stargate-timekeepers-pc-game-steam-europe-preview.webm?v=1701270466" autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Star Gate</p>
            </div>
        </div>
    </div>
</div>

<div class="separate">
   
</div>

<span><h3> Bestsellers </h3></span>
<div class="flex-container">
    <div class="container-1">
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/9014/380x218/avatar-frontiers-of-pandora-pc-game-ubisoft-connect-europe-cover.jpg?v=1706259600" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=avatar"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/9014/800x450/avatar-frontiers-of-pandora-pc-game-ubisoft-connect-europe-preview.webm?v=1694786934" autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Avatar</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/14916/380x218/total-war-warhammer-trilogy-pc-mac-game-steam-europe-cover.jpg?v=1706259600" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=warhammer"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/14916/800x450/total-war-warhammer-trilogy-pc-mac-game-steam-europe-preview.webm?v=1693484026" autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Warhammer</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/4824/380x218/elden-ring-pc-game-steam-europe-cover.jpg?v=1706259600" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=elden ring"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/4824/800x450/elden-ring-pc-game-steam-europe-preview.webm?v=1657036138"  autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Elden Ring</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/9579/380x218/tekken-8-pc-game-steam-cover.jpg?v=1706263200" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=tekken 8"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/9579/800x450/tekken-8-pc-game-steam-preview.webm?v=1705597733"  autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Tekken 8</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/4211/380x218/grand-theft-auto-v-premium-online-edition-premium-online-edition-pc-game-rockstar-cover.jpg?v=1706263200" class="card-img-top" alt="...">
            <a href="<%=request.getContextPath() +"/ricerca?titolo=gta v"%>"><div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/4211/800x450/grand-theft-auto-v-premium-online-edition-premium-online-edition-pc-game-rockstar-preview.webm?v=1657029673"  autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">GTA V</p>
            </div>
        </div>
        <div class="card" style="width: 22rem;">
            <img src="https://gaming-cdn.com/images/products/1904/380x218/dead-by-daylight-pc-game-steam-cover.jpg?v=1706263200" class="card-img-top" alt="...">
           <a href="<%=request.getContextPath() +"/ricerca?titolo=dead by daylight"%>"> <div class="video-overlay">
                <video id="video-modal" src="https://gaming-cdn.com/videos/products/1904/800x450/dead-by-daylight-pc-game-steam-preview.webm?v=1681376858" autoplay loop muted ></video>
            </div></a>
            <div class="card-body">
              <p class="card-text">Dead by Daylight</p>
            </div>
        </div>
    </div>
</div>


<span><h3>Giochi Indie</h3></span>
<div class="card-indie">


<div class="container-indie-2"> 

    <div class="flex-container">
        <img src="<%=request.getContextPath()%>/assets/beheaded.webp" id="deadcell-pg">
        <div class="container-1">
            <div class="card" style="width: 22rem;">
                <img src="https://gaming-cdn.com/images/products/15069/380x218/the-front-pc-game-steam-cover.jpg?v=1706270400" class="card-img-top" alt="...">
                <a href="<%=request.getContextPath() +"/ricerca?titolo=the front"%>"><div class="video-overlay">
                    <video id="video-modal" src="https://gaming-cdn.com/videos/products/15069/800x450/the-front-pc-game-steam-preview.webm?v=1695650515" autoplay loop muted ></video>
                </div></a>
                <div class="card-body">
                  <p class="card-text">The Front</p>
                </div>
            </div>
            <div class="card" style="width: 22rem;">
                <img src="https://gaming-cdn.com/images/products/14828/380x218/sunkenland-pc-game-steam-cover.jpg?v=1706270400" class="card-img-top" alt="...">
               <a href="<%=request.getContextPath() +"/ricerca?titolo=sunkenland"%>"> <div class="video-overlay">
                    <video id="video-modal" src="https://gaming-cdn.com/videos/products/14828/800x450/sunkenland-pc-game-steam-preview.webm?v=1692722433" autoplay loop muted ></video>
                </div></a>
                <div class="card-body">
                  <p class="card-text">Sunkeland</p>
                </div>
            </div>
            <div class="card" style="width: 22rem;">
                <img src="https://gaming-cdn.com/images/products/13618/380x218/for-the-king-ii-pc-game-steam-europe-cover.jpg?v=1706270400" class="card-img-top" alt="...">
               <a href="<%=request.getContextPath() +"/ricerca?titolo=for the king "%>"> <div class="video-overlay">
                    <video id="video-modal" src="https://gaming-cdn.com/videos/products/13618/800x450/for-the-king-ii-pc-game-steam-europe-preview.webm?v=1676985231" autoplay loop muted ></video>
                </div></a>
                <div class="card-body">
                  <p class="card-text">For the Kingdom II</p>
                </div>
            </div>
            <div class="card" style="width: 22rem;">
                <img src="https://gaming-cdn.com/images/products/12451/380x218/sea-of-stars-pc-game-steam-cover.jpg?v=1696579885" class="card-img-top" alt="...">
                <a href="<%=request.getContextPath() +"/ricerca?titolo=sea of stars"%>"><div class="video-overlay">
                    <video id="video-modal" src="https://gaming-cdn.com/videos/products/12451/800x450/sea-of-stars-pc-game-steam-preview.webm?v=1675944097" autoplay loop muted ></video>
                </div></a>
                <div class="card-body">
                  <p class="card-text">Sea of Stars</p>
                </div>
            </div>
        </div>

    </div>
</div>
</div>

<div class="container--card">
        <div class="container--min">
            <a href="<%=request.getContextPath() +"/ricerca?arcade=arcade"%>" class="item" style="background-image: url(assets/2.jpg);">
                <div class="content--card">
                    <div class="name">Arcade</div>
                    <div class="cover" style="background-image: url(assets/1.png);">
                    </div>
                </div>
            </a>
            <a href="<%=request.getContextPath() +"/ricerca?platform=platform"%>" class="item" style="background-image: url(assets/4.jpg);">
                <div class="content--card">
                    <div class="name">Platform</div>
                    <div class="cover" style="background-image: url(assets/3.png);">
                    </div>
                </div>
            </a>
            <a href="<%=request.getContextPath() +"/ricerca?fps=fps"%>" class="item" style="background-image: url(assets/5.jpg);">
                <div class="content--card">
                    <div class="name">FPS</div>
                    <div class="cover" style="background-image: url(assets/6.png);">
                    </div>
                </div>
            </a>
            <a href="<%=request.getContextPath() +"/ricerca?action=action"%>" class="item" style="background-image: url(assets/8.jpg);">
                <div class="content--card">
                    <div class="name">Azione</div>
                    <div class="cover" style="background-image: url(assets/7.png);">
                    </div>
                </div>
            </a>
            <a href="<%=request.getContextPath() +"/ricerca?roguelike=roguelike"%>" class="item" style="background-image: url(assets/12.jpg);">
                <div class="content--card">
                    <div class="name">RogueLike</div>
                    <div class="cover" style="background-image: url(assets/11.png);">
                    </div>
                </div>
            </a>
            <a href="<%=request.getContextPath() +"/ricerca?adventure=adventure"%>" class="item" style="background-image: url(assets/10.jpg);">
                <div class="content--card">
                    <div class="name">Avventura</div>
                    <div class="cover" style="background-image: url(assets/9.png);">
                    </div>
                </div>
            </a>
            <a href="<%=request.getContextPath() +"/ricerca?cardgame=cardgame"%>" class="item" style="background-image: url(assets/14.jpg)">
                <div class="content--card">
                    <div class="name">Cardgame</div>
                    <div class="cover" style="background-image: url(assets/13.png);">
                    </div>
                </div>
            </a>
            <a href="<%=request.getContextPath() +"/ricerca?gdr=gdr"%>" class="item" style="background-image: url(assets/16.jpg);">
                <div class="content--card">
                    <div class="name">GDR</div>
                    <div class="cover" style="background-image: url(assets/15.png);">
                    </div>
                </div>
            </a>
            <a href="<%=request.getContextPath() +"/ricerca?simulazione=simulazione"%>" class="item" style="background-image: url(assets/18.jpg);">
                <div class="content--card">
                    <div class="name">Simulazione</div>
                    <div class="cover" style="background-image: url(assets/17.png);">
                    </div>
                </div>
            </a>
        </div>
    </div>

   
    
   
   

<!-- Footer -->
<jsp:include page="/jsp/utility/footer.jsp"></jsp:include>

    <!-- Scripts -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="<%=request.getContextPath()%>/js/script.js"></script>
    

	<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
	
	<!-- Script js -->
    <script src="<%=request.getContextPath()%>/javascript/header.js"></script>

</body>
</html>
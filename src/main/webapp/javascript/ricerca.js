// Rileva lo scroll della finestra
window.onscroll = function() {
// Verifica se si è scesi di almeno 300 pixel
if (document.body.scrollTop > 300 || document.documentElement.scrollTop > 300) {
document.getElementById("tornaSuBtn").style.display = "block";
} else {
document.getElementById("tornaSuBtn").style.display = "none";
}
};

// Gestisce il clic sul tasto "Torna Su"
document.getElementById("tornaSuBtn").onclick = function() {
// Torna all'inizio della pagina con un'animazione fluida
window.scrollTo({ top: 0, behavior: 'smooth' });
};
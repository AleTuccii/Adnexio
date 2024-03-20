
const $demo = document.querySelector('.demo');
let processing = false;

$demo.addEventListener('click', () => {
    if (processing) return;
    let reverting = false;
    processing = true;
    const $endListener = document.createElement('div');
    $endListener.classList.add('demo-transitionend-listener');
    $demo.appendChild($endListener);
    const layoutTrigger = $demo.offsetTop;
    $demo.classList.add('s--processing');

    $endListener.addEventListener('transitionend', () => {
        if (reverting) return;
        reverting = true;
        $demo.classList.add('s--reverting');
    });

    setTimeout(() => {
        $demo.removeChild($endListener);
        $demo.classList.remove('s--processing', 's--reverting');
        processing = false;
    }, 10000);
});

document.getElementById('myForm').addEventListener('submit', function(event) {
    // Impedisci l'invio del modulo
    event.preventDefault();

    // Aggiungi qui la logica per l'attesa
    // Ad esempio, utilizzando la funzione setTimeout
    setTimeout(function() {
      // Dopo l'attesa, puoi inviare il modulo programmatically
      document.getElementById('myForm').submit();
    }, 6500); 
});
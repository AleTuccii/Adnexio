/* btn animazione login e registrazione*/

const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
    container.style.minHeight = 'auto';
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
    container.style.minHeight = '480px';
});


/* modifia la classe container per adattare il form della registrazione*/
document.getElementById('register').addEventListener('click', function () {
    if (container.style.minHeight !== '720px') {

        container.style.minHeight = '730px';
    } else {

        container.style.minHeight = 'auto';
    }
});


/* animazione della icona per vedere la password */
const password = document.getElementById('password');
const occhioAperto = document.getElementById('occhioAperto');
const occhioChiuso = document.getElementById('occhioChiuso');

occhioAperto.addEventListener('click', function () {
    password.type = 'text';
    occhioAperto.style.display = 'none';
    occhioChiuso.style.display = 'inline';
});

occhioChiuso.addEventListener('click', function () {
    password.type = 'password';
    occhioAperto.style.display = 'inline';
    occhioChiuso.style.display = 'none';
});


/* Animation Gsap */

TweenMax.from(".background-image", 1, {
    opacity: 0,
    delay: 1.3,
    x: -800,
    ease: Expo.easeInOut,
});

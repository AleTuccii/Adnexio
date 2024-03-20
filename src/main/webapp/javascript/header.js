/* responsive menu */

let menu = document.getElementById('menu-icon');
let navbar = document.querySelector('.navbar');


menu.addEventListener('click', function(){
    menu.classList.toggle('bx-x');
    navbar.classList.toggle('open');
});

function toggleAnswer(answerId) {
   let answer = document.getElementById(answerId);
   let allAnswers = document.getElementsByClassName('answer');
  
   if (answer.style.display === 'block') {
       answer.style.display = 'none';
   } else {
       answer.style.display = 'block';
      
       // Chiudi tutti gli altri elementi con classe 'answer'
       for (let i = 0; i < allAnswers.length; i++) {
           if (allAnswers[i].id !== answerId) {
               allAnswers[i].style.display = 'none';
           }
       }
   }
}

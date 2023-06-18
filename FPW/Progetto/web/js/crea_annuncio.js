 /* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

import * as utils from './utils.js';

window.onload = function(){
    var form = document.getElementById('creaAnnuncio');
    var messaggioErrore = document.getElementById('messaggioErrore');
    var titolo = document.getElementById('titolo');
    var prezzo = document.getElementById('prezzo');
    var descrizione = document.getElementById('descrizione');
    var telefono = document.getElementById('telefono');
    var radio1 = document.getElementById('veicolo');
    var radio2 = document.getElementById('componente');
    var invia = document.getElementById('pulsante');
    
    invia.onclick = function(){
        messaggioErrore.style.display = "none";
        var errore = "";
        if(utils.controllaStringa(titolo.value, 3, 30))
            errore = "La lunghezza del titolo dev'essere compresa tra i 3 e i 30 caratteri";
        if(utils.controllaIntero(prezzo.value, 1, 999999999))
            errore = "Il prezzo dev'essere maggiore di 0 e minore di 999999999";
        if(utils.controllaStringa(descrizione.value, 20, 800))
            errore = "La lunghezza della descrizione dev'essere compresa tra i 20 e i 1000 caratteri";
        if(utils.controllaStringa(telefono.value, 7, 15) || utils.controllaTelefono(telefono.value))
            errore = "Inserire un numero di telefono corretto";
        if(!radio1.checked && !radio2.checked)
            errore = "Scegliere la tipologia di prodotto";
        
        if(errore !== ""){
            messaggioErrore.innerHTML = errore;
            messaggioErrore.style.display = "block";
        }
        else
            form.submit();
    };
    
};

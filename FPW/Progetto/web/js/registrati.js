/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

import * as utils from './utils.js';

window.onload = function(){
    var form = document.getElementById('registrazione');
    var messaggioErrore = document.getElementById('messaggioErrore');
    var username = document.getElementById('username');
    var password = document.getElementById('password');
    var email = document.getElementById('email');
    var telefono = document.getElementById('telefono');
    var invia = document.getElementById('pulsante');
    
    invia.onclick = function(){
        messaggioErrore.style.display = "none";
        var errore = "";
        if(utils.controllaStringa(username.value, 3, 20))
            errore = "La lunghezza dell'username dev'essere compresa tra i 3 e i 20 caratteri";
        if(utils.controllaStringa(password.value, 5, 20))
            errore = "La lunghezza della password dev'essere compresa tra i 5 e i 20 caratteri";
        if(utils.controllaStringa(email.value, 5, 50)) // Per controllare la lunghezza dell'email
            errore = "La lunghezza della email dev'essere compresa tra i 5 e i 50 caratteri";
        if(utils.controllaEmail(email.value)) // Per controllare la correttezza dell'email
            errore = "L'email deve contenere una @";
        if(utils.controllaStringa(telefono.value, 7, 15) || utils.controllaTelefono(telefono.value))
            errore = "Inserire un numero di telefono corretto";
        
        if(errore !== ""){
            messaggioErrore.innerHTML = errore;
            messaggioErrore.style.display = "block";
        }
        else
            form.submit();
    };
    
};
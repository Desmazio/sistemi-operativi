/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

import * as utils from './utils.js';

window.onload = function(){
    var form = document.getElementById('login');
    var messaggioErrore = document.getElementById('messaggioErrore');
    var username = document.getElementById('username');
    var password = document.getElementById('password');
    var invia = document.getElementById('pulsante');
    
    invia.onclick = function(){
        messaggioErrore.style.display = "none";
        var errore = "";
        if(utils.controllaStringa(username.value, 3, 20))
            errore = "La lunghezza dell'username dev'essere compresa tra i 3 e i 20 caratteri";
        if(utils.controllaStringa(password.value, 5, 20))
            errore = "La lunghezza della password dev'essere compresa tra i 5 e i 20 caratteri";
        
        if(errore !== ""){
            messaggioErrore.innerHTML = errore;
            messaggioErrore.style.display = "block";
        }
        else
            form.submit();
    };
    
};


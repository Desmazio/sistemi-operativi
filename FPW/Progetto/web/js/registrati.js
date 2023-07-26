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
        if(utils.controllaStringa(email.value, 5, 30)) // Per controllare la lunghezza dell'email
            errore = "La lunghezza della email dev'essere compresa tra i 5 e i 50 caratteri";
        if(utils.controllaEmail(email.value)) // Per controllare la correttezza dell'email
            errore = "L'email deve contenere una @";
        if(utils.controllaStringa(telefono.value, 7, 13) || utils.controllaTelefono(telefono.value))
            errore = "Inserire un numero di telefono corretto";
        
        if(errore !== ""){
            messaggioErrore.innerHTML = errore;
            messaggioErrore.style.display = "block";
        }
        else
            form.submit();
    };
    
    username.onkeyup = function(){
        var contaText = document.getElementsByClassName('contaCaratteri')[0];
        var min = 3;
        var max = 20;
        contaText.innerText = "/" + max;
        contaText.innerText = this.value.length + contaText.innerText;
        
        if(this.value.length > max || this.value.length < min)
            contaText.style.color = 'red';
        else
            contaText.style.color = '#3c4858';
        
    };
    
    email.onkeyup = function(){
        var contaText = document.getElementsByClassName('contaCaratteri')[1];
        var min = 5;
        var max = 30;
        contaText.innerText = "/" + max;
        contaText.innerText = this.value.length + contaText.innerText;
        
        if(this.value.length > max || this.value.length < min)
            contaText.style.color = 'red';
        else
            contaText.style.color = '#3c4858';
        
    };
    
    password.onkeyup = function(){
        var contaText = document.getElementsByClassName('contaCaratteri')[2];
        var min = 5;
        var max = 20;
        contaText.innerText = "/" + max;
        contaText.innerText = this.value.length + contaText.innerText;
        
        if(this.value.length > max || this.value.length < min)
            contaText.style.color = 'red';
        else
            contaText.style.color = '#3c4858';
        
    };
    
    telefono.onkeyup = function(){
        var contaText = document.getElementsByClassName('contaCaratteri')[3];
        var max = 13;
        var min = 7;
        contaText.innerText = "/" + max;
        contaText.innerText = this.value.length + contaText.innerText;
        
        if(this.value.length > max || this.value.length < min)
            contaText.style.color = 'red';
        else
            contaText.style.color = '#3c4858';
        
    };
    
};
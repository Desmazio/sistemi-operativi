/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

window.onload = function(){
    var aumenta = document.getElementById('aumenta');
    var diminuisci = document.getElementById('diminuisci');
    var main = document.getElementsByTagName('main');
    
    var valore = "100%";
    
    aumenta.onclick = function(){
        if(valore === "100%")
            valore = "150%";
        else if(valore === "75%")
            valore = "100%";
        
        main[0].style.fontSize = valore;
        
    };
    
    diminuisci.onclick = function(){
        if(valore === "100%")
            valore = "75%";
        else if(valore === "150%")
            valore = "100%";
        
        main[0].style.fontSize = valore;
    };
    
};

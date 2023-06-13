/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

// Funzioni per controllare gli input dell'utente, se la funzione ritorna true l'input è errato, altrimenti è corretto

export function controllaStringa(stringa, min, max){
    if(stringa.length < min || stringa.length > max)
        return true;
    return false;
}

export function controllaIntero(stringa, min, max){
    var valore = parseInt(stringa);
    if((valore < min || valore > max) || isNaN(valore))
        return true;
    return false;
}

export function controllaEmail(stringa, min, max){
    return !stringa.includes("@");
}

export function controllaTelefono(stringa){
    var valore = parseInt(stringa);
    return isNaN(valore);
}

export function controllaRadio(radio){
    for(var i = 0; i < radio.length; i++)
        if(radio[i].checked)
            return false;
    return true;
}

<%-- 
    Document   : chi_siamo
    Created on : 14 mag 2023, 21:38:17
    Author     : paual
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Autoshop Marketplace</title>
        <link rel="icon" href="img/logo_piccolo.png" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/chi_siamo.css" media="screen">
        <meta charset="UTF-8">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main>
            <article>
                <img class="profilo" src="img/delta.png" alt="Immagine di profilo">
                <p>ALESSANDRO PAU</p>
                <p>Ex piltoa di Rally, raggiunse il picco della sua carriera nel 1989 con la vincita del campionato mondiale alla guida della Lancia Delta HF. Dopo un brutto incidente decide di continuare gli studi e diventare un web developer</p>
            </article>
            <article>
                <img class="profilo" src="img/f1.png" alt="Immagine di profilo">
                <p>ALESSANDRO TODDE</p>
                <p>Dopo un'incredibile carriera nel campo della Formula 1, nella qualle ha corso con pluripremiate scuderie come McLaren e Mercedes, decide di ritirarsi per seguire la sua vera passione, la programmazione web</p>
            </article>
            <!--<article>
                <img class="profilo" src="img/profile.jpg" alt="Immagine di profilo">
                <p>MARCO PISANU</p>
            </article>-->
            <article>
                <img class="profilo" src="img/endurance.png" alt="Immagine di profilo">
                <p>FRANCESCO SIMBOLA</p>
                <p>Tra i piloti più famosi e rispettati nel campo dell'Endurance, partecipò a numerose stagioni della 24 Ore di Le Mans, riuscendo ad arrivare al podio ben 5 volte e a vincere l'edizione del 1994. Una volta ritiratosi, intraprese la carriera come web developer da hobbista</p>
            </article>
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
            
    </body>
</html>


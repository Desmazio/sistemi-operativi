<%-- 
    Document   : marketplace
    Created on : 14 mag 2023, 21:37:03
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
        <link rel="stylesheet" type="text/css" href="css/marketplace.css" media="screen">
        <meta charset="UTF-8">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <%@include file="common/sidebar.jspf" %>
        
        <main class="col-7">
            <c:if test="${empty username}">
                <c:redirect url="login.jsp"/>
            </c:if>
            
            <h2>Marketplace</h2>
            
            <aside class="annuncio">
                <img src="img/audi.png" alt="Immagine annuncio" class="immagine">
                <div class="infobox">
                    <p class="titoloAnnuncio">Audi A3 Sportback 1.6 tdi Ambition</p>
                    <p class="prezzo">10500€</p>
                    <p class="tipologia">Veicolo</p>
                    <p class="descrizione">Vendo Audi a3 1.6 TDI dotata di serie di gancio traino (mai usato).
Fari bixenon led , fanali a led , clima automatico bizona perfetto, audio kenwood mp3 , cerchi da 17 (225/45).
Sempre tagliandata regolarmente (ultimo tagliando marzo 2023), gomme anteriori cambiate a dicembre 2022, revisionata fino a luglio 2024.
Freni e batteria cambiati recentemente.
Macchina perfetta di tutto , carrozzeria interni meccanica e motore.
Sono il proprietario dal 2014, vendo per cambio genere .
Prezzo non trattabile no permute</p>
                    <p class="telefono"><img class="icona" src="img/icona_telefono.png" alt="Icona Telefono">3386297784</p>
                </div>
            </aside>
            <aside class="annuncio">
                <img src="img/marmitta_vespa.png" alt="Immagine annuncio" class="immagine">
                <div class="infobox">
                    <p class="titoloAnnuncio">Marmitta Polini vespa px 125</p>
                    <p class="prezzo">110€</p>
                    <p class="tipologia">Componente</p>
                    <p class="descrizione">Nuova mai usata.. Solo provato a montarla ma purtroppo sulla mia vespa non monta senza far modifiche. Non tratto dato che è nuova. Tolgo qualcosa con ritiro di persona.</p>
                    <p class="telefono"><img class="icona" src="img/icona_telefono.png" alt="Icona Telefono">3756649302</p>
                </div>
            </aside>
            <aside class="annuncio">
                <img src="img/vespa.png" alt="Immagine annuncio" class="immagine">
                <div class="infobox">
                    <p class="titoloAnnuncio">Piaggio Vespa 125 PX - 1997</p>
                    <p class="prezzo">2600€</p>
                    <p class="tipologia">Veicolo</p>
                    <p class="descrizione">VESPA IN OTTIME CONDIZIONI, GOMME KM ZERO, TAGLIANDO MARZO 2023. PERFETTA.</p>
                    <p class="telefono"><img class="icona" src="img/icona_telefono.png" alt="Icona Telefono">3346345112</p>
                </div>
            </aside>
            <aside class="annuncio">
                <img src="img/i10.png" alt="Immagine annuncio" class="immagine">
                <div class="infobox">
                    <p class="titoloAnnuncio">Hyundai i10</p>
                    <p class="prezzo">2500€</p>
                    <p class="tipologia">Veicolo</p>
                    <p class="descrizione">Vendo Hyundai i10 GPL. Eseguiti diversi lavori importanti di manutenzione: cinghia di distribuzione, sostituita batteria a novembre 2022, sostituita frizione a maggio 2022, sostituito 4 iniettori a marzo 2021, sostituito polmone. Da ricaricare il condizionatore. Ripristinare l impianto di riscaldamento.</p>
                    <p class="telefono"><img class="icona" src="img/icona_telefono.png" alt="Icona Telefono">3237563353</p>
                </div>
            </aside>
            <aside class="annuncio">
                <img src="img/clio.png" alt="Immagine annuncio" class="immagine">
                <div class="infobox">
                    <p class="titoloAnnuncio">RENAULTClio2ª SeriePERFETTE CONDIZIONI</p>
                    <p class="prezzo">2000€</p>
                    <p class="tipologia">Veicolo</p>
                    <p class="descrizione">VENDO LA MIA AUTO PUR ESSENDO MOLTO AFFEZIONATO, PERCHE' HO NECESSITA' DI UN' AUTO PER PERCORSI DA FUORISTRADA. L'AUTO E' STATA SEMPRE PARCHEGGIATA IN GARAGE,
ALLESTIMENTO FULL OPTIONAL DINAMIQUE (ERA LA PIÙ COSTOSA), ANTIFURTO, NON FUMATORE, COMANDI AL VOLANTE, AUTORADIO ORIGINALE CON CD 4 CASSE E 2TWITTER, PREDISPOSIZIONE VIVAVOCE, SEDILI COME NUOVI, COLORE ORIGINALE.OGNI ANNO REVISIONATA, CON SOSTITUZIONE DI ALCUNE COMPONENTI SEMPRE ORIGINALI.</p>
                    <p class="telefono"><img class="icona" src="img/icona_telefono.png" alt="Icona Telefono">3325467576</p>
                </div>
            </aside>
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>




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
        <meta charset="UTF-8">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main>
            <c:if test="${empty username}">
                <c:redirect url="login.jsp"/>
            </c:if>
            
            <h2>Marketplace</h2>
            
            <hr>
            <div>
               <h3>Peel P50</h3>
               <img src="img/peel.jpg" alt="Peel P50" height="250">
               <p>Prezzo: $1250</p>
               <p>Descrizione: Peel P50 del 1964, poco usata, 5000km. Vendo dopo che mi hanno preso e caricato nel cassone di un furgone mentre aspettavo al semaforo</p>
               <p>Telefono: 3347789874</p>
            </div>
            <hr>
            <div>
               <h3>Reliant Robin</h3>
               <img src="img/reliant.jpg" alt="Reliant Robin" height="250">
               <p>Prezzo: $2200</p>
               <p>Descrizione: Realiant Robin del 1975, poco usata ma predsenta molti graffi, 15000km. Vendo dopo essermi ribaltato per la terza volta uscendo dal garage</p>
               <p>Telefono: 1146277398</p>
            </div>
            <hr>
            <div>
               <h3>Peugeot 206</h3>
               <img src="img/peugeot206.jpg" alt="Peugeot 206" height="250">
               <p>Prezzo: 1800</p>
               <p>Descrizione: Peugeot 206 del 2006, 205000km.</p>
               <p>Telefono: 3354678754</p>
            </div>
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>


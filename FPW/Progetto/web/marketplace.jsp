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
        <c:if test="${empty username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <% 
            session.setAttribute("getProdottiReturnUrl", "marketplace.jsp");  
        %>
        
        <c:if test="${empty listaProdotti}">
            <c:redirect url="MarketplaceServlet"/>
        </c:if>
        
        <%@include file="common/header.jspf" %>
        
        <main class="col-7">
            
            <h2>Marketplace</h2>
            
            <c:forEach items="${listaProdotti}" var="prodotto">
                <article class="annuncio">
                    <img src="${prodotto.getPathFoto()}" alt="Immagine annuncio" class="immagine">
                    <div class="infobox">
                        <h3 class="titoloAnnuncio">${prodotto.getTitolo()}</h3>
                        <p class="prezzo">${prodotto.getPrezzo()}€</p>
                        <p class="tipologia">${prodotto.getTipologia()}</p>
                        <p class="descrizione">${prodotto.getDescrizione()}</p>
                        <p class="telefono"><img class="icona" src="img/icona_telefono.png" alt="Icona Telefono">${prodotto.getTelefono()}</p>
                    </div>
                </article>
            </c:forEach>
        </main>
        
        <%@include file="common/sidebar.jspf" %>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>




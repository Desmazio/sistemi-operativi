<%-- 
    Document   : crea_annuncio
    Created on : 14 mag 2023, 21:37:35
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
        <link rel="stylesheet" type="text/css" href="css/crea_annuncio.css" media="screen">
        <script src="js/crea_annuncio.js" type="module"></script>
        <meta charset="UTF-8">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main>
            <c:if test="${empty username}">
                <c:redirect url="login.jsp"/>
            </c:if>
            
            <form action="AnnuncioServlet" method="POST" id="creaAnnuncio" enctype="multipart/form-data">
                <h2 class="headerAnnuncio">Crea un annuncio</h2>
                <div class="riga">
                    <div>
                        <label for="titolo">Titolo</label><p class="contaCaratteri"></p><br>
                        <input type="text" name="titolo" id="titolo" placeholder="Titolo dell'annuncio">
                    </div>
                    <div>
                        <label for="prezzo">Prezzo</label><br>
                        <input type="text" name="prezzo" id="prezzo">
                    </div>
                </div>
                <div>
                    <label for="descrizione">Descrizione</label><p class="contaCaratteri"></p><br>
                    <textarea rows="10" cols="60" name="descrizione" id="descrizione" placeholder="Descrizione dell'annuncio"></textarea>
                </div>
                <div>
                    <div>
                        <label for="tipologia">Tipologia</label><br>
                        <input type="radio" id="veicolo" name="tipologia" value="veicolo"><label for="veicolo">Veicolo</label><br>
                        <input type="radio" id="componente" name="tipologia" value="Componente"><label for="componente">Componente</label>
                    </div>
                    <div>
                        <input type="file" name="immagine" id="immagine" accept="image/*" >
                    </div>
                </div>
                
                <button type="button" id="pulsante" class="pulsante">INVIA</button>
                
                <p id="messaggioErrore"></p>
            </form>
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>
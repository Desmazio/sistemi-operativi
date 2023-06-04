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
        <title>TopGear Marketplace</title>
        <link rel="stylesheet" type="text/css" href="css/general.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/crea_annuncio.css" media="screen">
        <meta charset="UTF-8">
    </head>
    <body>
        <header>
            <!-- INCLUDERE IL FILE JSPF DEL LOGO QUI -->
            
            <!-- NavBar -->
            <%@include file="common/navbar.jspf" %>
        </header>
        
        <main>
            <form action="AnnuncioServlet" method="POST" id="creaAnnuncio">
                <h2 class="headerAnnuncio">Crea un annuncio</h2>
                <div class="riga">
                    <div>
                        <label for="titolo">Titolo</label><br>
                        <input type="text" name="titolo" id="titolo" placeholder="Titolo dell'annuncio" required>
                    </div>
                    <div>
                        <label for="titolo">Prezzo</label><br>
                        <input type="text" name="prezzo" id="prezzo" required>
                    </div>
                </div>
                    <label for="descrizione">Descrizione</label>
                    <textarea rows="5" cols="20" name="descrizione" id="descrizione" placeholder="Descrizione dell'annuncio" required></textarea>
                <div class="riga">
                    <div>
                        <label for="tipologia">Tipologia</label><br>
                        <input type="radio" id="auto" name="tipologia" value="Auto"><label for="auto">Auto</label><br>
                        <input type="radio" id="componente" name="tipologia" value="Componente"><label for="componente">Componente</label>
                    </div>
                    <div>
                        <label for="titolo" required>Telefono</label><br>
                        <input type="tel" name="telefono" id="telefono" required>
                    </div>
                </div>
                
                <input type="submit" value="Invia">	
            </form>
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>

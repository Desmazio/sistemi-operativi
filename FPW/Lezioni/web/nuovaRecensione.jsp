<%-- 
    Document   : nuovaRecensione
    Created on : 2 mag 2023, 16:12:12
    Author     : mrobb
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cineva</title>
        <link rel="stylesheet" type="text/css" href="css/nuova_recensione.css" media="screen">
        <meta charset="UTF-8">
    </head>

    <body>
        <main>
            
            <form id="nuovaRecensione" action="review" method="POST">
                <a href="index.jsp"><img src="img/logo.jpg" alt="Logo Cineva" height="150"></a> 
                <h2>Nuova Recensione</h2>
                
                <label for="titolo">Titolo</label>
                <input type="text" name="titolo" id="titolo">
                <br><br>
                <label for="descrizione">Descrizione</label><br>
                <textarea name="descrizione" id="descrizione"></textarea>
                <br><br> 
                <label>Tipologia</label>
                <input type="radio" name="tipologia" value="film">Film
                <input type="radio" name="tipologia" value="serie">Serie TV
                <br><br>
                <label for="titolo">Voto (da 1 a 5)</label>
                <input type="number" name="voto" min="1" max="5">
                <br><br> 
                <input type="submit" value="Pubblica">
            </form>

        </main>
    </body>
</html>


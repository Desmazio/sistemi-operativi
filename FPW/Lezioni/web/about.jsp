<%-- 
    Document   : about
    Created on : 2 mag 2023, 16:16:08
    Author     : mrobb
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cineva</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
    </head>

    <body>
        <header>
            <!-- Logo -->
            <a href="index.jsp"><img src="img/logo.jpg" alt="Logo Cineva" height="150"></a> 
            <!-- NavBar -->
            <%@include file="common/navbar.jspf" %>
        </header>
        <main>
            <h2>Cosa è Cineva?</h2>
            <!-- NavBar -->
            <nav>
                <p>Indice</p>
                <ul id="aboutIndex">
                    <li><a href="#info">Informazioni sul sito</a></li>
                    <li><a href="#rivolto">A chi è rivolto il sito?</a></li>
                    <li><a href="#costo">Quanto costa?</a></li>
                </ul>
            </nav>

            <h2 id="info">Informazioni sul sito</h2>
            <p>Cineva permette a tutti i cinofili di esprimere le proprie opinioni su film e serie tv. Meglio la CGI di <b>Avatar 2</b> o di <b>Black Panther: Wakanda Forever</b>? Ha più colpi di scena Stranger Things 4 o <b>Squid Game</b>?</p>
            <a href="#top">Torna su</a>
            <hr>
            <h2 id="rivolto"> A chi è rivolto il sito?</h2>
            <p>Cineva è per qualsiasi amante dei film o serie tv che voglia esprimere la sua opinione, leggere quella altrui o confrontarsi con altri appassionati!</p>
            <a href="#top">Torna su</a>
            <hr>
            <h2 id="costo">Quanto costa?</h2>
            <p>Neanche un centesimo! Cineva è completamente gratuito!</p>
            <a href="#top">Torna su</a>

        </main>
    </body>
</html>


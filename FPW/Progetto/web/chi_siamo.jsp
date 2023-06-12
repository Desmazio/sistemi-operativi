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
        <title>TopGear Marketplace</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/chi_siamo.css" media="screen">
        <meta charset="UTF-8">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main>
            <article>
                <img class="profilo" src="img/profile.jpg" alt="Immagine di profilo">
                <p>ALESSANDRO PAU</p>
            </article>
            <article>
                <img class="profilo" src="img/profile.jpg" alt="Immagine di profilo">
                <p>ALESSANDRO TODDE</p>
            </article>
            <article>
                <img class="profilo" src="img/profile.jpg" alt="Immagine di profilo">
                <p>MARCO PISANU</p>
            </article>
            <article>
                <img class="profilo" src="img/profile.jpg" alt="Immagine di profilo">
                <p>FRANCESCO SIMBOLA</p>
            </article>
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
            
    </body>
</html>


<%-- 
    Document   : annuncio_creato
    Created on : 19 mag 2023, 00:25:00
    Author     : paual
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Autoshop Marketplace</title>
        <link rel="icon" href="img/logo_piccolo.png" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/login.css" media="screen">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main>
            <form method="POST" id="login" action="AnnuncioCreatoServlet">
                <h2 class="login-title">Annuncio Creato</h2>
                <p>Ora puoi tornare nel Marketplace</p>
                <button type="submit" class="pulsante">MARKETPLACE</button>

                <p id="messaggioErrore"></p>
            </form>
        </main>
        
        <%@include file="common/footer.jspf" %>
    </body>
</html>

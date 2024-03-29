<%-- 
    Document   : index
    Created on : 14 mag 2023, 21:35:50
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
        <link rel="stylesheet" type="text/css" href="css/index.css" media="screen">
        <meta charset="UTF-8">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main class="col-7">
            <h2>Home</h2>
            <p>Benvenuto nel marketplace di Autoshop, qui puoi trovare auto usate, componenti, strumenti o pubblicare il tuo annuncio</p>
        </main>
        
        <%@include file="common/sidebar.jspf" %>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>


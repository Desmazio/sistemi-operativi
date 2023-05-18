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
        <title>TopGear Marketplace</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/index2.css" media="screen">
        <meta charset="UTF-8">
    </head>
    <body>
        <header>
            <!-- INCLUDERE IL FILE JSPF DEL LOGO QUI -->
            
            <!-- NavBar -->
            <%@include file="common/navbar.jspf" %>
        </header>
        
        <%-- <div class="col-4" id="sidebar">
            <h2>Sidebar</h2>
            <p>Qui possiamo aggiungere gli annunci postati, oppure una pubblicità finta</p>
        </div> --%>
        
        <aside class="col-4">
            <h2>Sidebar</h2>
            <p>Qui possiamo aggiungere gli annunci postati, oppure una pubblicità finta</p>
        </aside>
        
        <main class="col-7">
            <h2>Home</h2>
            <p>Benvenuto nel marketplace di TopGear, qui puoi trovare auto usate, componenti, strumenti o pubblicare il tuo annuncio</p>
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>


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
        <link rel="stylesheet" type="text/css" href="css/general.css" media="screen">
        <meta charset="UTF-8">
    </head>
    <body>
        <header>
            <!-- INCLUDERE IL FILE JSPF DEL LOGO QUI -->
            
            <!-- NavBar -->
            <%@include file="common/navbar.jspf" %>
        </header>
        
        <main>
            <h2>Chi Siamo</h2>
            <img src="img/us.png" height="600">
            <p>Jeremy Clarkson (centro), Richard Hammond (sinistra), James May (destra)</p>
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
            
    </body>
</html>


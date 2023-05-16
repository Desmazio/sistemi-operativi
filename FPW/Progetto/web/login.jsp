<%-- 
    Document   : login
    Created on : 14 mag 2023, 21:36:33
    Author     : paual
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>TopGear Marketplace</title>
        <link rel="stylesheet" type="text/css" href="css/general.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/login.css" media="screen">
        <meta charset="UTF-8">
    </head>
    <body>
        <header>
            <!-- INCLUDERE IL FILE JSPF DEL LOGO QUI -->
            
            <!-- NavBar -->
            <%@include file="common/navbar.jspf" %>
        </header>
        
        <main>
            
            <form action="login" method="POST" id="login">
                <h2 class="login-title">Login</h2>
                <label for="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter Username" required>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter Password" required>
                <input type="submit" value="Accedi">
            </form>
            
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>


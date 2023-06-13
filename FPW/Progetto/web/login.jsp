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
        <title>Autoshop Marketplace</title>
        <link rel="icon" href="img/logo_piccolo.png" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/login.css" media="screen">
        <script src="js/login.js" type="module"></script>
        <meta charset="UTF-8">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main>
            <!-- se il parametro "username" è vuoto, nessuno è loggato e fa fare il login, altrimenti fa fare il logout -->
            <c:if test="${empty username}">
                <form method="POST" id="login" action="LoginServlet"> <!-- action="LoginServlet" -->
                    
                    <h2 class="login-title">Login</h2>
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" placeholder="Enter Username">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" placeholder="Enter Password">
                    <button type="button" id="pulsante">ACCEDI</button>
                    
                    <p id="messaggioErrore"></p>
                </form>
            </c:if>
    
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>


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
            <c:choose>
                <c:when test="${empty username}">
                    <form method="POST" id="login" action="LoginServlet"> <!-- action="LoginServlet" -->
                        <h2 class="login-title">Login</h2>
                        <div>
                            <label for="username">Username</label><p class="contaCaratteri"></p><br>
                            <input type="text" id="username" name="username" placeholder="Enter Username">
                        </div>
                        <div>
                            <label for="password">Password</label><p class="contaCaratteri"></p><br>
                            <input type="password" id="password" name="password" placeholder="Enter Password">
                        </div>
                        
                        <button type="button" id="pulsante" class="pulsante">ACCEDI</button>
                        <p id="messaggioErrore"></p>
                    </form>
                </c:when>
                <c:otherwise>
                    <form method="POST" id="logout" action="LogoutServlet">
                        <h2 class="login-title">Logout</h2>
                        <p>Premi se vuoi fare il logout</p>
                        <button type="submit" class="pulsante">LOGOUT</button>
                    </form>
                </c:otherwise>
            </c:choose>
    
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>


<%-- 
    Document   : registrati
    Created on : 12 giu 2023, 15:01:16
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
        <script src="js/registrati.js" type="module"></script>
        <meta charset="UTF-8">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main>
            <!-- se il parametro "username" è vuoto, nessuno è loggato e fa fare la registrazione, altrimenti fa fare il logout -->
            <c:choose>
                <c:when test="${empty username}">
                    <form action="RegistrazioneServlet" method="POST" id="registrazione">
                        <h2 class="login-title">Registrati</h2>
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" placeholder="Enter Username">
                        <label for="password">Email</label>
                        <input type="email" id="email" name="email" placeholder="Enter email">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" placeholder="Enter Password">
                        <label for="password">Telefono</label>
                        <input type="tel" id="telefono" name="telefono" placeholder="Enter telephone">
                        <button type="button" id="pulsante">REGISTRATI</button>
                        
                        <p id="messaggioErrore"></p>
                    </form>
                </c:when>
                <c:otherwise>
                    <c:redirect url="login.jsp"/>
                </c:otherwise>
            </c:choose>
            
            
        </main>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>

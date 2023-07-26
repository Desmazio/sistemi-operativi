<%-- 
    Document   : area_personale
    Created on : 18 mag 2023, 14:47:29
    Author     : mrobb
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Autoshop Marketplace</title>
        <link rel="icon" href="img/logo_piccolo.png" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/area_personale.css" media="screen">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        <main class="col-7">
            <c:if test="${empty username}">
                <c:redirect url="login.jsp"/>
            </c:if>

            <c:if test="${not empty username}">
                <h1>Ciao ${username}!</h1>
                <div id="infobox">
                    <p><img class="icona" src="img/email_icon.png" alt="Icona Email">${email}</p>
                    <p><img class="icona" src="img/icona_telefono.png" alt="Icona Telefono">${telefono}</p>
                </div>
            </c:if>
        </main>
        
        <%@include file="common/sidebar.jspf" %>
        
        <!-- Footer -->
        <%@include file="common/footer.jspf" %>
        
    </body>
</html>

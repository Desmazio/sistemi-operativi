<%-- 
    Document   : error
    Created on : 18 mag 2023, 23:27:05
    Author     : paual
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
        <link rel="stylesheet" type="text/css" href="css/error.css" media="screen">
    </head>
    <body>
        <%@include file="common/header.jspf" %>
        
        
            <form action=${link} >
                <c:set var="str" value="login"/>
                <c:choose>
                    <c:when test="${errorType == str}">
                        <h2>Login Fallito</h2>
                    </c:when>
                    <c:otherwise>
                        <h2>Errore creazione annuncio</h2>
                    </c:otherwise>
                </c:choose>
                
                <p>${errorMessage}</p>
                <input type="submit" value="RIPROVA">
            </form>
        
        
        <%@include file="common/footer.jspf" %>
    </body>
</html>

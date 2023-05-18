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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
        <title>Area Personale</title>
    </head>
    <body>
        <header>
            <!-- INCLUDERE IL FILE JSPF DEL LOGO QUI -->
            
            <!-- NavBar -->
            <%@include file="common/navbar.jspf" %>
        </header>
                
        <c:if test="${empty username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <c:if test="${not empty username}">
            <h1>Ciao ${username}!</h1>
        </c:if>
        
    </body>
</html>

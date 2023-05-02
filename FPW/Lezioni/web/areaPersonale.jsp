<%-- 
    Document   : areaPersonale
    Created on : 2 mag 2023, 15:20:03
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
        <c:if test="${empty username}">
            <c:redirect url="login.jsp"/>
        </c:if>
        
        <c:if test="${not empty username}">
            <h1>Ciao ${username}!</h1>
            <P>Ultimo accesso: ${lastLogin}</P>
        </c:if>
    </body>
</html>

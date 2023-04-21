<%-- 
    Document   : recensioneInserita
    Created on : 18 apr 2023, 15:59:15
    Author     : paual
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen"/>
        <title>Recensione Inserita</title>
    </head>
    <body>
        <h1>Recensione inserita correttamente!</h1>
        <h2>Perché non dai un'occhiata a questi titoli del momento?</h2>
        <ul>
            <c:forEach items="${listaFilm}" var = "film">
                <li>${film}</li>
            </c:forEach>
        </ul>
    </body>
</html>

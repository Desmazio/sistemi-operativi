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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/general.css" media="screen">
        <link rel="stylesheet" type="text/css" href="css/error.css" media="screen">
        <title>Error</title>
    </head>
    <body>
        <header>
            <%@include file="common/navbar.jspf" %>
        </header>
        
        
            <form action="login.jsp">
                <h2>Login Fallito</h2>
                <p>${errorMessage}</p>
                <input type="submit" value="Torna al login">
            </form>
        
        
        <%@include file="common/footer.jspf" %>
    </body>
</html>

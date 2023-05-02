<%-- 
    Document   : login
    Created on : 2 mag 2023, 15:27:28
    Author     : mrobb
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cineva</title>
        <link rel="stylesheet" type="text/css" href="css/login.css" media="screen">
    </head>
    <body>
        <main>
            
            <form action="ServletLogin" method="POST" id="login">
                <a href="index.jsp"><img src="img/logo.jpg" alt="Logo Cineva" height="150"></a> 
                <h2>Login</h2>
                
                <label for="username">Username</label>
                <input type="text" name="username" id="username">
                <label for="password">Password</label>
                <input type="password" name="password" id="password">
                <input type="submit" value="Accedi">
            </form>
            
        </main>
    </body>
</html>

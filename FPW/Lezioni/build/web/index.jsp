<%-- 
    Document   : index
    Created on : 2 mag 2023, 16:17:47
    Author     : mrobb
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cineva</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen">
        <meta charset="UTF-8">
    </head>

    <body>
        <header>
            <!-- Logo -->
            <a href="index.jsp"><img src="img/logo.jpg" alt="Logo Cineva" height="150"></a> 
            <!-- NavBar -->
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="chi_siamo.html">Chi siamo</a></li>
                    <li><a href="about.jsp">About</a></li>
                    <li><a href="nuovaRecensione.jsp">Nuova recensione</a></li>
                </ul>
            </nav>
        </header>
        <main>

            <h2 id="intro">Benvenuti sul sito!</h2>
            <p id="intro">Su <i>Cineva</i> potete scrivere recensioni su <u>film e serie tv</u> <b>senza alcun costo</b></p> 
        
        </main>
    </body>
</html>


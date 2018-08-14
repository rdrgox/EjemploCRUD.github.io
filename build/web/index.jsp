<%-- 
    Document   : index
    Created on : 21-jun-2018, 9:09:17
    Author     : Rodrigo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración</title>
    </head>
    <body>
        <nav>
            <div class="nav-wrapper light-green darken-2">
                <a href="#!" class="brand-logo">Gestión de Ligas de Fútbol</a>
                <ul id="nav-mobile"  class="right hide-on-med-and-down">
                    <li><a href="equipos.jsp">Agregar Equipos</a></li>
                    <li><a href="equipoModificar.jsp">Modificar Equipos</a></li>
                    <li><a href="jugadores.jsp">Gestión de Jugadores</a></li>
                    <li><a href="listaJugadores.jsp">Lista de Jugadores</a></li>
                    <li><a href="jugadorModificar.jsp">Modificar Jugadore</a></li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <div class="col s3"></div>
            <div class="col s6">
                <div class="slider">

                    <img src="img/banco1.jpg"> 
                    <img src="img/banco2.jpg">    

                </div>
            </div>
        </div>
        
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(document).ready(function(){
              $('.slider').slider();
            });
        </script>
    </body>
</html>

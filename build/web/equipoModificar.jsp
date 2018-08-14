<%-- 
    Document   : equipoModificar
    Created on : 21-jun-2018, 10:50:45
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
                    <li><a href="index.jsp">Página Principal</a></li>
                    <li><a href="jugadores.jsp">Agregar Jugadores</a></li>
                    <li><a href="listaJugadores.jsp">Listado de Jugadores</a></li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <div class="col s3"></div>
            <div class="col s6">

                <form action="<c:url value="EquipoControlador"/>" method="post">

                    <div class="card-panel teal">
                        <span class="white-text">Modificar Equipos</span>
                    </div>   
                    <div class="input-field inline">
                        <input id="id_equipo" type="text" class="validate" name="id_equipo" value="<c:out value="${id_equipo}"/>">
                        <label for="id_equipo">Id Equipo</label>
                    </div>
                    <div class="input-field">
                        <input id="nombre_equipo" type="text" class="validate" name="nombre_equipo" value="<c:out value="${nombre_equipo}"/>">
                        <label for="nombre_equipo">Nombre de Equipo</label>
                    </div>    

                    <input class="btn waves-effect waves-light" type="submit" name="bt" value="Buscar">
                    <input class="btn waves-effect waves-light" type="submit" name="bt" value="Modificar">   
                    <input class="btn waves-effect waves-light" type="submit" name="bt" value="Eliminar">   
                </form>
                ${msgm}
                ${msge}
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

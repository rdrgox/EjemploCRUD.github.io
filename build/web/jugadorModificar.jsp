<%-- 
    Document   : jugadorModrificar
    Created on : 21-jun-2018, 11:48:16
    Author     : ENTEL
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
                    <li><a href="index.jsp">Menú Principal</a></li>
                    <li><a href="equipos.jsp">Agregar Equipos</a></li>
                    <li><a href="equipoModificar.jsp">Modificar Equipos</a></li>
                    <li><a href="listaJugadores.jsp">Listado de Jugadores</a></li>
                </ul>
            </div>
        </nav>

        <div class="row">
            <div class="col s3"></div>
            <div class="col s6">

                <form action="<c:url value="JugadorControlador"/>" method="post">

                    <div class="card-panel teal">
                        <span class="white-text">Modificar registro de jugadores</span>
                    </div>

                    <div class="input-field">
                        <input id="id_jugador" type="text" class="validate" name="id_jugador" value="<c:out value="${id_jugador}"/>">
                        <label for="id_jugador">rut del jugador</label>
                    </div>

                    <div class="input-field">
                        <input id="nombre_jugador" type="text" class="validate" name="nombre_jugador" value="<c:out value="${nombre_jugador}"/>">
                        <label for="nombre_jugador">Nombre de jugador</label>
                    </div>

                    <div class="input-field">
                        <input id="numero_camiseta" type="number" class="validate" name="numero_camiseta" value="<c:out value="${numero_camiseta}"/>">
                        <label for="numero_camiseta">Numero de camiseta</label>
                    </div>

                    <div class="input-field">
                        <input id="id_equipo" type="text" class="validate" name="id_equipo" value="<c:out value="${id_equipo}"/>">
                        <label for="id_equipo">Id del equipo</label>
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

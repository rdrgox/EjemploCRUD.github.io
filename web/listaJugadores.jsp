<%-- 
    Document   : listaJugadores
    Created on : 21-jun-2018, 11:25:06
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
                    <li><a href="equipos.jsp">Gestión Equipos</a></li>
                    <li><a href="equipoModificar.jsp">Modificar Equipos</a></li>
                    <li><a href="jugadorModificar.jsp">Modificar Jugadores</a></li>
                </ul>
            </div>
        </nav>

        <div class="row">
            <div class="col s3"></div>
            <div class="col s6">


                <div class="card-panel teal">
                    <span class="white-text">Listado de jugadores por equipo</span>
                </div>
                
                <form action="<c:url value="JugadorControlador"/>" method="post">


                    <div class="input-field inline">
                        <input id="id_equipo" type="number" class="validate" name="id_equipo">
                        <label for="id_equipo">Id de equipo</label>
                    </div>
                    <br>
                    <input class="btn waves-effect waves-light" type="submit" name="bt" value="Listar">

                </form>
                <br>
                <table border="2" class="striped">
                    <tr>
                        <th>ID Jugador</th>
                        <th>Nombre jugador</th>
                        <th>Nº Camiseta</th>
                    </tr>
                    <c:forEach var="j" items="${listaJugadores}">
                        <tr>
                            <td>
                                <c:out value="${j.getId_jugador()}"/>
                            </td>
                            <td>
                                <c:out value="${j.getNombre_jugador()}"/>
                            </td>
                            <td>
                                <c:out value="${j.getNumero_camiseta()}"/>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

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

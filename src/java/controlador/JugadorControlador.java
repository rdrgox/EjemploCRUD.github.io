/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.JugadorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.JugadorServicio;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "JugadorControlador", urlPatterns = {"/JugadorControlador"})
public class JugadorControlador extends HttpServlet {
    
    @EJB
    private JugadorServicio jugadorServicio;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JugadorControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JugadorControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String bt = request.getParameter("bt");
            request.getSession().setAttribute("msg", "");
            request.getSession().setAttribute("msga", "");
            request.getSession().setAttribute("msgm", "");
            request.getSession().setAttribute("msge", "");
            boolean edo = true;
            
            switch (bt) {
                case "Registrar":
                    try {
                        int id_jugador = Integer.parseInt(request.getParameter("id_jugador"));
                        String nombre_jugador = request.getParameter("nombre_jugador");
                        int numero_camiseta = Integer.parseInt(request.getParameter("numero_camiseta"));
                        int id_equipo = Integer.parseInt(request.getParameter("id_equipo"));
                        JugadorDTO jDTO = new JugadorDTO();
                        jDTO.setId_jugador(id_jugador);
                        jDTO.setNombre_jugador(nombre_jugador);
                        jDTO.setNumero_camiseta(numero_camiseta);
                        jDTO.setId_equipo(id_equipo);
                        jugadorServicio.createJugador(jDTO);

                    } catch (Exception e) {
                        request.getSession().setAttribute("msga", "no ha sido posible agregar el registro");
                        request.getRequestDispatcher("/jugadores.jsp").forward(request, response);
                        edo = false;
                    }
                    if(edo == true){
                        request.getSession().setAttribute("msga", "registro agregado");
                        request.getRequestDispatcher("/jugadores.jsp").forward(request, response);
                    }
                    break;
                    
                case "Buscar":
                    try {
                        int id_jugador = Integer.parseInt(request.getParameter("id_jugador"));
                        JugadorDTO jDTOleer = jugadorServicio.readJugador(id_jugador);
                        request.setAttribute("id_jugador", jDTOleer.getId_jugador());
                        request.setAttribute("nombre_jugador", jDTOleer.getNombre_jugador());
                        request.setAttribute("numero_camiseta", jDTOleer.getNumero_camiseta());
                        request.setAttribute("id_equipo", jDTOleer.getId_equipo());
                        request.getRequestDispatcher("/jugadorModificar.jsp").forward(request, response);
                        
                    } catch (Exception e) {
                        request.getSession().setAttribute("msgm", "El id indicado no se encunetra registrado");
                        response.sendRedirect("jugadorModificar.jsp");
                    }
                    break;
                
                case "Modificar":
                    try {
                        int id_jugador = Integer.parseInt(request.getParameter("id_jugador"));
                        String nombre_jugador = request.getParameter("nombre_jugador");
                        int numero_camiseta = Integer.parseInt(request.getParameter("numero_camiseta"));
                        int id_equipo = Integer.parseInt(request.getParameter("id_equipo"));
                        JugadorDTO jDTOactualizar = new JugadorDTO();
                        jDTOactualizar.setId_jugador(id_jugador);
                        jDTOactualizar.setNombre_jugador(nombre_jugador);
                        jDTOactualizar.setNumero_camiseta(numero_camiseta);
                        jDTOactualizar.setId_equipo(id_equipo);
                        jugadorServicio.updateJugador(jDTOactualizar);
                        
                    } catch (Exception e) {
                        request.getSession().setAttribute("msgm", "no se ha podido actualizar el registro");
                        response.sendRedirect("jugadorModificar.jsp");
                        edo = false;
                    }
                    if(edo == true){
                        request.getSession().setAttribute("msgm", "registro modificado");
                        request.getRequestDispatcher("/jugadorModificar.jsp").forward(request, response);
                    }
                    break;
                    
                case "Eliminar":
                    try {
                        int id_jugador = Integer.parseInt(request.getParameter("id_jugador"));
                        jugadorServicio.deleteJugador(id_jugador);
                        
                    } catch (Exception e) {
                        request.getSession().setAttribute("msge", "no se ha podido eliminar");
                        response.sendRedirect("jugadorModificar.jsp");
                        edo = false;
                    }
                    if (edo == true){
                        request.getSession().setAttribute("msge", "registro eliminado");
                        response.sendRedirect("jugadorModificar.jsp");
                    }
                    break;
                
                case "Listar":
                        int equipo = Integer.parseInt(request.getParameter("id_equipo"));
                        request.setAttribute("listaJugadores", jugadorServicio.allJugadoresEquipo(equipo));
                        request.getRequestDispatcher("/listaJugadores.jsp").forward(request, response);
                        break;
                    }
                   
            } catch (NumberFormatException | ServletException | IOException e ) {

        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.EquipoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.EquipoServicio;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "EquipoControlador", urlPatterns = {"/EquipoControlador"})
public class EquipoControlador extends HttpServlet {
    
    @EJB
    private EquipoServicio equipoServicio;
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
            
            switch (bt){
                case "Crear equipo":
                    try {
                        String nombre_equipo = request.getParameter("nombre_equipo");
                        EquipoDTO eDTo = new EquipoDTO();
                        eDTo.setNombre_equipo(nombre_equipo);
                        equipoServicio.createEquipo(eDTo);
                        request.getRequestDispatcher("/equipos.jsp").forward(request, response);
                    } catch (Exception e) {
                        request.getSession().setAttribute("msga", "no ha sido posible agregar el registro");
                        response.sendRedirect("equipo.jsp");
                        edo = false;
                    }
                    if(edo == true){
                        request.getSession().setAttribute("msga", "registro agregado");
                        request.getRequestDispatcher("/equipos.jsp").forward(request, response);
                    }
                    break;
                    
                case "Listar":
                    request.setAttribute("listaEquipos", equipoServicio.allEquipos());
                    request.getRequestDispatcher("/listaEquipos.jsp").forward(request, response);
                    
                case "Buscar":
                    try {
                        int id_equipo = Integer.parseInt(request.getParameter("id_equipo"));
                        EquipoDTO eDTOleer = equipoServicio.readEquipo(id_equipo);
                        request.setAttribute("id_equipo", eDTOleer.getId_equipo());
                        request.setAttribute("nombre_equipo", eDTOleer.getNombre_equipo());
                        request.getRequestDispatcher("/equipoModificar.jsp").forward(request, response);
                                
                    } catch (Exception e) {
                        request.getSession().setAttribute("msgm", "el id indicado no se encuentra registrado");
                        response.sendRedirect("equipoModificar.jsp");
                    }
                    break;
                case "Modificar":
                    try {
                        int id_equipo = Integer.parseInt(request.getParameter("id_equipo"));
                        String nombre_equipo = request.getParameter("nombre_equipo");
                        EquipoDTO eDTOactualizar = new EquipoDTO();
                        eDTOactualizar.setId_equipo(id_equipo);
                        eDTOactualizar.setNombre_equipo(nombre_equipo);
                        equipoServicio.updateEquipo(eDTOactualizar);
                                
                    } catch (Exception e) {
                        request.getSession().setAttribute("msgm", "no se ha podido actualizar el registro");
                        response.sendRedirect("equipoModificar.jsp");
                        edo = false;                     
                    }
                    if (edo == true){
                        request.getSession().setAttribute("msgm", "registro modificado");
                        request.getRequestDispatcher("/equipoModificar.jsp").forward(request, response);
                    }
                    break;
                
                case "Eliminar":
                    try {
                        int id_equipo = Integer.parseInt(request.getParameter("id_equipo"));
                        equipoServicio.deleteEquipo(id_equipo);
                        
                    } catch (Exception e) {
                        request.getSession().setAttribute("msge", "no se ha podido eliminar");
                        response.sendRedirect("equipoModificar.jsp");
                        edo = false;
                    }
                    if(edo == true){
                        request.getSession().setAttribute("msge", "registro eliminado");
                        response.sendRedirect("equipoModificar.jsp");
                    }
                    break;
            }
            
        } catch (ServletException | IOException e) {
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!--Import Google Icon Font-->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <!--Import materialize.css-->\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Administración</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav>\n");
      out.write("            <div class=\"nav-wrapper light-green darken-2\">\n");
      out.write("                <a href=\"#!\" class=\"brand-logo\">Gestión de Ligas de Fútbol</a>\n");
      out.write("                <ul id=\"nav-mobile\"  class=\"right hide-on-med-and-down\">\n");
      out.write("                    <li><a href=\"equipos.jsp\">Agregar Equipos</a></li>\n");
      out.write("                    <li><a href=\"equipoModificar.jsp\">Modificar Equipos</a></li>\n");
      out.write("                    <li><a href=\"jugadores.jsp\">Gestión de Jugadores</a></li>\n");
      out.write("                    <li><a href=\"listaJugadores.jsp\">Lista de Jugadores</a></li>\n");
      out.write("                    <li><a href=\"jugadorModificar.jsp\">Modificar Jugadore</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col s3\"></div>\n");
      out.write("            <div class=\"col s6\">\n");
      out.write("                <div class=\"slider\">\n");
      out.write("\n");
      out.write("                    <img src=\"img/banco1.jpg\"> \n");
      out.write("                    <img src=\"img/banco2.jpg\">    \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <!--Import jQuery before materialize.js-->\n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("              $('.slider').slider();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

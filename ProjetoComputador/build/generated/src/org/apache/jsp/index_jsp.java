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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Raleway&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("        <title>Página Inicial</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <style>\r\n");
      out.write("            *{\r\n");
      out.write("                font-family: 'Raleway', sans-serif;\r\n");
      out.write("                padding: 0;\r\n");
      out.write("                margin: 0;\r\n");
      out.write("            }\r\n");
      out.write("            body{\r\n");
      out.write("                height: 100vh;\r\n");
      out.write("                background-image: url(train.jpg);\r\n");
      out.write("                background-size: cover;\r\n");
      out.write("                background-repeat: no-repeat;\r\n");
      out.write("            }\r\n");
      out.write("            main\r\n");
      out.write("            {\r\n");
      out.write("                display: flex;\r\n");
      out.write("                flex-direction: column;\r\n");
      out.write("                justify-content: space-around;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("                height: 100%;\r\n");
      out.write("            }\r\n");
      out.write("            h1{\r\n");
      out.write("                color: #8257e6;\r\n");
      out.write("                margin-top: 4rem;\r\n");
      out.write("                font-size: 3rem;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                font-weight: 700;\r\n");
      out.write("            }\r\n");
      out.write("            ul\r\n");
      out.write("            {\r\n");
      out.write("                margin: auto auto;\r\n");
      out.write("                width: 30%;\r\n");
      out.write("                display: flex;\r\n");
      out.write("                justify-content: space-around;\r\n");
      out.write("                align-items: center;\r\n");
      out.write("                \r\n");
      out.write("            }\r\n");
      out.write("            ul li{\r\n");
      out.write("                display: inline-block;\r\n");
      out.write("                justify-content: space-between;\r\n");
      out.write("            }\r\n");
      out.write("            ul li a{\r\n");
      out.write("                color: white;\r\n");
      out.write("                text-transform: uppercase;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                transition: 0.2s;\r\n");
      out.write("                font-size: 2rem;\r\n");
      out.write("            }\r\n");
      out.write("            a:hover{\r\n");
      out.write("                color: #8257e6;\r\n");
      out.write("                font-size: 2rem;\r\n");
      out.write("                opacity: 2;\r\n");
      out.write("                display: block;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("        \r\n");
      out.write("        <main>\r\n");
      out.write("            <h1>Controle de Computadores</h1><br><br>\r\n");
      out.write("            \r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"cadastrarcomputador.jsp\">Cadastrar</a></p></li>\r\n");
      out.write("                \r\n");
      out.write("                <li><a href=\"ListarComputador\">Listar</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("           \r\n");
      out.write("        </main>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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

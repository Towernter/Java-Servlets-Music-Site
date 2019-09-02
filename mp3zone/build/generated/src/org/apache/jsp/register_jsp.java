package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet1.css\">\n");
      out.write("        <title>account creation page</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-image: url(music4.jpg);\">\n");
      out.write("        <form>\n");
      out.write("             <h1>MP3-ZONE</h1>\n");
      out.write("             <ul class=\"nav\">\n");
      out.write("  <li class=\"nav1\" style=\"float: right;\"><a  href=\"index.html\">Home</a></li>\n");
      out.write("             </ul><br><br>\n");
      out.write("             <blockquote class=\"bl\" style=\"color: white;\"><b>Welcome to the mp3-zone registration page, please provide us with you details to register</b></blockquote><br><br><br>\n");
      out.write("             <fieldset style=\" color: white;\">\n");
      out.write("                <legend>Enter required details in the boxes provided below:</legend>\n");
      out.write("             <p class=\"r1\">\n");
      out.write("             <input type=\"text\" name=\"\" required=\"required\" size=\"60\" placeholder=\"Name\"><br><br>\n");
      out.write("             <input type=\"text\" name=\"\" required=\"required\" size=\"60\" placeholder=\"Surname\"><br><br>\n");
      out.write("             <input type=\"text\" name=\"\" required=\"required\" size=\"60\" placeholder=\"Username\"><br><br>\n");
      out.write("             <input type=\"Email\" name=\"\" required=\"required\" size=\"60\" placeholder=\"example@gmail.com\">(optional)<br><br>\n");
      out.write("             <select required=\"required\">\n");
      out.write("                <option name=\"\">male</option>\n");
      out.write("                <option name=\"\">female</option>\n");
      out.write("             </select><br><br>\n");
      out.write("                 <input type=\"date\" name=\"\" ><br><br>\n");
      out.write("             <input type=\"Password\" name=\"\" required=\"required\" size=\"60\" placeholder=\"Password\"><br><br>\n");
      out.write("             <input type=\"Password\" name=\"\" required=\"required\" size=\"60\" placeholder=\"Password\"><br><br>\n");
      out.write("             </p>\n");
      out.write("             <blockquote class=\"r2\">\n");
      out.write("                <input type=\"submit\" name=\"\" value=\"submit\" onclick=\"log_in()\" >\n");
      out.write("             </blockquote>\n");
      out.write("             </fieldset>\n");
      out.write("             <blockquote class=\"bl1\">\n");
      out.write("                 You can provide more information after login. Clicking the submit button will save the information you provide and take you back to the login page.\n");
      out.write("             </blockquote>\n");
      out.write("             <script type=\"text/javascript\">\n");
      out.write("                function log_in(){\n");
      out.write("                    location.href=\"index.html\"\n");
      out.write("                }\n");
      out.write("             </script>\n");
      out.write("        </form>\n");
      out.write("    </body>");
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

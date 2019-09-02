package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \t<title>Log In page</title>\n");
      out.write("    \t<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet1.css\">\n");
      out.write("    \t\n");
      out.write("        \n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("   <body style=\"background-image: url(music4.jpg); color: white;\">\n");
      out.write("   \n");
      out.write("      <!-- ");
for(int i=0;i<=9;i++){ 
      out.write("\n");
      out.write("       ");
 out.println("okay");} 
      out.write("-->\n");
      out.write("       \n");
      out.write("        <form action=\"Uploading\" method=\"POST\">\n");
      out.write("      \n");
      out.write("            <h1 style=\"color: black;\">MP3-ZONE</h1>\n");
      out.write("            <ul class=\"nav\">\n");
      out.write("  <li class=\"nav1\"><a  href=\"#home\">Hip-hop</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"#Gospel\">Gospel</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"#zimd\">Zim-Dancehall</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"logged.jsp\">All</a></li>\n");
      out.write("  <li class=\"nav1\"><a class=\"active\" href=\"#Upload\">Upload</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"#myacc\">My Account</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"index.html\">Home</a></li>\n");
      out.write("</ul><br>\n");
      out.write("<blockquote style=\"font-size: 20px;\"><strong>LOGGED IN AS:</strong>&nbsp;&nbsp;&nbsp; </blockquote>\n");
      out.write(" <blockquote class=\"bl\" style=\"color: white;\">  please make sure to give an extension of the file in the name of the song. For example ..name.mp3 </blockquote><br>\n");
      out.write(" \t\t\t <fieldset style=\" color: white; background-color: grey;\">\n");
      out.write("                <legend>Enter required details in the boxes provided below:</legend>\n");
      out.write("             <p class=\"r1\">\n");
      out.write("             \t<br><br>\n");
      out.write("             <input type=\"text\" name=\"\" required=\"required\" size=\"60\" placeholder=\"Name of song\">(include extension e.g. .mp3)<br><br><br><br>\n");
      out.write("             <input type=\"text\" name=\"\"  size=\"60\" placeholder=\"Year of Release\"><br><br><br><br>\n");
      out.write("             <input type=\"text\" name=\"\"  size=\"60\" placeholder=\"Artist\"><br><br><br><br>\n");
      out.write("             <input type=\"file\" name=\"\" ><br><br><br><br>\n");
      out.write("         </p>\n");
      out.write("     </fieldset>\n");
      out.write(" </form>\n");
      out.write("    </body>\n");
      out.write("    </html>\n");
      out.write("    ");
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

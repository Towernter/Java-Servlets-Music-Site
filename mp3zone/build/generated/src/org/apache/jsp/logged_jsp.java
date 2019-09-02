package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import package1.Catch_likes;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import package1.Catch;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public final class logged_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    \t<title>Log In page</title>\n");
      out.write("    \t<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet1.css\">\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("   <body style=\"background-image: url(music4.jpg); color: white;\">\n");
      out.write(" \n");
      out.write("        <form action=\"search.jsp\" method=\"POST\">\n");
      out.write("      \n");
      out.write("            <h1 style=\"color: black;\">MP3-ZONE</h1>\n");
      out.write("            <ul class=\"nav\">\n");
      out.write("  <li class=\"nav1\"><a href=\"hiphop.jsp\">Hip-hop</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"gospel.jsp\">Gospel</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"zimdancehall.jsp\">Zim-Dancehall</a></li>\n");
      out.write("  <li class=\"nav1\"><a class=\"active\" href=\"#all\">All</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"upload.jsp\">Upload</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"myaccount.jsp\">My Account</a></li>\n");
      out.write("  <li class=\"nav1\"><a href=\"index.html\">Home</a></li>\n");
      out.write("</ul><br>\n");
      out.write("<blockquote style=\"font-size: 20px;\"><strong>LOGGED IN AS: &nbsp;&nbsp;&nbsp;");
 out.print(Catch.name.toUpperCase());
      out.write(" </strong>&nbsp;&nbsp;&nbsp; </blockquote>\n");
      out.write(" <blockquote class=\"bl\" style=\"color: white;\">   mp3-zone for music lovers. Search by name of song or artist.. &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</blockquote>\n");
      out.write("<blockquote style=\"padding-left: 55%\"><input type=\"text\" name=\"search\" size=\"50\"><input type=\"submit\" name=\"\" value=\"SEARCH\"></blockquote>\n");
      out.write("           \n");
      out.write("      \n");
      out.write("         </form>\n");
      out.write("          <form action=\"Like_save\" method=\"POST\">\n");
      out.write("       \n");
      out.write("              <blockquote>\n");
      out.write("                  \n");
      out.write("              </blockquote>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"wrap\">\n");
      out.write("   \n");
      out.write("        <div class=\"left\" >\n");
      out.write("            <h4 style=\"padding-left: 10%;\">SONG LIST:</h4>\n");
      out.write("            \n");
      out.write("            ");
 

int[] liked;
 int lc=0;

 Connection conn;
 ResultSet rs;
 PreparedStatement ps;
       try{
Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");   
    ps=conn.prepareStatement("select * from likes where person_id=?"); 
    ps.setString(1, Catch.name);
    rs=ps.executeQuery();
    while(rs.next()){
       lc++; 
    }
    liked=new int[lc];
    lc=0;
     ps=conn.prepareStatement("select * from likes where person_id=?"); 
    ps.setString(1, Catch.name);
    rs=ps.executeQuery();
    while(rs.next()){
        liked[lc]=rs.getInt("song_id");
       lc++; 
    }
    lc=0;
ps=conn.prepareStatement("select * from songs"); 
       rs=ps.executeQuery();
       while(rs.next()){
    
      out.write("\n");
      out.write("        \t\n");
      out.write("        <blockquote  style=\" background-color: #333; padding-left: 10%; padding-right: 10%; color: orange;\">\n");
      out.write("            <audio controls >\n");
      out.write("            <source src=\"");
      out.print( rs.getString("song") );
      out.write("\"  />\n");
      out.write("</audio>\n");
boolean yes=false;
for(int i=0;i<liked.length;i++){
    if(rs.getInt("song_id")==liked[i]){
       yes=true;
    }
}


      out.write('\n');
if(yes){
      out.write("\n");
      out.write("<input type=\"checkbox\" name=\"ch\" value=\"");
      out.print( rs.getInt("song_id") );
      out.write("\" checked=\"checked\" onclick=\"getSelectedChbox(this)\"><sub style=\"color: green;\">LIKE</sub><br>\n");
      out.write("\n");
yes=false;}else{
      out.write("\n");
      out.write("<input type=\"checkbox\" name=\"ch\" value=\"");
      out.print( rs.getInt("song_id") );
      out.write("\" onclick=\"getSelectedChbox(this)\"><sub style=\"color: green;\"  >LIKE</sub><br>\n");
      out.write("\n");
yes=false;}
      out.write("\n");
      out.write(" TITLE : ");
 out.print(rs.getString("name"));     
      out.write("<br>\n");
      out.write(" ARTIST: ");
 out.print(rs.getString("artist"));    
      out.write("<br>\n");
      out.write(" YEAR  : ");
 out.print(rs.getString("year"));    
      out.write("<br>\n");
      out.write("        </blockquote>\n");
      out.write("          ");
 }}catch(Exception e){
              
      out.write("\n");
      out.write("              <blockquote>error</blockquote>\n");
      out.write("        ");

          }
      out.write("\n");
      out.write("\n");
      out.write("</div><br>\n");
      out.write("\n");
      out.write("\n");
      out.write(" <div class=\"right\">\n");
      out.write("   ");
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
   ps=conn.prepareStatement("");
   
      out.write("\n");
      out.write("        \t<h4 style=\"padding-left: 8%;\">RECOMMENDED FOR YOU:</h4>\n");
      out.write("        <blockquote  style=\" background-color: #333; padding-left: 8%; padding-right: 10%; color: orange;\">\n");
      out.write("        <audio controls loop draggable=\"true\">\n");
      out.write(" \t<source src=\"Rita Ora - Your Song (CDQ) (Mp3Goo.com).mp3\"/>\n");
      out.write("        </audio><input type=\"checkbox\" name=\"\" onclick=\"getSelectedChbox(this)\" ><sub style=\"color: green;\">LIKE</sub><br>\n");
      out.write(" TITLE : Rita Ora - Your Song (CDQ) (Mp3Goo.com)<br>\n");
      out.write(" ARTIST: RITA ORA<br>\n");
      out.write(" YEAR  : 2017<br>\n");
      out.write(" \n");
      out.write("      </blockquote><br> \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    // get selected checkboxes\n");
      out.write("function getSelectedChbox(frm) {\n");
      out.write("  var selchbox=[];// array that will store the value of selected checkboxes\n");
      out.write("  // gets all the input tags in frm, and their number\n");
      out.write("  var inpfields = frm.getElementsByTagName('ch');\n");
      out.write("  var nr_inpfields = inpfields.length;\n");
      out.write("  // traverse the inpfields elements, and adds the value of selected (checked) checkbox in selchbox\n");
      out.write("  for(var i=0; i<nr_inpfields; i++) {\n");
      out.write("    if((inpfields[i].type === 'checkbox') && (inpfields[i].checked === true)) selchbox.push(inpfields[i].value);\n");
      out.write("  }\n");
      out.write("    \n");
      out.write("  if(selchbox.length!==0){\n");
      out.write("    ");
 Catch.likes =
      out.write("=selchbox.map(Number);\n");
      out.write("            \n");
      out.write("    }\n");
      out.write("          \n");
      out.write("  clic();\n");
      out.write("  }    \n");
      out.write("    function clic(){\n");
      out.write("        \n");
      out.write("        location.href=\"all_like.jsp\";\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("   \n");
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

<%-- 
    Document   : checklogin
    Created on : Oct 14, 2017, 8:16:17 PM
    Author     : AARON
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="package1.Catch"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <% Catch.name=request.getParameter("username");
           Connection conn;

 PreparedStatement ps;
 ResultSet rs;
   Class.forName("com.mysql.jdbc.Driver");
    conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
    ps=(PreparedStatement)conn.prepareStatement("select * from person where username=? and password=?");
    ps.setString(1, Catch.name);
    ps.setString(2, request.getParameter("password"));
    rs=ps.executeQuery();
if(!rs.next()) 
{ response.sendRedirect("index.html"); }else{
    response.sendRedirect("logged.jsp");
}
%>
    </body>
</html>

<%-- 
    Document   : uploading
    Created on : Oct 15, 2017, 12:00:36 AM
    Author     : AARON
--%>

<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="package1.Catch"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="java.io.InputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="stylesheet1.css">
    </head>
    <body style="background-image: url(music4.jpg); color: white;">
   
      
       
        
      
            <h1 style="color: black;">MP3-ZONE</h1>
            <ul class="nav">
  <li class="nav1"><a  href="hiphop.jsp">Hip-hop</a></li>
  <li class="nav1"><a href="gospel.jsp">Gospel</a></li>
  <li class="nav1"><a href="zimdancehall.jsp">Zim-Dancehall</a></li>
  <li class="nav1"><a href="logged.jsp">All</a></li>
  <li class="nav1"><a class="active" href="upload.jsp">Upload</a></li>
  <li class="nav1"><a href="myaccount.jsp">My Account</a></li>
  <li class="nav1"><a href="index.html">Home</a></li>
</ul><br>

<blockquote style="font-size: 20px;"><strong>LOGGED IN AS: &nbsp;&nbsp;&nbsp;<% out.print(Catch.name.toUpperCase());%> </strong>  </blockquote><br>
 
        <%
               
         
        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client
         PreparedStatement ps;
        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
    conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
    
 
            // constructs SQL statement
            
             String so=request.getParameter("song");
    
  
    
    
    ps=( PreparedStatement) conn.prepareStatement("INSERT INTO `songs`( `name`, `size`, `song`, `artist`, `genre`, `year`, `username`) VALUES (?,?,?,?,?,?,?)");
    ps.setString(1, request.getParameter("name").trim());
    ps.setInt(2, 200);
    ps.setString(3, so);
    ps.setString(4, request.getParameter("artist").trim());
    ps.setString(5, request.getParameter("genre").trim());
    ps.setString(6, request.getParameter("year").trim());
    ps.setString(7,Catch.name);
   if(ps.executeUpdate()>0){
       %>
       
       <blockquote>
           <strong>  Your upload was successful!! Thank you for your service.</strong>
       </blockquote>
       
       <%
   }else{
   %>
    <blockquote>
        <strong>  Sorry your upload was not successful!!</strong>
       </blockquote>
   <%
   }
   
        } catch (SQLException ex) {%>
           <blockquote>
        <strong>  Sorry your upload was not successful!!</strong>
       </blockquote>
          <%  }
        %>
    </body>
</html>

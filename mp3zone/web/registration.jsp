<%-- 
    Document   : uploading
    Created on : Oct 15, 2017, 12:00:36 AM
    Author     : AARON
--%>

<%@page import="java.sql.Date"%>
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
  <li class="nav1" style="float: right;"><a  href="index.html">Home</a></li>
             </ul><br><br>


 
        <%
               
         
        Connection con = null; // connection to the database
        
         PreparedStatement ps;
        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
    con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
     String unam;
     unam=request.getParameter("username");
     ps=(PreparedStatement)con.prepareStatement("INSERT INTO `person`(`person_id`, `name`, `surname`, `username`, `gender`, `cell`, `dob`, `password`, `address_id`,`hobbie1`,`hobbie2`,`hobbie3`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
           ps.setString(1, null);
           unam=request.getParameter("username").trim();
           ps.setString(2, request.getParameter("name").trim());
            ps.setString(3, request.getParameter("surname").trim());
            ps.setString(4,unam );
            ps.setString(5, request.getParameter("gender").trim());
            ps.setString(6, request.getParameter("cell").trim());
           
    
            ps.setDate(7, Date.valueOf((request.getParameter("day").trim())));
            ps.setString(8, request.getParameter("password").trim());
            ps.setInt(9,56 );
            ps.setString(10,"" );
            ps.setString(11,"" );
            ps.setString(12,"");
            ps.executeUpdate();
           java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            ps=(PreparedStatement)con.prepareStatement("INSERT INTO `log`(`username`, `date`) VALUES (?,?)");
            ps.setString(1, unam);
            ps.setDate(2, sqlDate);
            ps.executeUpdate();
            ps= (PreparedStatement)con.prepareStatement("INSERT INTO `address`(`address_id`, `country`, `city`, `province`, `city_location`) VALUES (?,?,?,?,?)");
            ps.setString(1, unam);
            ps.setString(2, request.getParameter("country").trim());
            ps.setString(3, request.getParameter("city").trim());
            ps.setString(4, request.getParameter("province").trim());
            ps.setString(5, request.getParameter("cityloc").trim());
                 
   if(ps.executeUpdate()>0){
       %>
       
       <blockquote>
           <strong>  you have successfully created your account!!</strong>
       </blockquote>
       
       <%
   }else{
   %>
    <blockquote>
        <strong>  Sorry account creation was not successful!!</strong>
       </blockquote>
   <%
   }
   
        } catch (SQLException ex) {
          %>
          <blockquote style="color: white;">
              Sorry there was an error during during creating your profile!!<br>
              <% out.println(ex); %>
          </blockquote>
<%
            }
        %>
    </body>
</html>

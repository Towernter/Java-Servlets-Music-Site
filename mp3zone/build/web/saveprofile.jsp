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
  <li class="nav1"><a  href="hiphop.jsp">Hip-hop</a></li>
  <li class="nav1"><a href="gospel.jsp">Gospel</a></li>
  <li class="nav1"><a href="zimdancehall.jsp">Zim-Dancehall</a></li>
  <li class="nav1"><a href="logged.jsp">All</a></li>
  <li class="nav1"><a  href="upload.jsp">Upload</a></li>
  <li class="nav1"><a class="active" href="myaccount.jsp">My Account</a></li>
  <li class="nav1"><a href="index.html">Home</a></li>
</ul><br>

<blockquote style="font-size: 20px;"><strong>LOGGED IN AS: &nbsp;&nbsp;&nbsp;<% out.print(Catch.name.toUpperCase());%> </strong>  </blockquote><br>
 
        <%
               
         
        Connection con = null; // connection to the database
        String message = null;  // message will be sent back to client
         PreparedStatement ps;
        try {
            // connects to the database
            Class.forName("com.mysql.jdbc.Driver");
    con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
     String unam;
     ps= (PreparedStatement)con.prepareStatement("update `person` set `name`=?, `surname`=?, `username`=?, `gender`=?, `cell`=?, `dob`=?, `password`=?, `address_id`=?,`hobbie1`=?,`hobbie2`=?,`hobbie3`=? where username=?");
           
           
           unam=request.getParameter("username");
           ps.setString(1, request.getParameter("fname"));
            ps.setString(2, request.getParameter("lname"));
            ps.setString(3,unam );
            ps.setString(4, request.getParameter("gender"));
            ps.setString(5, request.getParameter("cell"));
           
    
            ps.setDate(6, Date.valueOf((request.getParameter("dob"))));
            ps.setString(7, request.getParameter("password"));
            ps.setInt(8,56 );
            ps.setString(9, request.getParameter("hobbie1"));
           ps.setString(10, request.getParameter("hobbie2"));
           ps.setString(11, request.getParameter("hobbie3"));
           ps.setString(12, Catch.name);
           ps.executeUpdate();
           ps= (PreparedStatement) con.prepareStatement("UPDATE `address` SET `address_id`=?,`country`=?,`city`=?,`province`=?,`city_location`=? where address_id=?");
            ps.setString(1, unam);
            ps.setString(2, request.getParameter("country"));
             ps.setString(3, request.getParameter("city")); 
              ps.setString(4, request.getParameter("prov"));
               ps.setString(5, request.getParameter("cl"));
               ps.setString(6, Catch.name);
   if(ps.executeUpdate()>0){
       %>
       
       <blockquote>
           <strong>  Your profile has been saved successfully!!</strong>
       </blockquote>
       
       <%
   }else{
   %>
    <blockquote>
        <strong>  Sorry your upload was not successful!!</strong>
       </blockquote>
   <%
   }
   
        } catch (SQLException ex) {
          %>
          <blockquote style="color: white;">
              Sorry there was an error during saving your profile, please make sure you provide with name, date of birth, gender and password.
              <% out.println(ex); %>
          </blockquote>
<%
            }
        %>
    </body>
</html>

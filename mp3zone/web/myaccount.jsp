<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="package1.Catch"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<!DOCTYPE html>
<html>
    <head>
    	<title>Log In page</title>
    	<link rel="stylesheet" type="text/css" href="stylesheet1.css">
    	
        
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
   <body style="background-image: url(music4.jpg); color: white;">
   
     
       
        <form action="saveprofile.jsp" method="POST" >
      
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
 <blockquote class="bl" style="color: white;">  </blockquote><br>
 			 <fieldset style=" color: white; background-color: grey;">
                <legend>Your account details are shown:</legend>
                <p class="" style="padding-left: 30%;">
             	<br><br>
                <% 
Connection conn;
 ResultSet rs;
 PreparedStatement ps;
       try{
Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");   
    ps=conn.prepareStatement("select * from person where username=?");
ps.setString(1,Catch.name);
rs=ps.executeQuery();
while(rs.next()){
%>
           <input type="text" name="fname" required="required" size="60" placeholder="" value="<%= rs.getString("name") %>">(Name)<br><br>
           <input type="text" name="lname" required="required" size="60" placeholder="" value="<%= rs.getString("surname") %>">(Surname)<br><br>
           <input type="text" name="username" required="required" size="60" placeholder="" value="<%= rs.getString("username") %>">(Username)<br><br>
           <input type="text" name="gender" required="required" size="60" placeholder="" value="<%= rs.getString("gender") %>">(Gender)<br><br>
           <input type="text" name="cell"  size="60" placeholder="" value="<%= rs.getString("cell") %>">(Cell)<br><br>
           <input type="text" name="dob" required="required" size="60" placeholder="" value="<%= Date.valueOf(rs.getString("dob")) %>">(date of birth)<br><br>
           <input type="password" name="password" required="required" size="60" placeholder="" value="<%= rs.getString("password") %>">(Password)<br><br>
           <input type="text" name="hobbie1"  size="60" placeholder="" value="<%= rs.getString("hobbie1") %>">(Hobbie 1)<br><br>
           <input type="text" name="hobbie2"  size="60" placeholder="" value="<%= rs.getString("hobbie2") %>">(Hobbie 2)<br><br>
           <input type="text" name="hobbie3"  size="60" placeholder="" value="<%= rs.getString("hobbie3") %>">(Hobbie 3)<br><br>
             <%}%>
         
         <%   ps=conn.prepareStatement("select * from address where address_id=?"); 
              ps.setString(1, Catch.name);
              rs=ps.executeQuery();
              while(rs.next()){
         %>
         <input type="text" name="country"  size="60" placeholder="" value="<%= rs.getString("country") %>">(Country)<br><br>
         <input type="text" name="city"  size="60" placeholder="" value="<%= rs.getString("city") %>">(City)<br><br>
         <input type="text" name="cl"  size="60" placeholder="" value="<%= rs.getString("city_location") %>">(City_location)<br><br>
         <input type="text" name="prov"  size="60" placeholder="" value="<%= rs.getString("province") %>">(Province)<br><br>
         <% } %>
         </p>
         <blockquote class="" style=" padding-left: 43%;">
             <input type="submit" value="SAVE" />
         </blockquote>
     </fieldset><%   }catch(Exception ex){ %>
     <blockquote style="color: white;" >
            Sorry there was an error in displaying this page...
         </blockquote>
     <%  } %>
 </form>
    </body>
    </html>
    
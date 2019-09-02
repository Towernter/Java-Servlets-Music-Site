


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>


<%@page import="package1.Catch"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
    <head>
    	<title>Log In page</title>
    	<link rel="stylesheet" type="text/css" href="stylesheet1.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
   <body style="background-image: url(music4.jpg); color: white;">
 
        <form action="" method="POST">
      
            <h1 style="color: black;">MP3-ZONE</h1>
            <ul class="nav">
  <li class="nav1"><a  href="hiphop.jsp">Hip-hop</a></li>
  <li class="nav1"><a class="active" href="gospel.jsp">Gospel</a></li>
  <li class="nav1"><a  href="zimdancehall.jsp">Zim-Dancehall</a></li>
  <li class="nav1"><a  href="logged.jsp">All</a></li>
  <li class="nav1"><a href="upload.jsp">Upload</a></li>
  <li class="nav1"><a href="myaccount.jsp">My Account</a></li>
  <li class="nav1"><a href="index.html">Home</a></li>
</ul><br>
<blockquote style="font-size: 20px;"><strong>LOGGED IN AS: &nbsp;&nbsp;&nbsp;<% out.print(Catch.name.toUpperCase());%> </strong>&nbsp;&nbsp;&nbsp; </blockquote>
            
      
         </form>
          <form action="Gosplike" method="POST">
       
        


<div id="wrap">
   
        <div class="left" >
            <h4 style="padding-left: 10%;">RESULTS FOR SEARCH &nbsp;'gospel':</h4>
            
            <% 

int[] liked;
 int lc=0;
String[] fsong;
int fs=0;
String[] fsong2;
int fs2=0;
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
           if(rs.getString("genre").toLowerCase().contains("gospel")){
    %>
        	
        <blockquote  style=" background-color: #333; padding-left: 10%; padding-right: 10%; color: orange;">
            <audio controls >
            <source src="<%= rs.getString("song") %>"  />
</audio>
<%boolean yes=false;
for(int i=0;i<liked.length;i++){
    if(rs.getInt("song_id")==liked[i]){
       yes=true;
    }
}

%>
<%if(yes){%>
<input type="checkbox" name="ch" value="<%= rs.getInt("song_id") %>" checked="checked" onchange="this.form.submit()"><sub style="color: green;">LIKE</sub><br>

<%yes=false;}else{%>
<input type="checkbox" name="ch" value="<%= rs.getInt("song_id") %>" onchange="this.form.submit()"><sub style="color: green;">LIKE</sub><br>

<%yes=false;}%>
 TITLE : <% out.print(rs.getString("name"));     %><br>
 ARTIST: <% out.print(rs.getString("artist"));    %><br>
 YEAR  : <% out.print(rs.getString("year"));    %><br>
        </blockquote>
          <% }}}catch(Exception e){
              %>
              <blockquote>Sorry error in displaying page.</blockquote>
        <%
          }%>

</div><br>


 <div class="right">
   <%conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
   ps=conn.prepareStatement("");
   %>
        	<h4 style="padding-left: 8%;">RECOMMENDED FOR YOU:</h4>
        <blockquote  style=" background-color: #333; padding-left: 8%; padding-right: 10%; color: orange;">
        <audio controls loop draggable="true">
 	<source src="Rita Ora - Your Song (CDQ) (Mp3Goo.com).mp3"/>
 </audio><input type="checkbox" name="" value="10" onchange="this.form.submit()"><sub style="color: green;">LIKE</sub><br>
 TITLE : Rita Ora - Your Song (CDQ) (Mp3Goo.com)<br>
 ARTIST: RITA ORA<br>
 YEAR  : 2017<br>
      </blockquote><br> 
</div>

</div>
     
        </form>
    </body>
   
    </html>
    
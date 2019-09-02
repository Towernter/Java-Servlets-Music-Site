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
   
     
       
        <form action="uploading.jsp" method="POST" >
      
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
 <blockquote class="bl" style="color: white;">  welcome to our song upload section, for genres we suggest zim-dancehall, gospel or hip-hop </blockquote><br>
 			 <fieldset style=" color: white; background-color: grey;">
                <legend>Enter required details in the boxes provided below:</legend>
             <p class="r1">
             	<br><br>
             <input type="text" name="name" required="required" size="60" placeholder="Name of song"><br><br><br><br>
             <input type="text" name="year"  size="60" placeholder="Year of Release"><br><br><br><br>
             <input type="text" name="artist"  size="60" placeholder="Artist"><br><br><br><br>
             <input type="text" name="genre"  size="60" placeholder="Genre"><br><br><br><br>
            <br><br><br><br>
            <input type="file" name="song" />
             Upload:
             <input type="submit" value="submit" name="upload" />
         </p>
     </fieldset>
 </form>
    </body>
    </html>
    
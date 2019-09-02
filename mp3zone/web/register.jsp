

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stylesheet1.css">
        <title>account creation page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="background-image: url(music4.jpg);">
        <form action="registration.jsp" method="post">
             <h1>MP3-ZONE</h1>
             <ul class="nav">
  <li class="nav1" style="float: right;"><a  href="index.html">Home</a></li>
             </ul><br><br>
             <blockquote class="bl" style="color: white;"><b>Welcome to the mp3-zone registration page, please provide us with you details to register</b></blockquote><br><br><br>
             <fieldset style=" color: white; background-color: grey;">
                <legend>Enter required details in the boxes provided below:</legend>
             <p class="r1">
              <input type="text" name="name" required="required" size="60" placeholder="Name"><br><br>
        	 <input type="text" name="surname" required="required" size="60" placeholder="Surname"><br><br>
             <input type="text" name="username" required="required" size="60" placeholder="Username"><br><br>
        	 <select required="required" name="gender">
        	 	<option >male</option>
        	 	<option >female</option>
        	 </select><br><br>
                 <input type="text" name="cell" placeholder="cell number" size="60">(optional)<br><br>
                 <input type="date" name="day">(Date of Birth)<br><br>
                 <input type="text" name="country" placeholder="Country" size="60" required="required"><br><br>
                 <input type="text" name="city" placeholder="City" size="60" required="required"><br><br>
                 <input type="text" name="province" placeholder="Province" size="60" required="required"><br><br>
                 <input type="text" name="cityloc" placeholder="City Location" size="60">(optional)<br><br>
        	 <input type="Password" name="password" required="required" size="60" placeholder="Password"><br><br>
        	 <input type="Password" name="vpassword" required="required" size="60" placeholder="Verify Password"><br><br>
        	 </p>
                 <blockquote class="r2" >
        	 	<input type="submit" name="" value="submit"  >
        	 </blockquote>
             
                 </fieldset>
             <blockquote class="bl1">
                 You can provide more information after login. Clicking the submit button will save the information you provide and take you back to the login page.
             </blockquote>
             <script type="text/javascript">
                function log_in(){
                    location.href="index.html"
                }
             </script>
        </form>
    </body>
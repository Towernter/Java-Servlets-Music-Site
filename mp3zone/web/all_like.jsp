

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="package1.Catch"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%  int[] thr;
        int t=0;
        int f=0;
            ResultSet rs;
            Connection con;
            PreparedStatement ps;
           String[] ar=request.getParameterValues("ch");
           for(String x:ar){
               out.println(x);
           }
            try{
                
               
                Class.forName("com.mysql.jdbc.Driver");
    con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
    ps=(PreparedStatement) con.prepareStatement("select * from likes where person_id=?");
                ps.setString(1, Catch.name);
                rs=ps.executeQuery();
                while(rs.next()){
                f++;
                }
    
                thr=new int[f];
                f=0;
                ps=(PreparedStatement) con.prepareStatement("select * from likes where person_id=?");
                ps.setString(1, Catch.name);
                rs=ps.executeQuery();
                while(rs.next()){
                thr[f]=rs.getInt("song_id");
                f++;
                }
                    
                Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
     java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
//if(f!=0){
          ps=(PreparedStatement)con.prepareStatement("DELETE FROM `likes` WHERE person_id=?");
            ps.setString(1, Catch.name);
            ps.executeUpdate();
            for(String x:ar){
                for(int y:thr){
                    
                    if(Integer.parseInt(x)==y){
                        t=1;
                    } 
                    }
                if(t==1){
                        
                ps=(PreparedStatement)con.prepareStatement("INSERT INTO `likes`(`time`, `like_id`, `person_id`, `song_id`, `tag`) VALUES (?,?,?,?,?)");
                 ps.setTimestamp( 1, Timestamp.valueOf(sqlDate+" "+sdf.format(cal.getTime())));
                ps.setString(2, null);
                ps.setString(3, Catch.name);
                ps.setInt(4, Integer.parseInt(x));
                ps.setString(5, "nr");
                ps.executeUpdate();}
                   
                    else{
                        
                   ps=(PreparedStatement)con.prepareStatement("INSERT INTO `likes`(`time`, `like_id`, `person_id`, `song_id`, `tag`) VALUES (?,?,?,?,?)");
                 ps.setTimestamp(1, Timestamp.valueOf(sqlDate+" "+sdf.format(cal.getTime())));
                ps.setString(2, null);
                ps.setString(3, Catch.name);
                ps.setInt(4, Integer.parseInt(x));
                ps.setString(5, "r");
                ps.executeUpdate();}
                  t=0; 
            }
          response.sendRedirect("logged.jsp");
            }catch(Exception e){
            out.println(e);}
        %>
    </body>
</html>

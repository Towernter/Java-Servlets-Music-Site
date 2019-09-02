/***
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import package1.Catch;

/**
 *
 * @author AARON
 */
@WebServlet(urlPatterns = {"/All_like"})
public class All_like extends HttpServlet {
public int t=0;
   public Connection conn;
public PreparedStatement ps;
public ResultSet rs;
public List<Integer> thr=new ArrayList<>();
public void con(String q) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
    ps=conn.prepareStatement(q);
}

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String[] ar=req.getParameterValues("ch");
            try{
                
                con("select * from likes where person_id=?");
                ps.setString(1, Catch.name);
                rs=ps.executeQuery();
                while(rs.next()){
                thr.add(rs.getInt("song_id"));
                }
                    
                Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
     java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

            con("DELETE FROM `likes` WHERE person_id=?");
            ps.setString(1, Catch.name);
            ps.executeUpdate();
            for(String x:ar){
                for(int y:thr){
                    
                    if(Integer.parseInt(x)==y){
                        t=1;
                    } 
                    }
                if(t==1){
                        
                con("INSERT INTO `likes`(`time`, `like_id`, `person_id`, `song_id`, `tag`) VALUES (?,?,?,?,?)");
                 ps.setTimestamp(1, Timestamp.valueOf(sqlDate+" "+sdf.format(cal.getTime())));
                ps.setString(2, null);
                ps.setString(3, Catch.name);
                ps.setInt(4, Integer.parseInt(x));
                ps.setString(5, "nr");
                ps.executeUpdate();}
                   
                    else{
                        
                     con("INSERT INTO `likes`(`time`, `like_id`, `person_id`, `song_id`, `tag`) VALUES (?,?,?,?,?)");
                 ps.setTimestamp(1, Timestamp.valueOf(sqlDate+" "+sdf.format(cal.getTime())));
                ps.setString(2, null);
                ps.setString(3, Catch.name);
                ps.setInt(4, Integer.parseInt(x));
                ps.setString(5, "r");
                ps.executeUpdate();}
                  t=0; 
            }
          
            }catch(ClassNotFoundException | SQLException | NumberFormatException  e){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Like_save</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+e+"</h1>");
            out.println("</body>");
            out.println("</html>");}
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(All_like.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(All_like.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

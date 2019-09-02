/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.SQLException;
import static javaapplication2.AlgoMain.conn;
import static javaapplication2.AlgoMain.ps;
import static javaapplication2.AlgoMain.rs;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;

/**
 *
 * @author AARON
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
        try{Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
 
/*
    String sql = "SELECT * FROM songs";
            ps= conn.prepareStatement(sql);
           
 
            rs = ps.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob("song");
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream("C:\\Users\\AARON\\Documents\\NetBeansProjects\\mp3zone\\resources\\");
                
                int bytesRead = -1;
                byte[] buffer = new byte[4096];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
 
                inputStream.close();
                outputStream.close();
                System.out.println("File saved");
            }
            conn.close();*/
    File f=new File("C:\\Users\\AARON\\Documents\\NetBeansProjects\\mp3zone\\resources\\DJ_Khaled_feat_Nicki_Minaj_feat_Chris_Brown_feat_August_Alsina_Do_You_Mind.mp3");
    String so=f.getAbsolutePath();
    System.out.println(so);
   /* if(!f.exists()){
        System.out.println("not there");
    }*/
   /* int size=(int) f.length();
    byte[] bytes=new byte[size];
    FileInputStream in=new FileInputStream(f);
    in.read(bytes);
    
    ps=conn.prepareStatement("INSERT INTO `songs`( `name`, `size`, `song`, `artist`, `genre`, `year`, `username`) VALUES (?,?,?,?,?,?,?)");
    ps.setString(1, "");
    ps.setInt(2, size);
    ps.setBytes(3, bytes);
    ps.setString(4, "ariana grande");
    ps.setString(5, "POP");
    ps.setString(6, "2017");
    ps.setString(7,"amayendesa");
    if(ps.executeUpdate()>0){
        System.out.println("done");}
    else{System.out.println("not done");}*/
        }catch(Exception e){
            System.out.println(e);
        }
    }  }
 /*public static void parseAllFiles(String parentDirectory){
         String rootDir = System.getenv("SystemDrive");
        System.out.println("PARSED FILES ::" + rootDir);
 
        File[] filesInDirectory = new File(parentDirectory).listFiles();
        for (File f : filesInDirectory){    
if(f.isDirectory()){
                parseAllFiles(f.getAbsolutePath());
            }
            System.out.println("Current File -> " + f);  
            System.out.println(f.getPath());
 
            File f1 = new File(f.getPath()+"\\aaron.txt");
 
            System.out.println("filename : " + f1.exists());
 
 
            boolean exists = f1.exists();
            System.out.println("exists : "+exists);
            if (exists) {
                System.out.println("Path::" + f1.getPath());
            } else {
                System.out.println("Does not exist");
    }    
        }}}
*/
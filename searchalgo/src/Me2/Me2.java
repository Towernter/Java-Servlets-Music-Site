/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Me2;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static javaapplication2.AlgoMain.conn;
import static javaapplication2.AlgoMain.ps;
import static javaapplication2.AlgoMain.rs;
import practice.AlgoMain2;

/**
 *
 * @author AARON
 */
public class Me2 {
    
   // algo when there's recent post
   public static int rpost;
   public static void con(String q) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
    ps=conn.prepareStatement(q);
}

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
   
   String[][] finale;     
   int nt=0;
   int z=0;
   List<Integer> num1=new ArrayList<>();
   List<Integer> num2=new ArrayList<>();
   List<Integer> num3=new ArrayList<>();
   List<Integer> num4=new ArrayList<>();
   List<Integer> num5=new ArrayList<>();//array of indexes
   List<String> dn=new ArrayList<>();
   List<String> d2=new ArrayList<>();
   int[] num6,num7;
       
   AlgoMain2 algo=new AlgoMain2();
   dn=algo.found;
       /*java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
           Date dateBefore = new Date(sqlDate.getTime() - 3 * 24 * 3600 * 1000  );
        con("select * from log where date>=? and username!=?");//get all that logged in past 3 days
        ps.setDate(1, dateBefore);
        ps.setString(2, "pzunza");
        rs=ps.executeQuery();
        while(rs.next()){
            dn.add(rs.getString("username"));
        }  */
        
        con("select * from likes where person_id=? and tag=?");//get recent post of person logged in
        ps.setString(1, "pzunza");
        ps.setString(2, "r");
        rs=ps.executeQuery();
        if(rs.next()){
            rpost=rs.getInt("song_id");
        }
        
        
        for(String x:dn){//from d get from likes all usernames that have rpost
            con("select * from likes where song_id=? and person_id=?");
            ps.setInt(1, rpost);
            ps.setString(2, x);
            rs=ps.executeQuery();
            while(rs.next()){
                d2.add(rs.getString("person_id"));
            }
        }
       
        
        for(String x:d2){// for each person_id in d2, get from likes the post_id and put into list num1
            con("select * from likes where person_id=? and song_id!=?");
            ps.setString(1, x);
            ps.setInt(2, rpost);
            rs=ps.executeQuery();
            while(rs.next()){
                num1.add(rs.getInt("song_id"));
            }
        }
         
        
        Collections.sort(num1);//sort all post_id's in num1 from likes table
        
        con("select * from songs where username!=?");//get all post_id's from post table where username in not of logged in person
        ps.setString(1, "pzunza");
        rs=ps.executeQuery();
        while(rs.next()){
            num2.add(rs.getInt("song_id"));
        }
        
        for(int x:num2){//comparison to find how many times each post is liked
            for(int y:num1){
                if(x==y){
                    nt++;
                }
            }num3.add(z, nt);
            nt=0;
            z++;
        }
        z=0;
       
     num6=new int[num3.size()];
        for(int i=0;i<num3.size();i++){
            num6[i]=num3.get(i);
        }
       num4=num3;
       Collections.sort(num4);//sort matches in num4
       
       Collections.reverse(num4);// reverse above array
       
       
    num7=num6;//arrays not array lists
       for(int x:num4){       
                   for(int i=0;i<num3.size();i++){
                       if((x==num6[i])&&(x!=0)){
                        num5.add(i);
                        num6[i]=(num4.get(0)+1);
                       }
                       
                   }
                    }
       num3.clear();
        for(int x:num5){
            num3.add(num2.get(x));
        }
        
        finale=new String[num3.size()][4];
        
      for(int x=0;x<num3.size();x++){
           con("select * from songs where song_id=?");
           ps.setInt(1, num3.get(x));
           rs=ps.executeQuery();
           while(rs.next()){
               finale[x][0]=rs.getString("username");
               finale[x][1]=rs.getString("post");
               finale[x][2]=String.valueOf(rs.getTimestamp("time"));
               finale[x][3]=String.valueOf(rs.getInt("post_id"));
           }
       }
      for(int x=0;x<num3.size();x++){
          System.out.println(finale[x][0]+" "+finale[x][1]+" "+finale[x][2]+" "+finale[x][3]);
      }
    
    }}

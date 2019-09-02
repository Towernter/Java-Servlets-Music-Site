/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;
import static Me2.Me2.con;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static javaapplication2.AlgoMain.ps;
import static javaapplication2.AlgoMain.rs;

/**
 *
 * @author AARON
 */
public class Me {
   //algo when there's no recent post;
    
    
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        
    int nt=0;
   int z=0;
   int rpost;
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
     /*  java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
           Date dateBefore = new Date(sqlDate.getTime() - 3 * 24 * 3600 * 1000  );
        con("select * from log where date>=? and username!=?");//get all that logged in past 3 days
        ps.setDate(1, dateBefore);
        ps.setString(2, "kmay");
        rs=ps.executeQuery();
        while(rs.next()){
            dn.add(rs.getString("username"));
        }  */
        
        /*con("select * from likes where person_id=?");//get recent post of person logged in
        ps.setString(1, "kmay");
        rs=ps.executeQuery();
        if(rs.next()){
            rpost=rs.getInt("post_id");
        }*/
        
        
        /*for(String x:d){//from d get from likes all usernames that have rpost
            con("select * from likes where post_id=? and person_id=?");
            ps.setInt(1, rpost);
            ps.setString(2, x);
            rs=ps.executeQuery();
            while(rs.next()){
                d2.add(rs.getString("person_id"));
            }
        }*/
       
        
        for(String x:dn){// for each person_id in d, get from likes the post_id and put into list num1
            con("select * from likes where person_id=?");
            ps.setString(1, x);
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
      for(int x: num3){
           con("select * from songs where song_id=?");
           ps.setInt(1, x);
           rs=ps.executeQuery();
           while(rs.next()){
               System.out.println(rs.getString("post"));
           }
       }
    
    }
}

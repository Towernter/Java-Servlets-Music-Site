/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javaapplication2.Person;

/**
 *
 * @author AARON
 */

public class AlgoMain2 {
    static List<String> d=new ArrayList<>();
public static int n=0;
public static int[] f;
public static int[] f2,f3;
public static Connection conn;
public static PreparedStatement ps;
public static ResultSet rs;
public static int num=0;
public static  ArrayList<Person> cust; // arraylist to contain all persons from database 
public static Person people;      // reference variable to store person object
public static List<String> found;      // array to contain all usernames in order after matches found
public static int fq1=0;
public static int fq=0;
public static String[] array1;     // array to contain all usernames from database before matches found
public static String username,country,city,province,city_location,hob1,hob2,hob3;

public static void con(String q) throws ClassNotFoundException, SQLException{
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/friends", "root","");
    ps=conn.prepareStatement(q);
}

  
    public AlgoMain2() throws ClassNotFoundException, SQLException {
       
         try{
       java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
           Date dateBefore = new Date(sqlDate.getTime() - 3 * 24 * 3600 * 1000  );
        con("select * from log where date>=? and username!=?");//get all that logged in past 3 days
        ps.setDate(1, dateBefore);
        ps.setString(2, "pzunza");
        rs=ps.executeQuery();
        while(rs.next()){
            d.add(rs.getString("username"));
        }  
        
        String[] p=new String[7];        // array containing data of logged in person
        
        /*con("select * from person"); // working out number of persons in database start
        rs=ps.executeQuery();
        while (rs.next()){
            fq+=1;
                         } */          // working out number of persons in database end
        
        array1=new String[d.size()];
        for(String x:d){
        con("select * from person  where username=?"); //getting usernames of all persons in database start
        ps.setString(1,x);
        rs=ps.executeQuery();
        while(rs.next()){
            array1[fq1]=rs.getString("username");
            fq1+=1;
        } 
        //getting usernames of all persons in database end
        }
        fq1=0;
        
        
        con("SELECT * FROM `address` WHERE address_id=?");   // inserting data of logged in person into array p start
        ps.setString(1, "pzunza");
        rs=ps.executeQuery();
        while(rs.next()){
        p[0]=rs.getString("country").toLowerCase();
        p[1]=rs.getString("city").toLowerCase();
        p[2]=rs.getString("province").toLowerCase();
        p[3]=rs.getString("city_location").toLowerCase(); 
        p[4]=rs.getString("hobbie1").toLowerCase();
        p[5]=rs.getString("hobbie2").toLowerCase();
        p[6]=rs.getString("hobbie3").toLowerCase();
        }
       
                            // inserting data of logged in person into array p end
        
        cust=new ArrayList<>();// arraylist containing all persons from database
        
                                                    //getting all persons from database to arraylist start
        for(int i=0;i<d.size();i++){
            
        con("SELECT * FROM `address` where address_id=?");
        ps.setString(1, array1[i]);
        rs=ps.executeQuery();
        while(rs.next()){
        username=rs.getString("address_id").toLowerCase();
        country=rs.getString("country").toLowerCase();
        city=rs.getString("city").toLowerCase();
        province=rs.getString("province").toLowerCase();
        city_location=rs.getString("city_location").toLowerCase(); 
        hob1=rs.getString("hobbie1").toLowerCase();
        hob2=rs.getString("hobbie2").toLowerCase();
        hob3=rs.getString("hobbie3").toLowerCase();
        }
        
        
        people=new Person(username,country,city,province,city_location,hob1,hob2,hob3);
        cust.add(people);
        
        }                               //getting all persons from database to arraylist end
        
        
        found=new ArrayList<>(); //array containing final match usernames
        
        
        f=new int[cust.size()];
        f2= new int[cust.size()];
        f3=new int[cust.size()];
                                                       //looking for matches start
        for(int i=0;i<cust.size();i++){
            if(p[0].equals(cust.get(i).getCountry())){
                n+=1;
            }
            if(p[1].equals(cust.get(i).getCity())){
                n+=1;
            }
            if(p[2].equals(cust.get(i).getProvince())){
                n+=1;
            }
            if(p[3].equals(cust.get(i).getCity_location())){
                n+=1;
            }
             if(p[4].equals(cust.get(i).getHob1())){
                n+=1;
            }
             if(p[5].equals(cust.get(i).getHob2())){
                n+=1;
            } 
             if(p[6].equals(cust.get(i).getHob3())){
                n+=1;
            }
            f[i]=n;
            f3[i]=n;
            n=0;
        }
        
        int na=0;
            int[] f4=new int[cust.size()];// array containing index numbers of matches
          
            
            f2=f;
                      
            Arrays.sort(f2);// sorting of array with matches
        
              int h=f2[d.size()-1]+1; 
              
                                            // getting index number of each match from from sorted array start
           for(int z=(cust.size()-1);z>=0;z--){       
                    for(int y=0;y<cust.size();y++)
                    {
                        if(f2[z]==f3[y])
                        {
                            f4[na]=y;
                            f3[y]=h;
                            na+=1;
                           
                        } 
                    }
            }// getting index number of each match from from sorted array end
      
           
        for(int i=0;i<cust.size();i++){
                 found.add(cust.get(f4[i]).getUnam());   //inserting usernames of ordered matches
        }
        
       
       
 }catch(ClassNotFoundException | SQLException e){   
     e.printStackTrace();
 }
        
    }

}

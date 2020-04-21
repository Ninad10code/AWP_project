/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;
import datapack.Professionals;
import datapack.Users;
import java.util.*;
import java.sql.*;

/**
 *
 * @author kumar
 */
public class Userservices {
    
     ArrayList<Users> userlist  = new ArrayList<Users>();
     
    
    public  ArrayList<Users> getUsersList()
    {
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                String sql = "SELECT * FROM users;";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       Users user = new Users();

                       user.setid(Integer.parseInt(rs.getString(1)));
                       user.setname(rs.getString(2));
                       user.setpassword(rs.getString(3));
                       user.setemail(rs.getString(4));
                       user.setmob_no(rs.getString(5));
                       user.setaddress(rs.getString(6));
                       user.setgender(rs.getString(7));
                       user.setImage_url(rs.getString(8));
                       
                       userlist.add(user);

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return userlist;
            
        
    }
    
    
    public boolean register_user(Users user)
    { 
      
        
        try
        {
            
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");


            String query = "insert into users(name, password, email, mob_no, address, gender) values (?,?,?,?,?,?);";

            PreparedStatement pstmt = conn.prepareStatement(query);
           
            pstmt.setString(1,user.getname());
            pstmt.setString(2,user.getpassword());
            pstmt.setString(3,user.getemail());
            pstmt.setString(4,user.getmob_no());
            pstmt.setString(5,user.getaddress());
            pstmt.setString(6,user.getgender());
         
            
            

            pstmt.executeUpdate();
            
            return true;
            
        } 
        catch(Exception e)
        {
            System.out.println("Error");
            
        }
        
        return false;
        
    }     
    
    
     public boolean login(String name , String password)
   {
     try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                String sql = "SELECT * FROM users;";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       Users ad = new Users();
                       
                       ad.setname(rs.getString(2));
                       ad.setpassword(rs.getString(3));
                       
                       if(ad.getname().equals(name) && ad.getpassword().equals(password))
                       {
                           return true;
                       }
                       
                       
                       
                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return false;
           
       
   }
    
    
    
   
    
}

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
                       
                       
                       userlist.add(user);

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return userlist;
            
        
    }
    
    
    
    
}

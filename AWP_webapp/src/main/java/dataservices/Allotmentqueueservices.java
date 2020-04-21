/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;

import datapack.Allotmentqueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author kumar
 */
public class Allotmentqueueservices {
    
    
    public Allotmentqueue getTopProfessinal(String id)
    {   
        
        
             Allotmentqueue aq = new Allotmentqueue();
             int flag = 0;
           
         
         try{
            
             
                
             
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                 String sql = "SELECT * FROM allotmentqueue WHERE service_id="+id;

                
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
              
                      while(rs.next())
                      {   
                        
                        aq.setProfessional_id(Integer.parseInt(rs.getString(1)));
                        aq.setService_id(Integer.parseInt(rs.getString(2)));
                        
                        flag = 1;
                       
                        break;
                        
                      }
                      
                   
            
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
         
       
          return aq;  
        
     
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

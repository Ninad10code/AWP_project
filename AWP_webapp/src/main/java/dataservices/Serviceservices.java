/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;
import datapack.Packages;
import datapack.Services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kumar
 */
public class Serviceservices {
    
    
     
   
    
    public ArrayList<Services> getServicesByPackageId(String id)
    {
        
        
         ArrayList<Services> servicelist = new ArrayList<Services>();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                 String sql = "SELECT * FROM services WHERE package_id="+id;

            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                      
                        Services serv = new Services();
                        
                        serv.setId(Integer.parseInt(rs.getString(1)));
                        serv.setName(rs.getString(2));
                        serv.setPrice(Integer.parseInt(rs.getString(3)));
                        serv.setDescription(rs.getString(4));
                        serv.setImage_url(rs.getString(5));
                        serv.setPackage_id(Integer.parseInt(rs.getString(6)));
                        
                        servicelist.add(serv);
                        
                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return servicelist;
        
    }
    
    
    
    
    
     public Services getServicesByServiceId(String id)
    {   
        
           
        
                        Services serv = new Services();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                 String sql = "SELECT * FROM services WHERE id="+id;

            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                      
                        
                        serv.setId(Integer.parseInt(rs.getString(1)));
                        serv.setName(rs.getString(2));
                        serv.setPrice(Integer.parseInt(rs.getString(3)));
                        serv.setDescription(rs.getString(4));
                        serv.setImage_url(rs.getString(5));
                        serv.setPackage_id(Integer.parseInt(rs.getString(6)));
                        
                       
                        
                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return serv;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
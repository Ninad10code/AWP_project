/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;

import datapack.Professionals;
import java.util.*;
import java.sql.*;


/**
 *
 * @author kumar
 */
public class Professionalservices {
    
     ArrayList<Professionals> proflist  = new ArrayList<Professionals>();
     
    
    public  ArrayList<Professionals> getProfessionalsList()
    {
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                String sql = "SELECT * FROM professionals;";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       Professionals prof = new Professionals();

                       prof.setid(Integer.parseInt(rs.getString(1)));
                       prof.setname(rs.getString(2));
                       prof.setpassword(rs.getString(3));
                       prof.setprofession(rs.getString(4));
                       prof.setemail(rs.getString(5));
                       prof.setmob_no(rs.getString(6));
                       prof.setaddress(rs.getString(7));
                       prof.setgender(rs.getString(8));
                       prof.setstatus(rs.getString(9));
                       prof.setrating(rs.getString(10));
                       prof.setsalary(rs.getString(11));
                       prof.settotal_services(rs.getString(12));

                       proflist.add(prof);

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return proflist;
            
        
    }
    
    
    public Professionals getProfessinalsById(String id)
    {   
         Professionals prof = new Professionals();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                String sql = "SELECT * FROM professionals WHERE id=+"+"'"+id+"'"+";";

            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                      

                       prof.setid(Integer.parseInt(rs.getString(1)));
                       prof.setname(rs.getString(2));
                       prof.setpassword(rs.getString(3));
                       prof.setprofession(rs.getString(4));
                       prof.setemail(rs.getString(5));
                       prof.setmob_no(rs.getString(6));
                       prof.setaddress(rs.getString(7));
                       prof.setgender(rs.getString(8));
                       prof.setstatus(rs.getString(9));
                       prof.setrating(rs.getString(10));
                       prof.setsalary(rs.getString(11));
                       prof.settotal_services(rs.getString(12));

                       

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return prof;
        
        
        
    }
    
    
      public  ArrayList<Professionals> getProfessinalsByProfession(String profession)
    {   
          ArrayList<Professionals> proflist  = new ArrayList<Professionals>();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                String sql = "SELECT * FROM professionals WHERE profession=+"+"'"+profession+"'"+";";

            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                      Professionals prof = new Professionals();

                       prof.setid(Integer.parseInt(rs.getString(1)));
                       prof.setname(rs.getString(2));
                       prof.setpassword(rs.getString(3));
                       prof.setprofession(rs.getString(4));
                       prof.setemail(rs.getString(5));
                       prof.setmob_no(rs.getString(6));
                       prof.setaddress(rs.getString(7));
                       prof.setgender(rs.getString(8));
                       prof.setstatus(rs.getString(9));
                       prof.setrating(rs.getString(10));
                       prof.setsalary(rs.getString(11));
                       prof.settotal_services(rs.getString(12));

                       proflist.add(prof);

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return proflist;
        
        
        
    }
    
      
 
    
    
    
    
}

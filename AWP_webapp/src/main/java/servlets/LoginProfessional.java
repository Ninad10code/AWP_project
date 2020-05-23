/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datapack.Professionals;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Suruchi
 */
@WebServlet(name = "LoginProfessional", urlPatterns = {"/loginprof_servlet"})
public class LoginProfessional extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
            /* TODO output your page here. You may use following sample code. */
            String name=request.getParameter("name");
            String password=request.getParameter("pass");
            /*out.print("<h1>Successfully started process!!!</h1>");
out.print("<h1>Successfully started process!!!</h1>");*/
            //out.print("<h1>Successfully started process!!!</h1>");
            //ProfessionalDAO profdao=new ProfessionalDAO();
           // public Professionals LoginCheck(String name,String password) throws SQLException,ClassNotFoundException, FileNotFoundException
    //{
        /*String jdbcURL = "jdbc:mysql://localhost:3306/proserv";
        String dbUser = "root";
        String dbPassword = "Suruchi@2001";*/
        PrintWriter out = response.getWriter();
        Professionals prof;
        try{
            Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","root");
                //String sql = "SELECT * FROM professionals;";
            String sql = "SELECT * FROM professionals WHERE name = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            prof = null;
            if (result.next()) {
                prof = new Professionals();
                prof.setname(result.getString("name"));
                prof.setpassword(result.getString("password"));
                prof.setid(Integer.parseInt(result.getString("id")));
            }
        
 
        //Professionals prof = profdao.LoginCheck(name,password);
        String destPage="indexProfessional.jsp";
        if(prof!=null)
        {
            //HttpSession session = request.getSession();
            //session.setAttribute("professional", prof);
            out.print("<h1>Successfully logged in!!!</h1>");
            Cookie ck=new Cookie("name",name);
            response.addCookie(ck);
            String id;
                id = Integer.toString(prof.getid());
            request.setAttribute("value",id );
            destPage = "professionalHomePage.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);
        }
        else{
            request.getRequestDispatcher("ErrorLogin.jsp").include(request,response);
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.include(request, response);
        }
        
         
        } 
        catch(ClassNotFoundException | SQLException  e)
        {
            throw new ServletException(e);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

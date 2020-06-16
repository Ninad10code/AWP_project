/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datapack.Reviews;
import dataservices.Reviewservices;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 *
 * @author kumar
 */
public class Reviewservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Professionalservices pserv = new Professionalservices();
        Professionals prof = new Professionals();

        Reviews re = new Reviews();
        Reviewservices rserv = new Reviewservices();

        re.setName(request.getParameter("name"));
        re.setComment(request.getParameter("comment"));
        re.setRating(request.getParameter("rating"));

        String prof_id = request.getParameter("profid");

        prof = pserv.getProfessinalsById(prof_id);

        int num_services;
        float prev_rating;
        float rating;

        num_services = Integer.parseInt(prof.gettotal_services());
        prev_rating = Float.parseFloat(prof.getrating())*(num_services-1);

        rating = (prev_rating + Integer.parseInt(request.getParameter("rating")))/num_services;

        String rate = String.format("%.1f", rating);

        ServletContext context = getServletContext();


        if(rserv.RegisterReview(re))
        {
            pserv.updateProfRating(prof_id, rate);
            request.setAttribute("message","Thankyou for your valuable feedback");
            RequestDispatcher dispatcher = context.getRequestDispatcher("/writereview.jsp");
            dispatcher.forward(request,response);
        }
        else
        {
            request.setAttribute("message","some error occured try again");
            RequestDispatcher dispatcher = context.getRequestDispatcher("/writereview.jsp");
            dispatcher.forward(request,response);
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

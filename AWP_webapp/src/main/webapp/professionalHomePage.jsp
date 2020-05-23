<%-- 
    Document   : professionalHomePage
    Created on : Apr 13, 2020, 8:11:35 PM
    Author     : Dell
--%>

<%@page import="datapack.Professionals"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:include page="header.jsp"/> --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           
        
        <%
            
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Profileservlet");
                dispatcher.include(request, response);
        %>
        <br>
        <%
                request.getRequestDispatcher("professionalFeatures.jsp").include(request,response);
        %>
         
    </body>
</html>

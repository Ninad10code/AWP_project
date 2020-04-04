<%-- 
    Document   : profdetails
    Created on : 03-Apr-2020, 8:27:40 PM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="datapack.Professionals"%>

<jsp:include page="header.jsp"/> 

<br>
<br>

<div class="container-fluid">    
    <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Profession</th>
        <th>Mobile no.</th>
        <th>View Details</th>
        
      </tr>
    </thead>
    <tbody>
        
       
        
        <%
            List<Professionals> profli = (List<Professionals>)request.getAttribute("proflist");
            
            for(Professionals e : profli)
            {
             
        %>
     
      <tr>
        <td><%=e.getid()%></td>
        <td><%=e.getname()%></td>
        <td><%=e.getemail()%></td>
         <td><%=e.getprofession()%></td>
          <td><%=e.getmob_no()%></td>
          <td><a href="/AWP_webapp/Profileservlet?value=<%=e.getid()%>">view...</a></td>
      </tr>
      
      </a>
     
        <%
            }
            
         %>   
            
          </tbody>
  </table>
</div>      
        
        
        
   <jsp:include page="footer.jsp"/> 


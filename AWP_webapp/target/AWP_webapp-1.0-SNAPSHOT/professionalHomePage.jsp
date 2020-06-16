<%-- 
    Document   : professionalHomePage
    Created on : Apr 13, 2020, 8:11:35 PM
    Author     : Dell
--%>

<%@page import="datapack.Professionals"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/> 


        <%
                String id;

                id=session.getAttribute("current_id").toString();
                String link1="/AWP_webapp/updateProfessional.jsp?id="+id;
                String link2="/AWP_webapp/changeProfAvailability?value="+id;
                String profile="/AWP_webapp/Profileservlet?value="+id;
        %>
        
        <br><br>
    <div class="container">

    <div class="row">


        <div class="col-sm-4">

            <div class="card">
             <div class="card-header bg-primary text-white">Profile</div>
             <div class="card-body">Your Information</div>
             <div class="card-footer card bg-info text-white"><a href=<%=profile%> class="text-white">Click here</a></div>
           </div>
        </div>
           
           <div class="col-sm-4">
             <div class="card">
             <div class="card-header bg-primary text-white">Update</div>
             <div class="card-body">Edit your details here</div>
             <div class="card-footer card bg-info text-white"><a href=<%=link1%> class="text-white">Click here</a>
             </div>

           </div>
           </div>


        <div class="col-sm-4">

            <div class="card">
             <div class="card-header bg-primary text-white">Change Status</div>
             <div class="card-body">Change your Availability here</div>
             <p style="color:red">${message}</p>
             <div class="card-footer card bg-info text-white"><a href=<%=link2%> class="text-white">Click here</a></div>
           </div>

        </div>
        </div>
    </div>

</div>
   <jsp:include page="footer.jsp"/>

        
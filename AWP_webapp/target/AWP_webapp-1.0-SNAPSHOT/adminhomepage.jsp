<%-- 
    Document   : adminhomeage
    Created on : 04-Apr-2020, 1:04:13 PM
    Author     : kumar
--%>
<<<<<<< HEAD
<% 
=======
<%
>>>>>>> de72908e7504783578a495d2249ce0a8a45f61bc
    if(session.getAttribute("current")!=null)
    {
        String current=session.getAttribute("current").toString();
        if(!current.equals("admin"))
        {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/ErrorLogin.jsp");
<<<<<<< HEAD
               dispatcher.forward(request,response);
=======
                   dispatcher.forward(request,response);
>>>>>>> de72908e7504783578a495d2249ce0a8a45f61bc
        }
    }
    else
    {
        ServletContext context = getServletContext();
<<<<<<< HEAD
        RequestDispatcher dispatcher = context.getRequestDispatcher("/ErrorLogin.jsp");
        dispatcher.forward(request, response);
=======
            RequestDispatcher dispatcher = context.getRequestDispatcher("/ErrorLogin.jsp");
                   dispatcher.forward(request,response);
>>>>>>> de72908e7504783578a495d2249ce0a8a45f61bc
    }
    
%>
<jsp:include page="header.jsp"/>

<br>
<br>

<div class="container">

    <div class="row">


        <div class="col-sm-4">

            <div class="card">
             <div class="card-header bg-primary text-white">Users</div>
             <div class="card-body">View all the registered users</div>
             <div class="card-footer card bg-info text-white"><a href="/AWP_webapp/getallusers" class="text-white">Select</a></div>
           </div>

             <div class="card">
             <div class="card-header bg-primary text-white">Applications</div>
             <div class="card-body">View all the professional applications</div>
             <div class="card-footer card bg-info text-white"><a href="/AWP_webapp/NewProfessionalsApplications" class="text-white">Select</a>
             <p style="color:red">${message}</p>
             </div>

           </div>

        </div>





        <div class="col-sm-4">

            <div class="card">
             <div class="card-header bg-primary text-white">Professionals</div>
             <div class="card-body">See details of all the professionals</div>
             <div class="card-footer card bg-info text-white"><a href="/AWP_webapp/getprofessionals?value=default" class="text-white">Select</a></div>
           </div>

        </div>


        <div class="col-sm-4">

            <div class="card">
             <div class="card-header bg-primary text-white">Packages</div>
             <div class="card-body">View and modify the service packages</div>
             <div class="card-footer card bg-info text-white"><a href="/AWP_webapp/getallpackagesservlet" class="text-white">Select</a></div>
           </div>

        </div>






    </div>

</div>
















   <jsp:include page="footer.jsp"/>

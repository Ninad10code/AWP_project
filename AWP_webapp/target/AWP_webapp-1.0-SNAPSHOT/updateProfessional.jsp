 <%@page import="dataservices.Professionalservices"%>
<%@page import="datapack.Professionals"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = session.getAttribute("current_id").toString();

    Professionals prof=new Professionals();
    Professionalservices profserv=new Professionalservices();
    prof=profserv.getProfessinalsById(id);
%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="SignUp.css">
    <title>Update details</title>
    </head>
<body>
<h1>Update data</h1>
<div class="contentProfessional">
<form method="post" action="updateProfDetails">
<input type="hidden" name="id" value="<%=prof.getid()%>">
<%--<input type="text" name="id" value="<%=resultSet.getString("id") %>">--%>
<br>
<label>Name:</label>
<div>
<input type="text" name="name" value="<%=prof.getname() %>" id="field">
</div>
<br>
<label>Username:</label>
<div>
<input type="text" name="username" value="<%=prof.getusername() %>" id="field">
</div>
<br>
<label>Password:</label>
<div>
<input type="text" name="password" value="<%=prof.getpassword() %>" id="field"></div>
<br>
<label>Profession:</label>
<div>
<input type="text" name="profession" value="<%=prof.getprofession() %>" id="field"></div>
<br>
<label>Email Id:</label>
<div>
<input type="email" name="email" value="<%=prof.getemail() %>" id="field"></div>
<br>
<label>Mobile Number:</label>
<div>
<input type="text" name="mob_no" value="<%=prof.getmob_no() %>" id="field"></div>
<br>
<label>Address:</label>
<div>
<input type="text" name="address" value="<%=prof.getaddress() %>" id="field"></div>
<br>
<label>Gender:</label>
<div>
<input type="text" name="gender" value="<%=prof.getgender() %>" id="field"></div>
<br>
<label>Status(free/busy):</label>
<div>
<input type="text" name="status" value="<%=prof.getstatus() %>" id="field"></div>
<br>

<br>
<button type="submit"  id="button">submit</button>
</form>
</div>

</body>
</html>

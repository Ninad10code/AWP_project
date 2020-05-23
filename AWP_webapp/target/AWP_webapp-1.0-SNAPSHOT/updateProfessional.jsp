 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "proserv";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from professionals where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body>
<h1>Update data from database in jsp</h1>
<form method="post" action="updateProfDetails">
<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
<input type="text" name="id" value="<%=resultSet.getString("id") %>">
<br>
Name:<br>
<input type="text" name="name" value="<%=resultSet.getString("name") %>">
<br>
Password:<br>
<input type="text" name="password" value="<%=resultSet.getString("password") %>">
<br>
Profession:<br>
<input type="text" name="profession" value="<%=resultSet.getString("profession") %>">
<br>
Email Id:<br>
<input type="email" name="email" value="<%=resultSet.getString("email") %>">
<br>
Mobile Number:<br>
<input type="text" name="mob_no" value="<%=resultSet.getString("mob_no") %>">
<br>
Address:<br>
<input type="text" name="address" value="<%=resultSet.getString("address") %>">
<br>
Gender:<br>
<input type="text" name="gender" value="<%=resultSet.getString("gender") %>">
<br>
Status(free/busy):<br>
<input type="text" name="status" value="<%=resultSet.getString("status")%>">
<br>

<br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html> 
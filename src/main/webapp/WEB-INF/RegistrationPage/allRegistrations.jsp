<!-- this is the ninth step or ninth file of the project -->
<%@page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="MenuPage.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registrations</title>
</head>
<body>
	<h1>All registrations!!!</h1>
	<table border="1">
	<tr>
	<th>Name</th>
	<th>Course</th>
	<th>email</th>
	<th>mobile</th>
	<th>delete</th>
	<th>update</th>
	</tr>
	<% 
	// this will get the data from controller
		ResultSet result = (ResultSet)request.getAttribute("result");
		while(result.next()){//this loop iterate all the rows of the table 
	%>
	<tr>
	<td><%=result.getString(1)%></td>
	<td><%=result.getString(2)%></td> <!-- these are html tags which are not run inside scriptlet tag thats why they are wrote outside -->
	<td><%=result.getString(3)%></td>
	<td><%=result.getString(4)%></td>
	<td><a href="deleteRegistration?emailId=<%=result.getString(3)%>">delete</td><!-- this will add delete link to each row and this will call the get method of the delete controller because link call direct servelet and automatically or by default calls get method -->
	<!-- this calls delete controller -->
	<td><a href="updateRegistration?emailId=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">update</td><!-- this will add update link to each row and calls the update controller because of this we have to create update controller -->
	                                           <!-- (&)-> this sign is used to add multiple value in url --> 
	</tr>
	
	<%} %><!-- here close while loop -->
	
	</table>
</body>
</html>

<!-- this is the seventh step or seventh file of the project -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<!-- these links are common on all html page except login page using include directive tag of JSP -->
	<a href="SaveRegController">New Registration</a><!-- This link call the the get method of SaveRegController servelet because it calls that servelet directly thats why doGet method automatically call and the request dispatcher of the get method call the create registration page of html -->
	<a href="allReg">All Registrations</a><!-- This link call the controller which call the page which display all the registration data -->
	<!-- here we give logout button and for that we have to create logout controller
	     on clicking logout button it will redirected(take) to login page -->
	<form action="Logout" method="post" >
	<input type="submit" value="LogOut"/>
	
	</form>    
	
</body>
</html>
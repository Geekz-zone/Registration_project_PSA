
<!--  this is the first page or first step of the project -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1> Login here...</h1>
	<form action="verifyLogin" method="post">
		UserName: <input type="text" name="email" />
		Password: <input type="password" name="pass" />
		<input type="submit" value="Login">
	</form>
	<%
		if(request.getAttribute("errorMssg")!=null){
			out.println(request.getAttribute("errorMssg"));
		}
	
	%>
</body>
</html>

<!-- on clicking this login button called the controller layer
     Now after this we develop shortcut links on our html page
 -->
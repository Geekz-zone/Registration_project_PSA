<!-- this is the fifth step or fifth file of the project -->

<!-- Since this file is kept insde the folder name Registration page
     and this folder is created inside WEB-INF so this page is not run
     directly it can only be run when it is called by servelet  -->

<!-- for this view or html page we have to build a seprate contoller for it
     do not mix it in a single controller and also create a another table for it in the database  -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <!--Add the content of MenuPage using include directive tag -->
<%@include file="MenuPage.jsp"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Register Here...</h1>
	<form action="SaveRegController" method="post">
		<pre><h3>
			Name:   <input type="text" name="name"/>
			Course: <input type="text" name="course"/>
			Email:  <input type="text" name="email"/>
			Mobile: <input type="text" name="num"/>
			<input type="submit" value="Save" >
		</h3>></pre>
	
	
	</form>
	<%
		if(request.getAttribute("msg")!= null){
			out.println(request.getAttribute("msg"));
		}
	
	%>

</body>
</html>
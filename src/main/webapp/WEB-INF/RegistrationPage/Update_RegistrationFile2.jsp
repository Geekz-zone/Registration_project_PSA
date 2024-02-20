<!-- this is the twelvth step or twelvth file of the project -->

<!-- Since this file is kept insde the folder name Registration page
     and this folder is created inside WEB-INF so this page is not run
     directly it can only be run when it is called by servelet  -->

  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <!--Add the content of MenuPage using include directive tag -->
<%@include file="MenuPage.jsp"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update..</title>
</head>
<body>
	<h1>Update Register Here...</h1>
	<form action="updateRegistration" method="post"><!-- when we click on the update button then it call the post method of the update controller and below email and mobile data go to the post method -->
		<pre><h3>
			                                          <!-- below value attribute display the the email and mobile number inside the text  -->
			Email:  <input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
			Mobile: <input type="text" name="num"   value="<%=request.getAttribute("mobile")%>"/>
			<input type="submit" value="Update" >
		</h3>></pre>
	
	
	</form>
	

</body>
</html>
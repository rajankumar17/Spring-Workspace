<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body>
 
	<center>
		<h2>Hello World</h2>
		<c:if test="${message!=null}">
		<h3>
			<a href="abc/secure/hello?name=Rajan">Click Here</a>
		</h3>
		</c:if>
		<h2>
			${message} 
		</h2>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<title>WELCOME TO SECURE AREA</title>
</head>
<body>
</br>
Message : ${message}
</br>
Author : ${author}
</br>
<c:url value="/logout" var="logout"/>
<form action="${logout}" method="post">
<input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
<button type="submit" class="btn">Log Out</button>
</form>
</body>
</html>
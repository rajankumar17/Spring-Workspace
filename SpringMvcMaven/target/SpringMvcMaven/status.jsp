<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="x-ua-compatible" content="IE=8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>
	<center>
		<h2>Hello World</h2>
		<h2>
			${message} 
		</h2>
		<table>
			<c:forEach items="${employees}" var="employee">
			
			<tr>
			<td>Employee Id : ${employee.id} </td></tr>
			<tr><td>Employee Name : ${employee.name} </td>
			</c:forEach>
		</table>
	</center>
</body>
</html>
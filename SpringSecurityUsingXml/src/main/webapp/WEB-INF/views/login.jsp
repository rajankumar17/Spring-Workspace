<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Login Page For Security</title>
<style>
.errorblock {
 color: #ff0000;
 background-color: #ffEEEE;
 border: 3px solid #ff0000;
 padding: 8px;
 margin: 16px;
}
</style>
</head>
<body onload='document.f.j_username.focus();'>
 <h3>Login with Username and Password (Custom Login Page with custom error message)</h3>

 <c:if test="${not empty error}">
  <div class="errorblock">
   Your login attempt was not successful, try again.<br /> Caused :
   ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
  </div>
  </c:if>
<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">
	<c:if test="${error}">
		<p>
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${logout}">
		<p>
			You have been logged out.
		</p>
	</c:if>
	<p>
		<label for="username">Username</label>
		<input type="text" id="username" name="username"/>
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>
	</p>
	<p>
        <input name="reset" type="reset" />
    </p>
	<input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">Log in</button>
</form>
</html>
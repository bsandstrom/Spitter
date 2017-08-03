<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spittles</title>
</head>
<body>
	<h1>Your profile</h1>
	<c:out value="${spitter.username}" /> <br/>
	<c:out value="${spitter.firstName}" /> <br/>
	<c:out value="${spitter.lastName}" /> <br/>
	
	<p>Got a spittle on the tip of your tongue? Share your spittle with the world</p>
	<form method="POST" action="<c:url value="/spitter/${spitter.username}/spit" />">
		<textarea name="message"></textarea><br/>
		<input type="submit" value="Spit"/>
	</form>
</body>
</html>
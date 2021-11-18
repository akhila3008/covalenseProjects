<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departments</title>
</head>
<body>
	<h2>New Department </h2>
	<form:form action="newDept" method="post" modelAttribute="department">
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>
</body>
</html>
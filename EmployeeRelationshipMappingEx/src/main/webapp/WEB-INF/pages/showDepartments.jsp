
<%@page import="java.util.List"%>
<%@page import="com.cov.beans.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Departments List</title>
</head>
<body>
	<h2>departments</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		List<Department> depts = (List<Department>) request.getAttribute("depts");
		for (Department dept : depts) {
		%>
		<tr>
			<td><%=dept.getId()%></td>
			<td><%=dept.getName()%></td>
			
			<td><a href="editDept?id=<%=dept.getId()%>">Edit</a></td>
			<td><a href="deleteDept?id=<%=dept.getId()%>">Delete</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<a href="/">Home</a>
	<br>
	<br>
	
	<br>
	<br>
</body>
</html>

<%@page import="com.cov.service.DepartmentService"%>
<%@page import="com.cov.beans.Department"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editEmp</title>
</head>
<body>
	<h1>Edit Employee</h1>
	<form:form action="updateEmp" modelAttribute="empToEdit">
		<table>
			<tr>
				<form:label path="id">ID</form:label>
				<form:input path="id" readonly="true" />
				<br>
				<br>
				<form:label path="name">NAME</form:label>
				<form:input path="name" />
				<br>
				<br>
				<br>
				
				
				<form:label path="department">Choose a Department</form:label>
		<form:select path="department">
			<form:option value="0">--Select--</form:option>
			<%
			DepartmentService departmentService = (DepartmentService) request.getAttribute("departmentService");
			List<Department> departments = departmentService.findAll();
			for (Department department : departments) {
			%>
			<form:option value="<%= department %>"><%=department.getName()%></form:option>
			<%
			}
			%>
		</form:select>
				<br>
				<br>
				<input type="submit" value="Update" />
			</tr>
		</table>
	</form:form>
</body>
</html>
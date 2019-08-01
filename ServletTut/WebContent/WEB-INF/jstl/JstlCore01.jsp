<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Departments and Employees</h2>

<c:forEach items="${departments}" var="dept">
	<h3>${dept.deptName}</h3>
	<ul>
	<c:forEach items="${dept.employees}" var="emp"><li>${emp.empName} - ${emp.job}</li></c:forEach>
	</ul>
</c:forEach>

</body>
</html>
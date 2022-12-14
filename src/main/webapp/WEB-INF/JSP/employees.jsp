<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<h3>Add / Edit Employee!!!</h3>

	<form:form method="post" action="/SpringMVCTutorial/employee.html" commandName="employee">
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 300px">
			<tr>
				<td>Id :</td>
				<td><form:input type="text" path="id" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="name" /></td>
			</tr>
			<tr>
				<td>Birthdate :</td>
				<td><form:input type="text" path="birthdate" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:input type="text" path="gender" /></td>
			</tr>
			<tr>
				<td>Hobbies :</td>
				<td><form:input type="text" path="hobbies" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input type="text" path="address" /></td>
			</tr>
			<tr>
				<td>Pan :</td>
				<td><form:input type="text" path="pan" /></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
			</tr>
		</table>
		</div>
	</form:form>
	<br>
	<br>
	<h3>List of Employees</h3>
	<table class="table table-bordered" style="width: 300px">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Birthdate</th>
			<th>Gender</th>
			<th>Hobbies</th>
			<th>Address</th>
			<th>Pan</th>
			<th>Edit/Delete</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">

			<tr>
				<td width="60" align="center">${employee.id}</td>
				<td width="60" align="center">${employee.name}</td>
				<td width="60" align="center">${employee.birthdate}</td>
				<td width="60" align="center">${employee.gender}</td>
				<td width="60" align="center">${employee.hobbies}</td>
				<td width="60" align="center">${employee.address}</td>
				<td width="60" align="center">${employee.pan}</td>
				<td width="60" align="center"><a href="edit/${employee.id}">Edit</a>/<a href="delete/${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
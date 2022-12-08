<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee management System</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: powderblue;width:1520px">
			<div>
			<b><a class="navbar-brand" >Employee Management web</a></b>	
			</div>
		</nav>
	</header>
	<br>
<div class="row">
	<div class="container">
		<h2 style="color:white;"><div class="text-center" style="background-color:black;">List of Users</div></h2>
		
		<hr>
		
		<div class="container text-left">
			<button type="submit" class="btn btn-success"> <a href="adduser.jsp" style="color:white">Add New User</a>   </button>
		<br>
		<table class="table table-bordered" >
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${user}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.country}" /></td>
					<td><a href="FetchUser?id=<c:out value='${user.id}' />">Update</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="DeleteUser?id=<c:out value='${user.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>
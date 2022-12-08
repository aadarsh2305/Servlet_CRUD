
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script>
	function validateForm() {
		if (document.abcd.name.value == "") {
			alert("User Name Can not be empty");
			document.abcd.name.focus();
			return false;
		} else if (document.abcd.password.value == "") {
			alert("Password Can not be empty");
			document.abcd.password.focus();
			return false;
		} else if (document.abcd.email.value == "") {
			alert("Mail ID Can not be empty");
			document.abcd.email.focus();
			return false;
		} else if (document.abcd.country.value == "") {
			alert("You have to select atleast one country");
			document.abcd.country.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
			<b>	<a href="https://www.javaguides.net" class="navbar-brand">
					Update Employee Detail </a></b>
			</div>


		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form name=abcd action="UpdateUser" method="get" onSubmit="return validateForm()">
				</c:if>



				<h2>
					<c:if test="${user == null}">
                                    Edit User
                                </c:if>
				</h2>


				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name">
				</fieldset>

				<fieldset class="form-group">
					<label>User Password</label> <input type="password"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>User Country</label> <input type="text"
						value="<c:out value='${user.country}' />" class="form-control"
						name="country">
						
				</fieldset>

				<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
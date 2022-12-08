<%@page import="usermanagement.bean.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script>
	function validateForm() {
		if (document.form.userName.value == "") {
			alert("User Name Can not be empty");
			document.form.userName.focus();
			return false;
		} else if (document.form.userPass.value == "") {
			alert("Password Can not be empty");
			document.form.userPass.focus();
			return false;
		} else if (document.form.userEmail.value == "") {
			alert("Mail ID Can not be empty");
			document.form.userEmail.focus();
			return false;
		} else if (document.form.userCountry.value == "") {
			alert("You have to select atleast one country");
			document.form.userCountry.focus();
			return false;
		}
	}
	function confirmPassword(){
		var a=document.getElementById("userPass");
		var b=document.getElementById("confirmPass");
		if(a.equals(b)){
			alert("Password and Confirm password must be same !!!!");
			document.form.confirmPass.focus();
			return false;
		}else{
			return true;
		}
	}
	
	
</script>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato; width: 1499px">
			<div>
				<b><a style="color: white" class="navbar-brand">Add New Employee</a></b>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">


				<form name="form" action="InsertUser" method="post"
					onSubmit="return alidateForm()">

					<b><label>Name</label></b> <input type="text" name="userName" /><br />
					<br /> <b>
					<label>Password</label> </b><input type="password"
						name="userPass" 
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
						/><br /> <br /> <b> 
						
						<b><label>Confirm <br/>Password</label> </b><input type="password"
						name="confirmPass" 
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
						 onSubmit="confirmPassword()" /><br /> <br /> <b> 
						
						<label>Email Id</label>
					</b> <input type="email" name="userEmail"  onSubmit="alidateMail()" /><br />

					<br /> <b><label>Country</label> </b><select name="userCountry">
						<option>India</option>
						<option>China</option>
						<option>USA</option>
						<option>other</option>
					</select> <br /> <br /> <input type="submit" value="Register" />

				</form>
			</div>
		</div>
	</div>
</body>
</html>
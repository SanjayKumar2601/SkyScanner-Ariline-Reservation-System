<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Admin - Log in</title>
  <link rel="icon" type="image/x-icon" href="logo.png">
  <link rel="stylesheet" href="style_sign.css">

  <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
	
</head>

<body>

	<div id="navigation"></div>

<div class="container" id="container">
	
	<div class="form-container sign-in-container">
		<form action="/adminlogin" method="post">
			<h1>Sign in[Admin]</h1>
			<input type="email" placeholder="Email" name="email" id="email"/>
			<input type="password" placeholder="Password" name="password" id="password"/><br>
			<button type="submit">Sign In</button>
			<p><c:out value='${validationStatus}'/></p>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal details</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Hi There!</h1>
				<p>Enter admin details to login</p>
				<button onclick="history.back()">Back</button>
				<a href="Home.jsp">Click here to return to Home page</a>
				<a href="Signup.jsp">User? Sign in </a>
			</div>
		</div>
	</div>
</div>
</div>




<div id="footer"></div>
</body>
<script src="script_sign.js" charset="utf-8"></script>
</html>

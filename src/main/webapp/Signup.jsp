<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Login/Sign Up</title>
  <link rel="icon" type="image/x-icon" href="logo.png">
  <link rel="stylesheet" href="style_sign.css">
 
  
  <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
	
</head>

<body>

	<button onclick="history.back()">Back</button>
	<a href="admin_login.jsp">Admin? Sign in </a>

<div class="container" id="container">
	<div class="form-container sign-up-container">
	
		<form action="/usersignup" method="POST">
			<h1>Create Account</h1>
			<input type="text" placeholder="Name" name="name" id="name"/>
			<input type="email" placeholder="Email" name="email" id="email" />
			<input type="password" placeholder="Password" name="password" id="password"/>
			<button type="submit" onclick="validation()">Sign Up</button>
			
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="/userlogin" method="POST">
			<h1>Sign in</h1>
			<input type="email" placeholder="Email" name="email" id="email"/>
			<input type="password" placeholder="Password" name="password" id="password"/>
			<label for="keep">
			<input type="checkbox" name="keep_me" id="keep" value="Keep me signed in">
			Keep me signed in</label>
			<a href="#">Forgot your password?</a>
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
				<p>Enter your personal details to open an account with us</p>
				<button class="ghost" id="signUp">Sign Up</button>
			</div>
		</div>
	</div>
</div>



<script>
 function validation(){
	 alert("Sign Up successful.Now you can login by clicking on Sign in");
 }
	
</script>
<script src="script_sign.js" charset="utf-8"></script>
</body>

</html>

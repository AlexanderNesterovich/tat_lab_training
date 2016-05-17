<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
        ${loginError}
		<form action="login" method="post">
		<div>
		<label>Username</label>
		<input type="text" id="userId" name="userId" placeholder="user name"/>
		</div>
		<div>
        		<label>Password</label>
        		<input type="password" id="password" name="password" placeholder="password"/>
        </div>
			<button id="loginButton"/>Login</button>
		</form>
	</body>
</html>
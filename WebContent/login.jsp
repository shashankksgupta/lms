<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<script src="/LMS/js/ajax.js"></script>

</head>
<body>
<form action="LoginLogic" method="GET">
<table>
	<tr>
		<td colspan=2>
			Atidan Leave Management System
		</td>
	</tr>
	<tr>
		<td>
			Username:
		</td>
		<td>
			<input type="text" id="username" name="username"/>
		</td>
	</tr>
	<tr>
		<td>
			Password:
		</td>
		<td>
			<input type="text" id="password" name="password"/>
		</td>
	</tr>
	<tr>
		<td colspan=2 align="center">
			<input type="submit" value="Log-In" name="btnLogin" value="btnLogin">
		</td>
	</tr>
	
</table>
</form>
</body>
</html>
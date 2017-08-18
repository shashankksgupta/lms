<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	
<script src="/LMS/js/Application.js"></script>

	<title>Insert title here</title>
</head>
<body class="container-fluid">
	<form name="departform" method="POST" action="DepController">
		<div class="row well padding" >
			<div class="col-lg-4 col-lg-offset-5">
				<p>
				<h1>Department Form</h1>
				</p>
			</div>	
			</div>
				<div class="row" style="padding-top:100px">
					<div class="well col-lg-4 col-lg-offset-4" >
						<label for="departname" class="size"><h3>Department Name</h3></label><input
							type="text" class="form-control" id="dname"
							name="dname" value='<c:out value="${deptlist.dname}"></c:out>'>
							<p></p>
					</div>
				</div>
				
		
			<div class="text-center">
			<input type="Submit" value="ADD" id="apply">
		</div>
		</form>
</body>
</html>
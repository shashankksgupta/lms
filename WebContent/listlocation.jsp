<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Insert title here</title>
<!-- jQuery -->
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/additional-methods.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- customcss -->
<link rel="stylesheet" href="css/inline.css">
<link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="/LMS/css/jquery-ui.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-inverse"> <!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Atidan Leave Management System</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Employee Management <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="Registration.jsp">Add new Employee</a></li>
						<li><a href="empindex.jsp">List all Employees</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Leave Management<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="LeaveMaster.jsp">My leaves</a></li>
						<li><a href="leavesredirect.jsp">List Leaves</a></li>
						<li><a href="#">View past leaves</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Location Management<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="AddLocation.jsp">Add Location</a></li>
						<li><a href="locindex.jsp">View/Edit Locations</a></li>
					</ul></li>
				<li><a href="#">Log-out</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Roles Management<span class="caret"></span></a>
						<ul class="dropdown-menu">

							<li><a href="rolesRedirect.jsp">View/Edit Roles</a></li>
						</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse --> <!-- /.container-fluid --> </nav>
		<div class="row">
		<div class="well col-xs-10 col-xs-offset-1">
			
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Location Id</th>
							<th>Location Name</th>
							<th>Location Address</th>
							<th colspan=2>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${loc}" var="loc">
							<tr>
								<td><c:out value="${loc.locationid}" /></td>
								<td><c:out value="${loc.location}" /></td>
								<td><c:out value="${loc.locationAddress}" /></td>
								<td><a
									href="LocationLogic?action=edit&locationid=<c:out value="${loc.locationid}"/>">Update</a></td>
								<td><a
									href="LocationLogic?action=delete&locationid=<c:out value="${loc.locationid}"/>">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
			<p>
				<!-- 		<a href="LocationLogic?action=insert">Add Location</a> -->
			</p>
		</div>
		</div>
	</div>
</body>
</html>
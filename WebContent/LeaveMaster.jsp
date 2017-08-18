<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">

<!-- customcss -->
<link rel="stylesheet" href="css/inline.css">
<link rel="stylesheet" href="css/registration.css">
<link rel="stylesheet" href="/LMS/css/jquery-ui.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- customjs -->
<!-- <script src="/LMS/js/validation.js"></script> -->
<script src="/LMS/js/jquery-ui.js"></script>
<script src="/LMS/js/jqui.js"></script>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<script src="/LMS/js/bal.js"></script>
<script src="/LMS/js/ajax.js"></script>

<style>
</style>
</head>
<body class="bodybg">
	<form method="POST" id="regform" name="regform">
		<div class="contianer-fluid">
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
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Roles Management<span class="caret"></span></a>
						<ul class="dropdown-menu">

							<li><a href="rolesRedirect.jsp">View/Edit Roles</a></li>
						</ul></li>
				<li><a href="#">Log-out</a></li>
			</ul>
		</div>
			<!-- /.navbar-collapse --> <!-- /.container-fluid --> </nav>
			<!-- 		<div class="row"> -->
			<!-- 			<div class="col-sm-12 text-center"> -->
			<!-- 				<label class="whitetext">Leave Master</label> -->
			<!-- 			</div> -->

			<!-- 		</div> -->
			<div class="col-xs-8 col-xs-offset-2">
				<div class=" well table-responsive 	">
					<table class="table table-striped table-bordered">
						<tr>
							<td colspan=4 align="center">Your Leaves</td>
						</tr>
						<tr>
							<td>Types of leaves</td>
							<td align="center">Granted</td>
							<td align="center">Consumed</td>
							<td align="center">Balance</td>
						</tr>
						<tr>
							<td>Annual Leave</td>
							<td><input type="text" class="form-control"
								id="annualalloted" name="annualalloted"
								value='<c:out value="${lmbs.annualalloted}"  ></c:out>'  disabled /></td>
							<td><input type="text" class="form-control"
								id="annualconsumed" name="annualconsumed"
								value='<c:out value="${lmbs.annualconsumed}"></c:out>'  disabled/></td>
							<td><input type="text" class="form-control"
								id="annualbalance" name="annualbalance" disabled ></td>

						</tr>
						<tr>
							<td>Sick Leave</td>
							<td><input type="text" class="form-control"
								id="sickalloted" name="sickalloted"
								value='<c:out value="${lmbs.sickalloted}"  ></c:out>' disabled/></td>
							<td><input type="text" class="form-control"
								id="sickconsumed" name="sickconsumed"
								value='<c:out value="${lmbs.sickconsumed}"  ></c:out>' disabled/></td>
							<td><input type="text" class="form-control" id="sickbalance"
								name="sickbalance" disabled ></td>
						</tr>
						<tr>
							<td>Work From Home</td>
							<td><input type="text" class="form-control" id="wfhalloted"
								name="wfhalloted" value='<c:out value="${lmbs.wfhalloted}"></c:out>' disabled ></td>
							<td><input type="text" class="form-control" id="wfhconsumed"
								name="wfhconsumed" value='<c:out value="${lmbs.wfhconsumed}"></c:out>' disabled></td>
							<td><input type="text" class="form-control" id="wfhbalance"
								name="wfhbalance" disabled/></td>
						</tr>
						<tr>
							<td colspan=4><input type="button"
								name="btnLeavesMasterSubmit" id="btnLeavesMasterSubmit"
								value="Submit" class="btn btn-submit btn-block" disabled></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
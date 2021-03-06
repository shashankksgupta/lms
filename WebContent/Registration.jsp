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

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- customjs -->

<script src="/LMS/js/jquery-ui.js"></script>
<script src="/LMS/js/jqui.js"></script>
<script src="/LMS/js/ajax.js"></script>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<script src="/LMS/js/validation.js"></script>
<style>
</style>
</head>
<body class="bodybg">
	<form id="regform" name="regform" method="POST" action="Logic">
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

			<div class="row">
				<div class="col-sm-12 text-center">
					<label class="whitetext">Personal Details</label>
				</div>
				<div class="row">
					<div class=" well col-sm-10 col-sm-offset-1">
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<label for="fname">First Name</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-user"></i> <input type="text"
											class="form-control" placeholder="First Name" id="fname"
											name="fname" value='<c:out value="${embs.fname}"></c:out>' />
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label for="mname">Middle Name</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-user"></i> <input type="text"
											class="form-control" placeholder="Middle Name" id="mname"
											name="mname" value='<c:out value="${embs.mname}"></c:out>' />
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label for="lname">Last Name</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-user"></i> <input type="text"
											class="form-control" placeholder="Last Name" id="lname"
											name="lname" value='<c:out value="${embs.lname}"></c:out>' />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="address">Address</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-list"></i> <input type="text"
											id="address" name="address" class="form-control"
											placeholder="Address"
											value='<c:out value="${embs.address}"></c:out>'>

									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="email">Email</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-envelope"></i> <input
											type="text" class="form-control" placeholder="Email"
											id="email" name="email"
											value='<c:out value="${embs.email}"></c:out>' />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<label for="mobile1">Mobile Number 1</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-phone"></i> <input type="text"
											class="form-control" placeholder="Mobile number 1"
											id="mobile1" name="mobile1"
											value='<c:out value="${embs.mobile1}"></c:out>' />
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label for="mobile2">Mobile Number 2</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-phone"></i> <input type="text"
											class="form-control" placeholder="Mobile number 2"
											id="mobile2" name="mobile2"
											value='<c:out value="${embs.mobile2}"></c:out>' />
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label for="enumber">Emergency Mobile Number</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-phone"></i> <input type="text"
											class="form-control" placeholder="Emergency mobile Number"
											id="enumber" name="enumber"
											value='<c:out value="${embs.enumber}"></c:out>' />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 text-center">
					<label class="whitetext">Company Details</label>
				</div>
				<div class="row">
					<div class=" well col-sm-10 col-sm-offset-1">
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<label for="username">Username</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-user"></i> <input type="text"
											class="form-control" placeholder="Username" id="username"
											name="username"
											value='<c:out value="${embs.username}"></c:out>' />
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label for="password">Password</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-lock"></i> <input type="text"
											class="form-control" placeholder="Password" id="password"
											name="password"
											value='<c:out value="${embs.password}"></c:out>' />
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label for="designation">Designation</label> <select
										class="form-control" id="designation" name="designation">
										<option value="${embs.designation}">${embs.designation} </option>
										<option value="0">--SELECT--</option>
										<option value="Trainee Software Developer">Trainee Software Developer</option>
										<option value="Technical Lead">Technical Lead</option>
										<option value="Project Manager">Project Manager</option>
										<option value="HR Executive">HR Executive</option>
									</select>
								</div>

							</div>
						</div>

						<div class=row>
							<div class="col-sm-3">
								<div class="form-group">
									<label for="department">Department</label> <select
										class="form-control" id="department" name="department">
										<option value="${embs.departid}">${embs.department} </option>
										<option value="0">--SELECT--</option>
										<option value="2">Software Development</option>
										<option value="4">IT</option>
										<option value="3">HR</option>
										<option value="5">Customer Support</option>
									</select>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="form-group">
									<label for="location">Location</label> <select
										class="form-control" id="location" name="location">
										<option value="${embs.locationid}">${embs.location} </option>
										<option value="0">--SELECT--</option>
										<option value="1">Mumbai</option>
										<option value="2">Pune</option>
										<option value="3">USA</option>
										<option value="4">Bangalore</option>


									</select>
								</div>

							</div>

							<div class="col-sm-3">
								<br> <input type="submit" id="btnSubmit" name="btnSubmit"
									class="btn btn-success btn-block" value="Sign-up">

							</div>

						</div>
					</div>


				</div>

			</div>
		</div>

	</form>
</body>
</html>
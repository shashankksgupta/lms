<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<!-- customjs -->
<!-- <script src="/LMS/js/validation.js"></script> -->
<script src="/LMS/js/ajax.js"></script>
<title>Insert title here</title>
</head>
<body class="bodybg">
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
						<li><a href="#">List all Employees</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Leave Management<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">My leaves</a></li>
						<li><a href="#">Apply for leaves</a></li>
						<li><a href="#">View past leaves</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Location Management<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Add Location</a></li>
						<li><a href="#">View/Edit Locations</a></li>
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
		
		<form method="POST" id="regform" name="regform">
<!-- <form id="locform" name="locform" action="processing.LocationLogic" method="POST"> -->

			<div class="row">
				<div class="col-sm-12 text-center">
					<label class="whitetext">Add Leave Type</label>
				</div>
				<div class="row">
					<div class=" well col-sm-10 col-sm-offset-1">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="leavetype">Leave Type</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-chevron-right"></i> <input
											type="text" class="form-control" placeholder="Leave Type"
											id="leavetype" name="leavetype" />
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="allocateddays">Allocated Days</label>
									<div class="inner-addon left-addon">
										<i class="glyphicon glyphicon-calendar"></i> <input type="text"
											class="form-control" placeholder="Allocated Days"
											id="allocateddays" name="allocateddays" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<input type="button" name="btnSubmitleave"
								class="btn btn-success btn-block" value="Add Location"
								id="btnSubmitleave">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
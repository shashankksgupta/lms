<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet" href="css/application.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/LMS/js/Applicationvalidation.js"></script>
<!-- <script src="/LMS/js/Date.js"></script> -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validation-unobtrusive/3.2.6/jquery.validate.unobtrusive.js">
	
</script>
<script src="/LMS/js/ajax.js"></script>
<script src="/LMS/js/onload.js"></script>
<link rel="stylesheet" href="css/registration.css">
<style>
.error{
	color:red;
}
</style>



</head>

<title>Insert title here</title>
<body class="bodybg">
	<form name="applicationform" id="applicationform"
		action="AppController" method="POST">
		<div class="container-fluid ">

			<div class="row">
				<div class="col-lg-4 col-lg-offset-2">
					<p>
					<h1 class="whitetext">Application Form</h1>
					</p>

				</div>
			</div>




			<div class="row ">
				<div class="well col-lg-9 col-lg-offset-2">

					<div class="row well">
						<div>
							<h5>Employee Details</h5>
						</div>
					</div>
					<div class="row">
						<div class="form-inline col-lg-6">
							<label for="eid" class="size">Emloyee Id</label><input
								type="text" class="form-control" id="eid" name="eid"
								value="${session.empid}" readonly>
						</div>
						<div class="form-inline col-lg-6">
							<label for="dept" class="size">Department</label><input
								type="text" class="form-control" id="dept" name="dept"
								value="${session.department}" readonly>
						</div>
					</div>
					<p></p>
					<div class="row">
						<div class="form-inline col-lg-6">
							<label for="fname" class="size">Emloyee Name</label><input
								type="text" disabled class="fname form-control" id="fname" name="fname"
								value="${session.fname} ${session.lname}">
						</div>
						<div class="form-inline col-lg-6 ">
							<label for="designation" class="size">Designation</label><input
								type="text" class="form-control" id="designation"
								name="designation" value="${session.designation}" readonly>
						</div>
					</div>
					<p></p>

					<div class="row well">
						<div>
							<h5>Leave Details</h5>
						</div>
					</div>
					<div class="row">
						<div class="form-inline col-lg-6">
							<label for="type" class="size">Type of leave<sup
								class="redcolor">*</sup></label> <span> <select name="type"
								class="drop-down form-control" id="type">
									<option value="0">--Select--</option>
									<option value="10">Sick-Leave</option>
									<option value="11">Annual Leave</option>
									<option value="12">Comp-off</option>
									<!--  <option value="4">Marriage-leave</option>
									<option value="5">Paternity-Leave</option>-->
							</select>
							</span>
						</div>

						<div class="form-inline col-lg-6">
							<label for="balance" class="size">Current balance</label> <input
								type="hidden" class="form-control" id="balance" name="balance">
						</div>
					</div>
					<p></p>
					<div class="row">
						<div class="form-inline col-lg-6">
							<label for="startdate" class="size">Start Date<sup
								class="redcolor">*</sup></label> <input type="text"
								class="form-control datepicker " id="DateFrom" name="startdate"
								value='<c:out value="${app.startdate}"></c:out>'> <span><a
								href="" name="datepicker"
								class="glyphicon glyphicon-calendar datepicker"></a></span>
						</div>
						<div class="form-inline col-lg-6">
							<label for="enddate" class="size">End Date<sup
								class="redcolor">*</sup></label> <input type="text" id="DateTo"
								class="form-control datepicker" name="enddate"
								value='<c:out value="${app.enddate}"></c:out>'> <span><a
								href="" name="datepicker"
								class="glyphicon glyphicon-calendar datepicker"></a></span>
						</div>

					</div>
					<p></p>
					<div class="row">
						<div class="form-inline col-lg-6">
							<label for="workingdays" class="size">Working days</label> <input
								type="text" class="form-control" id="nights" name="workingdays"
								value="" readonly="readonly">

						</div>


					</div>
					<p></p>
					<div class="row">
						<div class="form-inline col-lg-6">
							<label for="comment" class="size">Reason/Comment<sup
								class="redcolor">*</sup></label>
							<textarea class="form-control" style="width: 200px" id="comment"
								name="comment" value='<c:out value="${app.comment}"></c:out>'>
                            </textarea>
						</div>

						<div class="form-inline col-lg-6">
							<label for="enumber" class="size">Contact Number while
								Away</label> <input type="text" class="form-control" id="enumber"
								name="enumber">
						</div>
					</div>

					<p></p>

					<div class="row well">
						<div>
							<h5>Approver Details</h5>
						</div>
					</div>
					<div class="row">
						<div class="form-inline col-lg-6">
							<label for="approver1" class="size">Approver 1<sup
								class="redcolor">*</sup></label> <span> <select name="approver1"
								class="drop-down form-control">
									<c:forEach items="${appr}" var="appr">
										<option value="${appr.approverid}">${appr.aname}</option>
									</c:forEach>
									<option value="0">--Select--</option>
							</select>
							</span>
						</div>



						<div class="form-inline col-lg-6">
							<label for="approver2" class="size">Approver 2</label> <span>
								<select name="approver2" class="drop-down form-control">
									<c:forEach items="${appr}" var="appr">
										<option value="${appr.approverid}">${appr.aname}</option>
									</c:forEach>
									<option value="0">--Select--</option>
							</select>
							</span>

						</div>




					</div>
					<p></p>
					<div class="row">
						<div class="form-inline col-lg-6">
							<label for="reason" class="size">CC</label>
							<textarea class="form-control" id="fname" name="reason"></textarea>

						</div>
					</div>
					<div class="col-lg-offset-4">
						<a href="" class="glyphicon glyphicon-user"></a> <span><a
							href="" class="glyphicon glyphicon-list-alt"></a></span>
					</div>
				</div>


			</div>
		</div>

		<div class="row text-center">
			<input type="Submit" value="Apply" id="apply"> <span><input
				type="button" value="Reset"></span> <span><input
				type="button" value="Cancel"></span>
		</div>

	</form>
<body>






</body>
</html>
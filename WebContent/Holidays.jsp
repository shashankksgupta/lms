<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.4/build/jquery.datetimepicker.full.js"></script>

<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">



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
	
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/LMS/js/Applicationvalidation.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container-fluid">
	<form name="holidaysform" method="POST" action="HolidaysController">
		<div class="row well padding">
			<div class="col-lg-4 col-lg-offset-5">
				<p>
				<h1>Holidays Form</h1>
				</p>
			</div>
		</div>
		<div class="row" style="padding-top: 100px">
			<div class="well col-lg-8 col-lg-offset-2">

				<div class="row">
					<div class="well col-lg-6">
						<label for="holidayname" class="size"><h3>Holiday Name</h3></label>
						<input type="text" class="form-control" id="hname" name="hname" value='<c:out value="${holidays.hname}"></c:out>'>
						
						 <label for="date" class="size"><h3>Date</h3><span><a href="" 
								class="glyphicon glyphicon-calendar"></a></span></label>
						 <input type="text" class="form-control datepicker" id="hdate" name="hdate" value='<c:out value="${holidays.hdate}"></c:out>'>
						 <p></p>
					</div>
				</div>

			</div>
		</div>

		<div class="row">
			<div class="col-lg-offset-2">
			<input type="Submit" value="ADD" id="apply" style="width:150px">
		</div>
		</div>
	</form>

</body>



</html>
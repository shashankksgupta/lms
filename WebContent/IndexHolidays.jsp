<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.2.1.js"></script>

<!-- jTable Metro styles. -->
<link href="/LMS/css/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="/LMS/css/jtable_metro_base.css" rel="stylesheet" type="text/css" />
<!-- jTable script file. -->
<script src="/LMS/js/jquery-ui.js" type="text/javascript"></script>
<script src="/LMS/js/jquery.jtable.js" type="text/javascript"></script>
<!-- User Defined Jtable js file -->
<!-- <script src="js/ApplicationAjax.js" type="text/javascript"></script> -->
<title></title>
</head>
<body>
<form>
<jsp:forward page="/HolidaysController?action=list"/>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/application.css">
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


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Approver Form</title>
</head>
<body>
<%-- 	<sql:setDataSource var="ds" driver="org.postgresql.Driver" --%>
<%-- 		url="jdbc:postgresql://localhost:5432/LMS" user="postgres" --%>
<%-- 		password="Atid@n@123" /> --%>
<%-- 	<sql:query dataSource="${ds}" var="result"> //ref  defined 'ds' --%>
<!--     SELECT eid,fname from lms.employeemaster; -->
<%-- </sql:query> --%>
<%! String driverName = "org.postgresql.Driver";%>
<%!String url = "jdbc:postgresql://localhost:5432/LMS";%>
<%!String user = "postgres";%>
<%!String psw = "Atidan@123";%>
<form name="approverform" id="approverform" action="ApproverController"
		method="POST">
<%
Connection con = null;
PreparedStatement ps = null;
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql = "SELECT * FROM lms.employeemaster order by empid";
ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery(); 
%>

		<div class="container">
			<div class="row well" style="padding-top: 50px">
				<div class="col-lg-4 col-lg-offset-4 text-center">
					<h2>APPROVER FORM</h2>
				</div>
			</div>

			<div class="row" style="padding-top: 100px">
				<div class="well col-lg-6 col-lg-offset-3">

					<div class="row">
						<div class="form-inline">
							<label for="employeename" class="size"><h4>Employee
									Name</h4></label>

							<select name="fname" class="drop-down " id="fname">
												
								<%
									while (rs.next()) {
										String eid = rs.getString("empid");
										String fname = rs.getString("fname");
								%>
								<option value="<%=eid%>"><%=fname%></option>
								<%
									}
								%>
							</select>

							<%-- 									<c:forEach items="${emp}" var="emp">	 --%>
							<%-- 									<option value="${emp.eid}">${emp.fname}</option> --%>
							<%-- 									</c:forEach> --%>
							
						</div>
					</div>
					<p></p>

					<div class="row">
						<div class="form-inline">
							<label for="approvername" class="size"><h4>Approver
									Name</h4></label> 
									<select name="aname" class="drop-down " id="aname">
									
									
									<%
									sql = "SELECT * FROM lms.employeemaster order by empid";
									ps = con.prepareStatement(sql);
									 rs = ps.executeQuery(); 
									while (rs.next()) {
										String eid = rs.getString("empid");
										String fname = rs.getString("fname");
								%>
								<option value="<%=eid%>"><%=fname%></option>
								<%
									}
								%>
									
<%-- 								<c:forEach items="${emp}" var="emp"> --%>
<%-- 									<option value="${ emp.eid}">${emp.fname}</option> --%>
<%-- 								</c:forEach> --%>

							</select>
						</div>
					</div>
				</div>
			</div>

<%
}
catch(SQLException sqe)
{ 
out.println(sqe);
}
%>

			<div class="text-center">
				<input type="Submit" value="ADD" id="apply">
			</div>

		</div>
</form>
</body>
</html>
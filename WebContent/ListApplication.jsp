<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Leave Management System </title>
</head>
<body>
    <center>
        <h1>Application List</h1>
        <h2>
            <a href="Application.jsp">Add New Application</a>
            &nbsp;&nbsp;&nbsp;
            <a href="IndexApplication.jsp">List All Applications</a>
             
        </h2>
    </center>
    <div align="center table">
        <table border="1" cellpadding="5" class="table table-bordered table-striped">
            <caption><h2>List of Applications</h2></caption>
            <tr>
                <th>APPID</th>
                <th>NAME</th>
                <th>STARTDATE</th>
                <th>ENDDATE</th>
                <th>Type</th>
                <th>NUMBER OF DAYS</th>
                <th>APPROVER 1</th>
                <th>APPROVER 2</th>
                <th>STATUS</th>
                <th>COMMENT</th>
                <th>APPLIED DATE</th>
                 <th>ACTION</th>
                
            </tr>
            <c:forEach var="app" items="${applist}">
                <tr>
                    <td><c:out value="${app.appid}" /></td>
                    <td><c:out value="${app.ename}" /></td>
                    <td><c:out value="${app.startdate}" /></td>
                    <td><c:out value="${app.enddate}" /></td>
                    <td><c:out value="${app.typeofleave}" /></td>
                    <td><c:out value="${app.applicabledays}" /></td>
                    <td><c:out value="${app.approver1name}" /></td>
                    <td><c:out value="${app.approver2name}" /></td>
                    <td><c:out value="${app.status}" /></td>
                    <td><c:out value="${app.comment}" /></td>
                    <td><c:out value="${app.applieddate}" /></td>
          
                    <td>
                        <a href="AppController?action=edit&appid=<c:out value='${app.appid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="AppController?action=delete&appid=<c:out value='${app.appid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>

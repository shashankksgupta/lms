<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

 <center>
        <h1>Department List</h1>
        <h2>
            <a href="Department.jsp">Add New Department</a>
            &nbsp;&nbsp;&nbsp;
            <a href="IndexDepartment.jsp">List All Departments</a>    
        </h2>
 </center>
 
 <div align="center" class="table">
        <table border="1" cellpadding="5" class="table table-bordred table-striped">
            <caption><h2>List of Departments</h2></caption>
            <tr>
                <th>DEPTID</th>
                <th>DEPTNAME</th>
                 <th>ACTION</th>
			</tr>
			 <c:forEach var="dept" items="${deptlist}">
                <tr>
                    <td><c:out value="${dept.did}" /></td>
                    <td><c:out value="${dept.dname}" /></td>
                    <td>    
                        <a href="DepController?action=edit&did=<c:out value='${dept.did}' />" class="btn btn-primary">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
<%--                         <a href="DepController?action=delete&did=<c:out value='${dept.did}' />" class="btn btn-primary">Delete</a>                      --%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
			
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
 
 <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Departments</h2></caption>
            <tr>
                <th>DEPTID</th>
                <th>DEPTNAME</th>
			</tr>
			 <c:forEach var="dept" items="${deptlist}">
                <tr>
                    <td><c:out value="${dept.did}" /></td>
                    <td><c:out value="${dept.dname}" /></td>
                    <td>    
                        <a href="DepController?action=edit&did=<c:out value='${dept.did}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
<%--                         <a href="DepController?action=delete&did=<c:out value='${dept.did}' />">Delete</a>                      --%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
			
</body>
</html>
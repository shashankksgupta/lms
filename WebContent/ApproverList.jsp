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
        <h1>Approvers List</h1>
        <h2>
            <a href="Approver.jsp">Add New Approver</a>
            &nbsp;&nbsp;&nbsp;
            <a href="IndexApprover.jsp">List All Approvers</a>    
        </h2>
 </center>
 
 <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Approvers</h2></caption>
            <tr>
                <th>AID</th>
                <th>EMPLOYEE NAME</th>
                 <th>APPROVER NAME</th>
			</tr>
			 <c:forEach var="approver" items="${approvers}">
                <tr>
                    <td><c:out value="${approver.aid}" /></td>
                    <td><c:out value="${approver.ename}" /></td>
                    <td><c:out value="${approver.aname}" /></td>
                    <td>    
                        <a href="ApproverController?action=edit&aid=<c:out value='${approver.aid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="ApproverController?action=delete&aid=<c:out value='${approver.aid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
			
</body>
</html>
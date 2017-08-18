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
        <h1>Holidays List</h1>
        <h2>
            <a href="Holidays.jsp">Add New Holiday</a>
            &nbsp;&nbsp;&nbsp;
            <a href="IndexHolidays.jsp">List All Holidays</a>    
        </h2>
 </center>
 
 <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Holidays</h2></caption>
            <tr>
                <th>HID</th>
                <th>HOLIDAY NAME</th>
                 <th>HOLIDAY DATE</th>
			</tr>
			 <c:forEach var="holidays" items="${holidays}">
                <tr>
                    <td><c:out value="${holidays.hid}" /></td>
                    <td><c:out value="${holidays.hname}" /></td>
                    <td><c:out value="${holidays.hdate}" /></td>
                    <td>    
                        <a href="HolidaysController?action=edit&hid=<c:out value='${holidays.hid}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="HolidaysController?action=delete&hid=<c:out value='${holidays.hid}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
			
</body>
</html>
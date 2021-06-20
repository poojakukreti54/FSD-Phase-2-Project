<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<style type="text/css">

.btn{
	color:#add8e6;
	font-size: 15px;
    background-color:#6699cc;
    border: black;
    border-radius: 10%;
    size: 200%;
    padding:10px 15px;
    text-align: center;
    box-shadow: 3px 9px black;
    outline: none;
    cursor: pointer;
    margin: 20px 30px;}


</style>
</head>



<body>

<%
	session = request.getSession(false);
	if (session.getAttribute("uname")==null){
		response.sendRedirect("index.html");
	}
%>
	
	<%@include  file="header.jsp" %>
	<br><br>


	

	<a href="<%=request.getContextPath()%>/newTeacher"><button class="btn"> Add New Teacher</button></a> 
 	<h1>Teacher List</h1>
 	
 	<table border="2" cellpadding="10" cellspacing="1">
		<thead>
			<tr>
				<th>Teacher ID</th>
				<th>Teacher Name</th>
				<th>Teacher Location</th>
				<th>Actions</th>
			</tr>
		</thead>
		
		<tbody>

		<c:forEach var="adm" items="${TEACHERS}">
				<tr>
					<td> <c:out value="${adm.teacherid}" /> </td>
					<td> <c:out value="${adm.teachername}" /> </td>
					<td> <c:out value="${adm.teacherlocation}" /> </td>
					
					<td><%
						//request.setAttribute("adminid", 1);%>
						<%--  <a href="updateTeacher?teacherid=<c:out value='${adm.teacherid}' />">Update</a> | 
						  --%>
						<a href= "deleteTeacher?teacherid=<c:out value='${adm.teacherid}' />" onclick = "if (!(confirm('Are you sure to delete this student?'))) return false">Delete</a>
						
		
					</td>
				</tr>



			</c:forEach>
		</tbody>
	</table>











</body>
</html>
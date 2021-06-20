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
	<button class="btn"> <a href="<%=request.getContextPath()%>/report">Generate report for class</a> </button>
 	
 	<h1>Class Report</h1>
 	
 	<table border="2" cellpadding="10" cellspacing="1">
		<thead>
			<tr>
				<th>Class ID</th>
				<th>Class Name</th>
				
			</tr>
		</thead>
		
		<tbody>

		<c:forEach var="adm" items="${CLASS}">
			<tr>
					<td> <c:out value="${adm.classsid}" /> </td>
					<td> <c:out value="${adm.classsname}" /> </td>
					
					
			
				</tr>



			</c:forEach>
		</tbody>
	</table>











</body>
</html>
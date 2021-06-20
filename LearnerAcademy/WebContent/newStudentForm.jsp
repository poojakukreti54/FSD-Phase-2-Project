<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="<%=request.getContextPath()%>/insertStudent">
			<input type="text" name="studentname" placeholder="Student Name" />
			<input type="text" name="studentlocation" placeholder="Student Location" />
			<input type="submit" value="Add Student"/>


	</form>
</body>
</html>
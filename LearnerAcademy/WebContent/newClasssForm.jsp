<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="<%=request.getContextPath()%>/insertClasss">
			<input type="text" name="classsname" placeholder="Class Name" />
			<input type="text" name="subjectname" placeholder="Subject Name" />
			<input type="submit" value="Add Class"/>


	</form>
</body>
</html>
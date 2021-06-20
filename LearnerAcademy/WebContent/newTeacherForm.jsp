<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="<%=request.getContextPath()%>/insertTeacher">
			<input type="text" name="teachername" placeholder="Teacher Name" />
			<input type="text" name="teacherlocation" placeholder="Teacher Location" />
			<input type="submit" value="Add Teacher"/>


	</form>
</body>
</html>
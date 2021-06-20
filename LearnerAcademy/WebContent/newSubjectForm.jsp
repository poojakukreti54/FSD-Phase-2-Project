<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="<%=request.getContextPath()%>/insertSubject">
			<input type="text" name="subjectname" placeholder="Subject Name" />
			<input type="text" name="teachername" placeholder="Teacher Name" />
			<input type="text" name="teacherid" placeholder="Teacher id" />
			<input type="text" name="classsid" placeholder="Class id" />
			
			
			
			
			<input type="submit" value="Add Subject"/>


	</form>
</body>
</html>
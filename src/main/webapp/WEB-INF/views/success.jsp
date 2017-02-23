<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<font color="green"></font>
	<div>
		<div align="right">
			<a href="${pageContext.request.contextPath}/student/logout"><b>Log
					Out</b></a>
		</div>
		<div align="left">
			Welcome<b style="color: red;">${student.firstName}</b>
		</div>
	</div>

	<div align="center">
		<table>
			<tr>
				<td>Student Name:</td>
				<td>${student.firstName }</td>
			</tr>
			<tr>
				<td>Student email:</td>
				<td>${student.email }</td>
			</tr>
			<tr>
				<td>Student DOB:</td>
				<td>${student.DOB }</td>
			</tr>
		</table>
	</div>
</body>
</html>
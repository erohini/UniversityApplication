<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
		<div align="center">
		<h1>Register Student</h1>
			<table>
			<s:form commandName="studentData" action="${pageContext.request.contextPath}/student/register" method="post">
				<tr>
					<td>First Name: </td>
					<td><s:input path="firstName" /></td>
					<td><s:errors path="firstName" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Last Name: </td>
					<td><s:input path="lastName" /></td>
					<td><s:errors path="lastName" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>User Name: </td>
					<td><s:input path="userName" /></td>
					<td><s:errors path="userName" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Password </td>
					<td><s:input path="password" /></td>
					<td><s:errors path="password" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Confirm Password </td>
					<td><s:input path="confirmPassword" /></td>
					<td><s:errors path="confirmPassword" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>email: </td>
					<td><s:input path="email" /></td>
					<td><s:errors path="email" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td>Date of Birth: </td>
					<td><s:input path="DOB" /></td>
					<td><s:errors path="DOB" cssStyle="color:red;"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="register" /></td>
				</tr>
				</s:form>
			</table>
		</div>
	
</body>
</html>
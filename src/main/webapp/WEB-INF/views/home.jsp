<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<%-- <h2>Welcome</h2>
<a href="<%=request.getContextPath()%>/login">click here</a> --%>

<div align="center">
<h1>Registration and Login</h1>

<table>
<tr><td><a href="${pageContext.request.contextPath}/student/register">Register Student</a></td></tr>
<tr><td><a href="${pageContext.request.contextPath}/student/login">Login Student</a></td></tr>
</table>
</div>

</body>
</html>
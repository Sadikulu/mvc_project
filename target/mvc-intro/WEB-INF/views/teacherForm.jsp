<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Teacher</title>
<link rel="stylesheet" href="/mvc-intro/resources/css/app.css">
</head>
<body>
	<div class="container">
		<div align="center">
			<h2>Add / Update Teacher</h2>
			<table>
				<form:form modelAttribute="teacher" action="saveTeacher"
					method="post">
					 <form:hidden path="id" />
					<tr>
						<td class="teacherprop">FirstName:</td>
						<td><form:input path="firstName" size="30" /></td>
						<td><form:errors path="firstName" class="error" /></td>
					</tr>

					<tr>
						<td class="teacherprop">LastName:</td>
						<td><form:input path="lastName" size="30" /></td>
						<td><form:errors path="lastName" class="error" /></td>
					</tr>

					<tr>
						<td class="teacherprop">TcNo:</td>
						<td><form:input path="tcNo" size="30" /></td>
						<td><form:errors path="tcNo" class="error" /></td>
					</tr>

					<tr>
						<td></td>
						<td align="center"><form:button>Submit</form:button></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>
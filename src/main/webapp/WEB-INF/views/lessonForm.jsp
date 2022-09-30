<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Add Lesson</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="containerLesson">
		<div align="center">
			<h2>Add / Update Lesson</h2>
			<table>
				<form:form modelAttribute="lesson" action="saveLesson" method="post">
					<form:hidden path="id" />
					<tr>
						<td class="studentprop">Lesson Name:</td>
						<td><form:input path="name" size="30" /></td>
						<td><form:errors path="name" class="error" /></td>
					</tr>

					<tr>
						<td class="studentprop">Page :</td>
						<td><form:input path="page" size="30" /></td>
						<td><form:errors path="page" class="error" /></td>
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
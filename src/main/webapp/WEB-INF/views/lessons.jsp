<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Lesson-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="containerLesson">
		<h2> Lessons </h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Name</th>
				<th>Page </th>
				<th>CreateDate</th>
			</tr>

			<c:forEach items="${lessons}" var="lesson" varStatus="status">

				<!-- create an "update" link with Student id -->
				<c:url var="updateLink" value="/lessons/update">
					<c:param name="id" value="${lesson.id}" />
				</c:url>

				<!-- create an "delete" link with Student id -->
				<c:url var="deleteLink" value="/lessons/delete">
					<c:param name="id" value="${lesson.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0 ? 'red':'yellow'}">
					<td>${lesson.id}</td>
					<td>${lesson.name}</td>
					<td>${lesson.page}</td>
					<td>${lesson.createDate}</td>
					<td>
						<!-- show the links --> 
						 
						<a class="update" href="${updateLink}">Update</a> 
						<a class="delete" href="${pageContext.request.contextPath}/lessons/delete/${lesson.id}">Delete</a>
						<!--   <a class="delete" href="${deleteLink}"> Delete</a>-->
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/lessons/new">Add Lesson</a>
		<p><a class="normal" href="${pageContext.request.contextPath}">Home Page</a>
	</div>
</body>
</html>
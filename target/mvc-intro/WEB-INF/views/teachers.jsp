<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher-project</title>

<link rel="stylesheet" href="/mvc-intro/resources/css/app.css">
</head>
<body>
	<div class="container">
		<h2>Teachers</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Tc No</th>
				<th>CreateDate</th>
			</tr>

			<c:forEach items="${teachers}" var="teacher" varStatus="status">

				<!-- create an "update" link with Teacher id -->
				<c:url var="updateLink" value="/teachers/update">
					<c:param name="id" value="${teacher.id}" />
				</c:url>

				<!-- create an "delete" link with Teacher id -->
				<c:url var="deleteLink" value="/teachers/delete">
					<c:param name="id" value="${teacher.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${teacher.id}</td>
					<td>${teacher.firstName}</td>
					<td>${teacher.lastName}</td>
					<td>${teacher.tcNo}</td>
					<td>${teacher.createDate}</td>
					<td>
						<!-- show the links --> 
						<!-- <a class="update" href="/teachers/update/${teacher.id}">Update</a>  -->
						<a class="update" href="${updateLink}">Update</a> 
						 <a class="delete" href="${deleteLink}"> Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
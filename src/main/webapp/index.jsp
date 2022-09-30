<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<%@page isELIgnored="false" %>
<title>Student Management System</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<div class="container">
<div class="container1">
<h2>STUDENT MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/students/">List Student</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/students/new">Add Student</a></p>
</div>

<div class="container2">
<h2>TEACHER MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/teachers/">List Teachers</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/teachers/new">Add Teacher</a></p>
</div>

 <div class="container3">
<h2>LESSON MANAGEMENT SYSTEM</h2>
<p><a class="normal" href="${pageContext.request.contextPath}/lessons/">List Lessons</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/lessons/new">Add Lesson</a></p>
</div>   
</div>
</body>
</html>

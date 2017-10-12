<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List Instructors</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css ">
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Instructor Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Instructor" 
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempInstructor" items="${instructors }">
					<!-- link "update" with instructor -->
					<c:url var="updateLink" value="/instructor/showFormForUpdate">
						<c:param name="instructorId" value="${tempInstructor.id}"></c:param>
					</c:url>
					<!--  link "delete" with instructor -->
					<c:url var="deleteLink" value="/instructor/delete">
						<c:param name="instructorId" value="${tempInstructor.id}"></c:param>
					</c:url>
					
					<tr>
						<td>${tempInstructor.firstName } </td>
						<td>${tempInstructor.lastName } </td>
						<td>${tempInstructor.email } </td>
						<!--  display the update link -->
						<td>
							<a href="${updateLink}">Update</a>
							
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this instructor?'))) return false">Delete</a>
						
						</td>
					</tr>
				
				</c:forEach>
			</table>
		</div>
	
	</div>

</body>
</html>
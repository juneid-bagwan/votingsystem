<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all users</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>uid</td>
			<td>address</td>
			<td>Date of Birth</td>
			<td>first name</td>
			<td>last name</td>
			<td>mobile numer</td>
		</tr>
		<c:forEach items="${ls}" var="item">
			<tr>

				<td>${item.uid}</td>
				<td>${item.address}</td>
				<td>${item.dob}</td>
				<td>${item.fname}</td>
				<td>${item.lname}</td>
				<td>${item.mno}</td>

			</tr>
		</c:forEach>

	</table>
	<br>
	<form action="deleteuser">
		delete user<input type="number" placeholder="enter user id" name="uid">
		<button type="submit">delete</button>
	</form>




</body>
</html>
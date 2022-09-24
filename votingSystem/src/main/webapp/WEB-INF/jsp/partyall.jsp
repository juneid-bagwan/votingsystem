<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>party name</td>
		</tr>
		<c:forEach items="${ls}" var="item">
			<tr>

				<td>${item.partyname}</td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<form action="deleteparty">
		delete party<input type="text" placeholder="enter party name"
			name="partyname">
		<button type="submit">delete</button>
	</form>
	<form action="addparty">
		add party<input type="text" placeholder="enter party name"
			name="partyname">
		<button type="submit">add</button>
	</form>
</body>
</html>
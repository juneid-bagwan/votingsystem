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

	<br>
<table border="1">
<tr>
<td>id</td>
<td>name</td>
<td>password</td>
</tr>
	<c:forEach items="${ls}" var="item">
    <tr>

            <td>${item.aid}</td>
            <td>${item.aname}</td>
            <td>${item.password}</td>

        </c:forEach>
    </tr>
	</table>
		<form action="deleteadmin" method="post">
		delete admin<input type="number" placeholder="enter admin id"
			name="aid">
		<button type="submit">delete</button>
	</form>

	
</body>
</html>
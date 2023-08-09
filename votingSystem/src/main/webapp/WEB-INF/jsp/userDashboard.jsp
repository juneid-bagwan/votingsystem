
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>
<meta charset="UTF-8">
<title>user dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<form action="voteto">
		uid:<input type="text" id="country" name="uid" th:value="${uid}"
			readonly><br> <br>
		<table class="table table-success table-striped">
			<tr>
				<th>party name</th>
				<th>choose</th>
			</tr>
			<tr th:each=" item : ${partys}">
				<td th:text="${item.partyname}"></td>
				<td><input type="radio" id="html" th:name="partyname" th:value="${item.partyname}"></td>
			</tr>




		</table>
		<button type="submit">vote</button>
	</form>
	<h1></h1>
</body>
</html>
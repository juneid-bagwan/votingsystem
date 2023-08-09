
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-success table-striped">
		<tr>
			<th>party name</th>
			<th>Action</th>
		</tr>

		<tr th:each="item:${ls}">

			<td th:text="${item.partyname}">
			<td><a th:href="@{/deleteparty/{id}(id=${item.partyname})}">delete</a>
		</tr>


	</table>
	<br>

	<form action="addparty">
		add party<input type="text" placeholder="enter party name"
			name="partyname">
		<button type="submit">add</button>
	</form>
		<button><a th:href="@{/BacktoDashboard}">Back</a></button>
	
</body>
</html>
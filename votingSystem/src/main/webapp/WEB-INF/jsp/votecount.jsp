
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
			<th>votes</th>
		</tr>

		<tr th:each="emp,iterStat : ${partylist}">
			<td th:text="${emp.partyname}">ID</td>
			<td th:text="${counts[iterStat.index]}"></td>
		</tr>

	</table>
		<button><a th:href="@{/BacktoDashboard}">Back</a></button>
	
</body>
</html>
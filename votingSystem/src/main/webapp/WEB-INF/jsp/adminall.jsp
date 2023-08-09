
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<br>
	<table class="table table-success table-striped">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>password</th>
			<th>action</th>
		</tr>
	
			<tr th:each="item:${ls}">

				<td th:text="${item.aid}">
				<td th:text="${item.aname}">
				<td th:text="${item.password}">
				<td> <a th:href = "@{/admin/delete/{id}(id=${item.aid})}">Delete</a></td>
		</tr>
	</table>
		<button><a th:href="@{/BacktoDashboard}">Back</a></button>
	


</body>
</html>
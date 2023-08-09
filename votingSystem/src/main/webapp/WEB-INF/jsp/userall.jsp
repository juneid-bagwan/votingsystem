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
<title>all users</title>
</head>
<body>
	<form action="/searchUser">
		<input type="text" placeholder="search by name" name="name">
		<button>search</button>
	</form>
	<table class="table table-success table-striped">
		<tr>
			<th>uid</th>
			<th>address</th>
			<th>Date of Birth</th>
			<th>first name</th>
			<th>last name</th>
			<th>mobile number</th>
			<th>Action</th>
		</tr>

		<tr th:each=" item : ${ls}">

			<td th:text="${item.uid}">
			<td th:text="${item.address}">
			<td th:text="${item.dob}">
			<td th:text="${item.fname}">
			<td th:text="${item.lname}">
			<td th:text="${item.mno}">
			<td><a th:href="@{/students/edit/{id}(id=${item.uid})}">update</a><br><a
				th:href="@{/deleteuser/{id}(id=${item.uid})}">delete</a></td>



		</tr>

	</table>
	<br>
	<button><a th:href="@{/BacktoDashboard}">Back</a></button>




</body>
</html>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>
<style>
.container {
	display: flex;
	align-items: center;
	justify-content: center;
}
.block{
    display: flex;
    margin-left: 80px;
    margin-top: 100px;
}
</style>
<meta charset="UTF-8">
<title>login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="userlog block ">
			<h2>user login</h2>
			<form action="finduser">
				uid:<input type="text" name="uid" placeholder="enter user id"
					oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');"
					required="required"><br>
				<button class="btn btn-dark" value="submit">submit</button>
				<br>

			</form>
			<a href="/newuser">don't have an account?? </a>
		</div>
		<div class="adminlog block">

			<h2>admin login</h2>
			<form action="findAdmin">
				admin name:<input type="text" name="name" required="required"
					placeholder="name" /><br> password:<input type="password"
					name="password" required="required" placeholder="password"><br>
				<button class="btn btn-dark" name="submit">login</button>
			</form>
		</div>
	</div>
</body>
</html>
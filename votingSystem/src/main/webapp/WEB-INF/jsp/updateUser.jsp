
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	box-sizing: border-box;
}

/* basic stylings ------------------------------------------ */
body {
	background: url(https://scotch.io/wp-content/uploads/2014/07/61.jpg);
}

.container {
	font-family: 'Roboto';
	width: 600px;
	margin: 30px auto 0;
	display: block;
	background: #FFF;
	padding: 10px 50px 50px;
}

h2 {
	text-align: center;
	margin-bottom: 50px;
}

h2 small {
	font-weight: normal;
	color: #888;
	display: block;
}

.footer {
	text-align: center;
}

.footer a {
	color: #53B2C8;
}

/* form starting stylings ------------------------------- */
.group {
	position: relative;
	margin-bottom: 45px;
}

input {
	font-size: 18px;
	padding: 10px 10px 10px 5px;
	display: block;
	width: 300px;
	border: none;
	border-bottom: 1px solid #757575;
}

input:focus {
	outline: none;
}

/* LABEL ======================================= */
label {
	color: #999;
	font-size: 18px;
	font-weight: normal;
	position: absolute;
	pointer-events: none;
	left: 5px;
	top: 10px;
	transition: 0.2s ease all;
	-moz-transition: 0.2s ease all;
	-webkit-transition: 0.2s ease all;
}

/* active state */
input:focus ~ label, input:valid ~ label {
	top: -20px;
	font-size: 14px;
	color: #5264AE;
}

/* BOTTOM BARS ================================= */
.bar {
	position: relative;
	display: block;
	width: 300px;
}

.bar:before, .bar:after {
	content: '';
	height: 2px;
	width: 0;
	bottom: 1px;
	position: absolute;
	background: #5264AE;
	transition: 0.2s ease all;
	-moz-transition: 0.2s ease all;
	-webkit-transition: 0.2s ease all;
}

.bar:before {
	left: 50%;
}

.bar:after {
	right: 50%;
}

/* active state */
input:focus ~ .bar:before, input:focus ~ .bar:after {
	width: 50%;
}

/* HIGHLIGHTER ================================== */
.highlight {
	position: absolute;
	height: 60%;
	width: 100px;
	top: 25%;
	left: 0;
	pointer-events: none;
	opacity: 0.5;
}

/* active state */
input:focus ~ .highlight {
	-webkit-animation: inputHighlighter 0.3s ease;
	-moz-animation: inputHighlighter 0.3s ease;
	animation: inputHighlighter 0.3s ease;
}

/* ANIMATIONS ================ */
@
-webkit-keyframes inputHighlighter {from { background:#5264AE;
	
}

to {
	width: 0;
	background: transparent;
}

}
@
-moz-keyframes inputHighlighter {from { background:#5264AE;
	
}

to {
	width: 0;
	background: transparent;
}

}
@
keyframes inputHighlighter {from { background:#5264AE;
	
}

to {
	width: 0;
	background: transparent;
}

}
#res {
	margin-left: 500px;
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>

<body>
	<h2>
		<i>update user</i>
	</h2>
	<div id="res">
		<form th:action="@{/updateUserDet/{id} (id=${obj.uid})}" th:object="${obj}">

			<div class="group">
				<input type="number" required readonly id="name" th:value="${obj.uid}"
					oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');"
					name="uid"> <span class="highlight"></span> <span
					class="bar"></span> <label>uid</label>
			</div>

			<div class="group">
				<input type="text" required name="fname" th:value="${obj.fname}">
				<span class="highlight"></span> <span class="bar"></span> <label>first
					name</label>
			</div>

			<div class="group">
				<input type="text" required name="lname" th:value="${obj.lname}">
				<span class="highlight"></span> <span class="bar"></span> <label>last
					name</label>
			</div>
			<div class="group">
				<input type="text" required name="mno" th:value="${obj.mno}"
					oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');">
				<span class="highlight"></span> <span class="bar"></span> <label>mobile
					no</label>
			</div>
			<div class="group">
				<input type="text" required name="address" th:value="${obj.address}">
				<span class="highlight"></span> <span class="bar"></span> <label>address</label>
			</div>
			<div class="group">
				<input type="Date" required name="dob" th:value="${obj.dob}">
				<span class="highlight"></span> <span class="bar"></span> <label>Date
					Of Birth</label>
			</div>
			<button name="submit" class="btn btn-outline-dark" value="submit"
				type="submit" style="margin-left: 100px">update</button>

		</form>
	</div>
</body>
</html>
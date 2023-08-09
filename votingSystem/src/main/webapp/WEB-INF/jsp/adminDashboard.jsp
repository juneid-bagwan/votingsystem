
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>admin dashboard</title>
</head>
<body>
<div class="d-grid gap-2">
<button type="button" class="btn btn-outline-secondary"><a href="/adminall">all admin</button></a>
<button type="button" class="btn btn-outline-secondary"><a href="/userall">all users</button></a>
<button type="button" class="btn btn-outline-secondary"><a href="/partyall">all partys</button></a>
<button type="button" class="btn btn-outline-secondary"><a href="/countvote">count votes</button></a>
</div>
<button type="button" class="btn btn-outline-dark"><a href="/Logout">Log out</button></a>
</body>
</html>
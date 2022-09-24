<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h2>user login</h2>
<form action="finduser" >
uid:<input type="text" name="uid" placeholder="enter user id" required="required"><br>
<button  value="submit">submit</button>
</form>
<a href="/newuser" ><button name="newuser" value="new user" >new user</button></a>
<h2>admin login</h2>
<form action="findAdmin" >
admin name:<input type="text" name="name" required="required" placeholder="name"><br>
password:<input type="password" name="password" required="required" placeholder="password"><br>
<button name="submit">login</button>
</form>
</body>
</html>
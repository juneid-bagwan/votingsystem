<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>new user</h2>
<form action="addUser" method="post">

<input type ="number" placeholder="uid" name="uid"><br>
<input type ="text" placeholder="first name" name="fname"><br>
<input type ="text" placeholder="last name" name="lname"><br>
<input type ="number" placeholder="mobile number" name="mno"><br>
<input type ="text" placeholder="address" name="address"><br>
<input type ="Date" placeholder="Date of birth" name="dob"><br>
<button name="submit" value="submit" type="submit">submit</button>

</form>
</body>
</html>
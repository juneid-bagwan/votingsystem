<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user dashboard</title>
</head>
<body>
<form action="voteto" >
uid:<input type="text" id="country" name="uid" value="${uid}" readonly><br><br>
<table border="1">
<tr>
<td>party name</td>
<td>choose</td>
</tr>
<c:forEach var="window" items="${partys}">
		<tr><td>${window.partyname}		</td>
		<td>	 <input type="radio" id="html" name="partyname" value="<c:out value="${window.partyname }"/>">  
		
		</td></tr>
	
		
	</c:forEach>
	
	</table>
	<button type ="submit">vote</button>
</form>
<h1></h1>
</body>
</html>
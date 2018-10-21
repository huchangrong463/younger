<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>hello</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>


<form action="${pageContext.request.contextPath}/user/update" method="post">
<table>
	<tr>
		<td>uuid</td>
		<td><input type="text" name="uuid" id="uuid" value="${um.uuid}" /></td>
	</tr>
	<tr>
		<td>name</td>
		<td><input type="text" name="name" id="name" value="${um.name}"/></td>
	</tr>
	<tr>
		<td>age</td>
		<td><input type="text" name="age" id="age" value="${um.age}"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="修改"/></td>
	</tr>
</table>
</form>
</body>
</html>
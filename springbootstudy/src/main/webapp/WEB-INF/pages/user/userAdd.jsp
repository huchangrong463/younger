<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>hello</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form action="${pageContext.request.contextPath}/user/add" method="post">
<table>
	<tr>
		<td>uuid</td>
		<td><input type="text" name="uuid" id="uuid"/></td>
	</tr>
	<tr>
		<td>name</td>
		<td><input type="text" name="name" id="name"/></td>
	</tr>
	<tr>
		<td>age</td>
		<td><input type="text" name="age" id="age"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="新增"/></td>
	</tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<title>hello</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static2/css/my.css"/>
jsp
<table border="1" class="table-striped">
	<tr>
		<td>uuid</td>
		<td>name</td>
		<td>age</td>
		<td><a href="${pageContext.request.contextPath}/user/toAdd">转到新增</a></td>
	</tr>
	<c:forEach items="${userList }" var="m">
	<tr>
		<td>${m.uuid}</td>
		<td>${m.name}</td>
		<td>${m.age}</td>
		<td>
			<span th:text="${iterStat}"></span>
			<a href="${pageContext.request.contextPath}/user/toUpdate?uuid=${m.uuid}">修改</a>
			<a href="${pageContext.request.contextPath}/user/delete?uuid=${m.uuid}">删除</a>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>

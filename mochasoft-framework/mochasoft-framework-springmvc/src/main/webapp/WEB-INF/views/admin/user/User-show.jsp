<!-- /views/admin/user/User-show.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User-show.jsp</title>
<%@include file="/WEB-INF/views/commons/common.jsp" %>
</head>
<body>
<a href="admin/user/User-addInput.do">添加用户</a><br />
<c:forEach items="${userList}" var="v">
	${v} | <a href="admin/user/User-delete.do?id=${v.id}">删除用户</a>
	<br/>
</c:forEach>
</body>
</html>
<!-- /views/admin/user/show.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/commons/common.jsp" %>
</head>
<body>
	<a href="admin/user/addInput.do">添加用户</a><br />
	<c:forEach items="${list}" var="v">
		<a href="admin/user/update.do?id=${v.id}">编辑</a> |
		${v} | 
		<a href="admin/user/delete.do?id=${v.id}">删除</a>
		<br/>
	</c:forEach>
</body>
</html>
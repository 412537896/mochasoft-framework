<!-- /views/admin/onlineuser/listActiveUsers.jsp -->
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
	<div id="footer">
	${numUsers} user(s) are logged in!
	</div>
	<h1>Active Users</h1>
	<ul>
	<c:forEach items="${activeUsers}" var="uinfo">
		<li>
			<strong>${uinfo.key.username}</strong> 
			/ Last Active: <strong>${uinfo.value}</strong>
		</li>
	</c:forEach>
	</ul>
</body>
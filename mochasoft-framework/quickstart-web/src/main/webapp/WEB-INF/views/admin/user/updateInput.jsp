<!-- /views/admin/user/addInput.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/commons/common.jsp" %>
</head>
<body>
<form method="post" action="admin/user/update.do">
	<input type="hidden" name="id" value="${entity.id}">
	id:<label>${entity.id}</label> <br/>
	userid:<input type="text" name="userId" value="${entity.userId}"> <br/>
	username:<input type="text" name="username" value="${entity.username}"> <br/>
	password:<input type="text" name="password" value="${entity.password}">  (加密后的密码) <br/>
	status:<input type="text" name="status" value="${entity.status}"> <br/>
	<input type ="submit" value="提交">
	<input type ="reset" value="重置">
</form>
</body>
</html>
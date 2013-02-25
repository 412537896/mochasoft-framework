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
<form method="post" action="admin/user/add.do">
	userid:<input type="text" name="userId" value="user1"> <br/>
	username:<input type="text" name="username" value="username1"> <br/>
	password:<input type="text" name="password" value="1"> <br/>
	status:<input type="text" name="status" value="1"> <br/>
	<input type ="submit" value="提交">
	<input type ="reset" value="重置">
</form>
</body>
</html>
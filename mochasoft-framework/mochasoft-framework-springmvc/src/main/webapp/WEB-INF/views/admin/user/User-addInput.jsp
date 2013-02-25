<!-- /views/admin/user/User-addInput.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user-addInput.jsp</title>
<%@include file="/WEB-INF/views/commons/common.jsp" %>
</head>
<body>
<form method="post" action="admin/user/User-add.do">
	id:<input type="text" name="id" value="1"> <br/>
	username:<input type="text" name="username" value="u1"> <br/>
	password:<input type="text" name="password" value="p1"> <br/>
	email:<input type="text" name="email" value="e1"> <br/>
	mobile:<input type="text" name="mobile" value="b1"> <br/>
	<input type ="submit" value="提交">
	<input type ="reset" value="重置">
</form>
</body>
</html>
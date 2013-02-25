<!-- /views/admin/role/addInput.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/commons/common.jsp" %>
</head>
<body>
<form method="post" action="admin/role/update.do">
	<input type="hidden" name="id" value="${entity.id}">
	id:<label>${entity.id}</label> <br/>
	name:<input type="text" name="name" value="${entity.name}"> <br/>
	descn:<input type="text" name="descn" value="${entity.descn}"> <br/>
	<input type ="submit" value="提交">
	<input type ="reset" value="重置">
</form>
</body>
</html>
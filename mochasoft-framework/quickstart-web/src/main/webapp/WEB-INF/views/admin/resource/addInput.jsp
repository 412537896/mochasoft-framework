<!-- /views/admin/resource/addInput.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/commons/common.jsp" %>
</head>
<body>
<form method="post" action="admin/resource/add.do">
	name:<input type="text" name="name" value="name1"> <br/>
	resType:<input type="text" name="resType" value="resType1"> <br/>
	url:<input type="text" name="url" value="url1"> <br/>
	orderNum:<input type="text" name="orderNum" value="5"> <br/>
	descn:<input type="text" name="descn" value="descn1"> <br/>
	<input type ="submit" value="提交">
	<input type ="reset" value="重置">
</form>
</body>
</html>
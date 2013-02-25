<!-- /views/admin/roleuser/show.jsp -->
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
	<a href="admin/roleuser/addInput.do">角色成员</a><br />
	<c:forEach items="${list}" var="v">
		<c:choose>
    		<c:when test="${v.userId == 'admin'}">
    			<c:out value="${v}"></c:out><br/>
    		</c:when>
    		<c:otherwise>  
				${v} | 
				<a href="admin/roleuser/delete.do?accId=${v.userId}&roleId=${v.roleId}">删除</a>
				<br/>
		   </c:otherwise>
		</c:choose>
	</c:forEach>
</body>
</html>
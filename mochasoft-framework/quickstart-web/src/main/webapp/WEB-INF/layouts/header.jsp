<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header" class="row">
    <a href="<c:url value="/" />"><img src="<c:url value="static/images/logo.png" />" alt="mochasoft" /></a>
	<div class="pull-right">
		你好,<strong><sec:authentication property="principal.name"/></strong> | 
		<c:url value="/logout" var="logoutUrl"/>
		<span><a href="${logoutUrl}">注销</a></span>
	</div>
	<!--   Menu Tag begin -->
     <div id="page-menu" style="margin-top: 8px; margin-bottom: 8px">
		<c:url value="/" var="homeUrl"/>
		<span><a href="${homeUrl}">首页</a> </span>
		<sec:authorize url="/user/home.do">
			<c:url value="/user/home.do" var="accountUrl"/>
			<span><a href="${accountUrl}">我的帐号</a></span>
		</sec:authorize>
			<c:url value="/admin/onlineuser/listActiveUsers.do" var="onlineuserUrl"/>
			<span><a href="${onlineuserUrl}">在线用户</a></span>
		<sec:authorize url="/admin/user/show.do">
			<c:url value="/admin/user/show.do" var="adminUserUrl"/>
			<span><a href="${adminUserUrl}">用户管理</a></span>
		</sec:authorize>
		<sec:authorize url="/admin/role/show.do">
			<c:url value="/admin/role/show.do" var="adminRoleUrl"/>
			<span><a href="${adminRoleUrl}">角色管理</a></span>
		</sec:authorize>
		<sec:authorize url="/admin/roleuser/show.do">
			<c:url value="/admin/roleuser/show.do" var="adminRoleUserUrl"/>
			<span><a href="${adminRoleUserUrl}">角色成员</a></span>
		</sec:authorize>
		<sec:authorize url="/admin/resource/show.do">
			<c:url value="/admin/resource/show.do" var="adminResourceUrl"/>
			<span><a href="${adminResourceUrl}">资源管理</a></span>
		</sec:authorize>
		<sec:authorize url="/admin/roleresource/show.do">
			<c:url value="/admin/roleresource/show.do" var="adminRoleResourceUrl"/>
			<span><a href="${adminRoleResourceUrl}">角色资源</a></span>
		</sec:authorize>
     </div>
</div>
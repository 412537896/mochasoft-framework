<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="leftbar" class="span2">
	<div class="submenu">
		<c:url value="/" var="homeUrl"/>
		<a id="index-tab" href="${homeUrl}">首页</a>
	</div>
	<h1>独立演示</h1>
	<div class="submenu">
		<a id="web-tab" href="story/web">Web演示</a>
		<a id="userhome-tab" href="user/home.do">我的帐号</a>
		<a id="webservice-tab" href="story/webservice">WebService演示</a>
		<a id="log-tab" href="log/console">日志控制演示</a>
		<a id="jmx-tab" href="story/jmx">JMX演示</a>
	</div>
</div>
<!-- /views/index.jsp -->
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script>
			$(document).ready(function() {
				$("#index-tab").addClass("active");
			});
		</script>
	</head>
	 <body>
	 	<HR>
	 	<div id="body" align="center">
		   <h3>首页，登录后可见!</h3>
		   <h2>Welcome!</h2>
		   <h4>Spring Security 权限管理访问：</h4>
		   <iframe width="95%" height="50%" name="iframe"></iframe>
		</div>
		<HR>
	 </body>
</html>
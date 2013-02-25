<!-- /views/index.jsp -->
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
   <title>Welcome Page</title>
   <%@include file="/WEB-INF/views/commons/common.jsp" %>
 </head>
 
 <body>
 	<div align="center">
	 	Index.jsp<br />
	 	<a href="admin/user/User-show.do">测试样例:</a>
 	</div>
 </body>

</html>
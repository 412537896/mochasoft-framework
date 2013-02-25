<!-- /layouts/default.jsp -->
<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><decorator:title default="MochaSoft"/></title>
	<%@include file="/WEB-INF/views/commons/common.jsp" %>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<link type="image/x-icon" href="static/images/favicon.ico" rel="shortcut icon" />
	<link href="static/bootstrap/2.2.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<link href="static/css/default.css" type="text/css" rel="stylesheet" />
	<script src="static/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
	<decorator:head />
</head>

<body>
	<script type="text/javascript">window.status = "Loading: <decorator:title />...";</script>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div class="row">
			<%@ include file="/WEB-INF/layouts/left.jsp"%>
			<div id="main" class="span10">
				<decorator:body />
			</div>
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
	<script src="static/bootstrap/2.2.2/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
<!-- /views/login.jsp -->
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/WEB-INF/views/commons/common.jsp" %>
	<style type="text/css">
	div.error {
	    width: 500px;
	    border: 2px solid red;
	    background-color: yellow;
	    text-align: center;
	}
	div.hide {
	    display: none;
	}
    </style>
</head>

<body onload='document.f.j_username.focus();'>
	<div align="center">
		<div class="error ${error == true ? '' : 'hide'}">登陆失败<br>
	      ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
	    </div>
		<form name="f" action="j_spring_security_check" method="post" style="width:260px;text-align:center;">
			<fieldset>
	        <legend>登陆</legend>
	        	用户： <input type="text" name="j_username" style="width:150px;" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/><br />
	       		 密码： <input type="password" name="j_password" style="width:150px;" /><br />
	        <input type="submit" value="登陆"/>
	        <input type="reset" value="重置"/>
	      </fieldset>
		</form>
		测试用户:<br />
			user/1 <br />
			admin/1 <br />
	</div>
</body>
</html>
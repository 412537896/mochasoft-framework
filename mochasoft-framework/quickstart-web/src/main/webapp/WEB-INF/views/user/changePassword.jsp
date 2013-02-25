<!-- /views/user/changePassword.jsp -->
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<HEAD>
	<%@include file="/WEB-INF/views/commons/common.jsp" %>
</HEAD>
<BODY>
 	<div id="body" align="center">
		<h1>Change Password</h1>
		<form method="post" action="user/changePassword.do">
			Old Password:
			<input id="oldpassword" name="oldpassword" size="20" maxlength="50" type="password"/>
			<br />
			New Password:
			<input id="password" name="password" size="20" maxlength="50" type="password"/>
			<br />
			<input type="submit" value="Change Password"/>	
		</form>
	</div>
 </body>

</html>
<!-- /views/user/home.jsp -->
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<head>
		<script>
			$(document).ready(function() {
				$("#userhome-tab").addClass("active");
			});
		</script>
</head>
<BODY>
 	<div id="body" align="center">
		<h1>Welcome to Your Account</h1>
		<p>
			Please find account functions below...
		</p>
		<ul>
			<li><a href="user/changePassword.do">Change Password</a></li>
		</ul>
	</div>
</BODY>
</html>
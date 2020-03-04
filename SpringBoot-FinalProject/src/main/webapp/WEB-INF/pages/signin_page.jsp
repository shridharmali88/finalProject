<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(event) {
		$("#confirmPassword").blur(function() {
			$("#newPwdErr").text('');
			var newPassword = $("#newPassword").val();
			var confirmPassword = $("#confirmPassword").val();
			if (newPassword != confirmPassword) {
				$("#newPwdErr").text('Password Not matching ...');
				$("#newPassword").html('');
				$("#confirmPassword").html('');
				$("#newPassword").focus();
			}
		});
	});
</script>
</head>
<body bgcolor="lightblue">

	<h1 style="color: navy; text-align: center;">
		<u>Sign in Page</u>
	</h1>
	<br />
	<form action="signin" method="POST">
		<table>
			<tr>
				<td>Email-Id::</td>
				<td><input type="email" name="email" size="25"></td>
			</tr>
			<tr>
				<td>Password::</td>
				<td><input type="password" name="password" size="25"></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Sign-In"></td>
			</tr>
		</table>
	</form>
	<table>
			<tr>
				<td><a href="forgotPwd">Forgot Password</a> </td>
				<td><a href="signup">Sign-Up</a> </td>
			</tr>
	</table>
</body>
</html>
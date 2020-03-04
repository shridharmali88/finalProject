<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unlock Account</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css'
          rel='stylesheet'> 
<script src= "https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" ></script> 
<script type="text/javascript">
	$(document).ready(function(event) {
		$("#confirmPassword").blur(function() {
			$("#newPwdErr").text('');
			var newPassword = $("#newPassword").val();
			var confirmPassword = $("#confirmPassword").val();
			if(newPassword != confirmPassword){
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

	<h2>Unlock Account</h2>
	<br>
	<br>

	<frm:form modelAttribute="unlockAcc" method="POST"
		action="unlockAccount">
		<table>
			<tr>
				<td>Employee Email-Id::</td>
				<td><frm:input path="email" readonly="true" size="25" /></td>
			</tr>
			<tr>
				<td>Enter temp password::</td>
				<td><frm:input path="tempPassword" /></td>
			</tr>
			<tr>
				<td>Enter New Pwd::</td>
				<td><frm:password path="newPassword" /><span
					style="color: red" id="newPwdErr"></span></td>
			</tr>
			<tr>
				<td>Confirm Pwd::</td>
				<td><frm:password path="confirmPassword" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Unlock Account"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>
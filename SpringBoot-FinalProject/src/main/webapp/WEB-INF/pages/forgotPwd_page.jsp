<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forgotPwd page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(event) {
		$("#email").blur(function() {
			$("#emailErr").text('');
			var email = $("#email").val();
			$.ajax({
				type : "GET",
				url : "uniqueEmail",
				data : {
					"email" : email
				},
				success : function(isUnique) {
					if (isUnique) {
						$("#emailErr").text('Please enter correct email id');
						$("#email").focus();
					}
					 $('#submit').prop('disabled', false);
				}
			});
		});
	});
</script>
</head>
<body bgcolor="lightblue">

	<h2>Forgot pwd Form</h2>
	<form action="forgotPwd" method="POST">
		Email-Id::<input type="email" name="email" id="email"><span id="emailErr"></span>
		<input type="submit" value="Submit" id="submit" disabled="disabled">
	</form>
	
</body>
</html>

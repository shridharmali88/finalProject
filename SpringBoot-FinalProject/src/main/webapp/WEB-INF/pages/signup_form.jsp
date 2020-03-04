<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Form</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css'
          rel='stylesheet'> 
<script src= "https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" ></script> 
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
					if (!isUnique) {
						$("#emailErr").text('Please choose unique email');
						$("#email").focus();
					}
				}
			});
		});
		
		
		$("#dob").focus(function() {
	         $( "#dob" ).datepicker({
	        	 changeMonth: true,
	       	     changeYear: true,
		         minDate: new Date('1971-01-01'),
		         maxDate: new Date('2018-12-31')
	         }); 
		});

		
		$("#countryNumber").change(function(){
			var countryNumber = $("#countryNumber").val();
			$('#stateNumber').empty();
			$("<option/>").val("").text("--Select--").appendTo("#stateNumber");
			$('#cityNumber').empty();
			$("<option/>").val("").text("--Select--").appendTo("#cityNumber");
			$.ajax({
				type : "GET",
				url : "getStatusByCountryId",
				data : {
					"countryId" : countryNumber
				},
				success : function(statesMap) {
					$.each(statesMap, function(key, value){
						$("<option/>").val(key).text(value).appendTo("#stateNumber");
					});
				}
			});
		});
		

		$("#stateNumber").change(function(){
			var stateId = $("#stateNumber").val();
			$('#cityNumber').empty();
			$("<option/>").val("").text("--Select--").appendTo("#cityNumber");
			$.ajax({
				type : "GET",
				url : "getStatusByStateId",
				data : {
					"stateId" : stateId
				},
				success : function(cityMap) {
					$.each(cityMap, function(key, value){
						$("<option/>").val(key).text(value).appendTo("#cityNumber");
					});
				}
			});
		});
	});
</script>

</head>
<body bgcolor="lightblue">

	<h2>Signup Form</h2>
	<frm:form modelAttribute="emp" method="POST" action="signup">
		<table>
			<tr>
				<td>Employee First Name::</td>
				<td><frm:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Employee Last Name::</td>
				<td><frm:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Employee EmailId::</td>
				<td><frm:input path="email" /><span id="emailErr"></span></td>
			</tr>
			<tr>
				<td>Phone Number::</td>
				<td><frm:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Date of Birth::</td>
				<td><frm:input path="dob" /></td>
			</tr>
			<tr>
				<td>Gender::</td>
				<td>Male <frm:radiobutton path="gender" value="M" /> Female <frm:radiobutton
						path="gender" value="F" />
				</td>
			</tr>
			<tr>
				<td>Country::</td>
				<td><frm:select path="countryNumber">
						<frm:option value="">--Select--</frm:option>
						<frm:options items="${countriesMap}" />
					</frm:select></td>
			</tr>
			<tr>
				<td>State::</td>
				<td><frm:select path="stateNumber">
						<frm:option value="">--Select--</frm:option>
					</frm:select></td>
			</tr>
			<tr>
				<td>City::</td>
				<td><frm:select path="cityNumber">
						<frm:option value="">--Select--</frm:option>
					</frm:select></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</frm:form>

</body>
</html>
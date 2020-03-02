<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Form</title>
<script type="text/javascript">
jQuery(document).ready(function($) {
	$("#search-form").submit(function(event) {

		// Prevent the form from submitting via the browser.
		event.preventDefault();
		searchViaAjax();

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
				<td><frm:input path="email" /></td>
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
				<td>Male <frm:radiobutton path="gender" value="M" /> 
					Female <frm:radiobutton path="gender" value="F" />
				</td>
			</tr>
			<tr>
				<td>Country::</td>
				<td><frm:select path="countryNumber">
						<frm:option value="">--Select--</frm:option>
						<frm:options items="${countriesMap}"/>
					</frm:select>
				</td>
			</tr>
			<tr>
				<td>State::</td>
				<td><frm:select path="stateNumber">
						<frm:option value="">--Select--</frm:option>
					</frm:select>
				</td>
			</tr>
			<tr>
				<td>City::</td>
				<td><frm:select path="cityNumber">
						<frm:option value="">--Select--</frm:option>
					</frm:select>
				</td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</frm:form>

</body>
</html>
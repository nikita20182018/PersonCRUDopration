<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Person Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #85929E;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #85929E;
	color: #F4ECF7;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 10px;
	overflow: hidden;
	word-break: normal;
	border-color: #85929E;
	color: #F4ECF7;
}
</style>




</head>

<body
	style="background-image: url('https://assets.entrepreneur.com/content/3x2/2000/20150824161251-wordpress-blogging-writing-typing-macbook-laptop-computer-technology-business-working.jpeg');">

	<script>
		function phonenumber() {
			var mobile = document.getElementById("phone").value;
			var numericmob = isNumber(mobile);
			if (!numericmob) {
				alert("Enter only positive numbers into the Contact Number field.");
				return true;
			}
			if (mobile.length != 10) {
				alert("Enter 10 digits Contact Number.");
				return true;
			}
		}
	</script>


	<h1 style="color: #F4ECF7">Add a Persons Details</h1>

	<div align="left">
		<form action="add" commandName="person" method="get"
			onsubmit="phonenumber()">

			<table>



				<tr bordercolor="red">
					<td style="color: #F4ECF7"><label path="id"> <spring:message
								text="ID" />
					</label></td>
					<td><input path="id" readonly="true" size="8" disabled="true"
						id="id" /> <hidden path="id" /></td>
				</tr>

				<tr>
					<td style="color: #F4ECF7"><label path="fname"> <spring:message
								text="First Name" />
					</label></td>
					<td><input path="fname" name="fname" id="fname"
						required="true" value="${param.fname}"/>
					<td></td>
					</td>
				</tr>
				<tr>
					<td style="color: #F4ECF7"><label path="lname"> <spring:message
								text="Last Name" />
					</label></td>
					<td><input path="lname" id="lname" value="${param.lname}" name="lname"
						required="true" /></td>
				</tr>
				<tr>
					<td style="color: #F4ECF7"><label path="country"> <spring:message
								text="Country" />
					</label></td>
					<td><input path="country" id="country" value="${param.country}" name="country"
						required="true" /></td>
				</tr>

				<tr>
					<td style="color: #F4ECF7"><label path="phone"> <spring:message
								text="Phone no." />
					</label></td>
					<td><input path="phone" type="number"
						title="Enter Valid Mob No" id="phone" name="phone" value="${param.phone}" required="true" />

					</td>
				</tr>

				<tr>
					<td style="color: #F4ECF7"><label path="email"> <spring:message
								text="Email_ID" />
					</label></td>
					<td><input path="email" id="email" name="email"
						required="true" /></td>
				</tr>

				<tr>
					<td style="color: #F4ECF7"><label path="password"> <spring:message
								text="Password" />
					</label></td>
					<td><input path="password" type="password" id="password"
						name="password" required="true" /></td>
				</tr>

				<tr>
					<td style="color: #F4ECF7"><label path="cpass"> <spring:message
								text="Confirm_Password" />
					</label></td>
					<td><input path="cpass" type="password" id="cpass"
						name="cpass" required="true" /></td>
				</tr>

				<tr>
					<td style="color: #F4ECF7"><label path="userType"> <spring:message
								text="User Type" />
					</label></td>
					<td><input path="userType" id="cpass" name="userType"
						required="true" /></td>
				</tr>
				<tr>
					<td style="color: #F4ECF7"><label path="OTP"> <spring:message
								text="OTP" />
					</label></td>
					<td><input path="OTP" id="OTP" name="OTP" /></td>
				</tr>
				<tr>
					<td>
					<td><input type="submit" name="action1" value="SEND OTP" /></td>
					</td>
					<td><input type="submit" name="action2" value="ADD Person" />
					</td>
				</tr>

			</table>
		</form>
	</div>
	<div align="left">
		<form action="search" commandName="search">
			<table>
				<tr>
					<td><input name="fname" id="fname"
						placeholde="Enter the text to search" required="true" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="serach person"></td>
				</tr>

				</form>
				<a href='search/${person.fname}'></a>
				</div>


				<br>
				<h2 style="color: #F4ECF7">Person List</h2>

				<p style="color:white">${message}</p>
				<table class="tg" border="1">

					<tr>

						<th width="80">ID</th>
						<th width="120">First Name</th>
						<th width="120">Last Name</th>
						<th width="120">Country</th>
						<th width="120">Phone No.</th>
						<th width="120">Email_ID</th>
						<th width="120">Password</th>
						<th width="120">confirm-password</th>
						<th width="120">User Type</th>
						<th width="60">Edit</th>
						<th width="60">Delete</th>
					</tr>

					<c:forEach var="person" items="${plist}">
						<tr>
							<td>${person.id}</td>
							<td>${person.fname}</td>
							<td>${person.lname}</td>
							<td>${person.country}</td>
							<td>${person.phone}</td>
							<td>${person.email}</td>
							<td>${person.password}</td>
							<td>${person.cpass}</td>
							<td>${person.userType}</td>
							<td><a href='edit?Id=${person.id}'>Edit</a></td>
							<td><a href="delete?Id=${person.id}">Delete</a></td>

						</tr>
					</c:forEach>

				</table>
</body>

</html>
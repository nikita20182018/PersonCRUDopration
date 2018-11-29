<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body style="background-image: url('http://deltatimes24.com/uploads/images/login-background-images-for-website-10.jpg'); ">

<div style="height:30%; width:30%">

</div>



<form:form action="authenticate" method="POST" commandName="person" >

		<table align="center">
		<caption style="color:white"><b>LOGIN</b></caption>
		
			<tr>
				<td style="color:white">UserName</td>
		<td>
				<form:input path="email" name="email" required="true" style="color:red"/>	
				 
				</td>
			</tr>
			<tr>
			<td style="color:white">
				Password
			</td>
				<td>
				<!--  <input type="password"   name="upass1" id="upass"/><span id="perror" style="color:red"> -->
				<form:password path = "password" name="password" required="true"/>
			   
					
				</td>
			</tr>
			<tr>
				<td>
				<input type = "submit" value ="LOGIN"/></td>
			
				<td>
				   
					<form:select path = "userType" name="userType">
                    
                     <form:options items = "${userTypes}" />
                     
						
                  </form:select>     	
					</td>
					
					</tr>
					<tr>
					<td><a href='changepassword'>Forgot password</a></td>
					
					</tr>
			
		</table>
	   
		<a href='changepassword'>Forgot password</a>
		</form:form>
	
</body>

</html>
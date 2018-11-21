<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url('http://storage.cloversites.com/evangeltemple2/site_images/page3_picture0_1388523616.jpg'); ">
    <form action="Person/add"  method="post"commandName="person">
     <h2  align="center" style="font-style: italic; color:white">Please check the Email for OTP</h2>
       <table align="center">
       <tr>
       		<td style="color:white">Enter OTP</td>
       		<td><form:input type="text" name="otp" id="otp" required="true" placeholde="Enter OTP"   /></td>
       		 
       </tr>
       <tr>
       <td colspan="2"><input type="submit" value="submit"></td>
      
       </tr>
       
       </table>
      <a href='Person/add/${otp}'></a>
    
    </form>
   
    </body>
</html>

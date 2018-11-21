<%@page import="com.nikita.spring.model.Person"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Edit Page</title>
        <style type="text/css">.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:10px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
            .tg .tg-4eph{background-color:#f9f9f9}
        </style>
    </head>
    <body style="background-image: url('https://s3.envato.com/files/228789095/Preview.jpg');" >
        <h1>
            Edit a Persons Details
        </h1>

        <form   method="post" commandName="person" >
            <table align="center">


                <tr bordercolor="red">
                    <td style="color:white">
                        <label path="id">
                            <spring:message text="ID"/>
                        </label>
                    </td>
                    <td>
                        <input path="id" readonly="true" size="8" value="${person.id}" disabled="true" id="id" />

                <hidden path="id" />
                </td> 
                </tr>

                <tr>
                    <td style="color:white">
                        <label path="fname">
                            <spring:message text="First Name"/>
                        </label>
                    </td>
                    <td>
                        <input path="fname" name="fname" id="fname" value="${person.fname}" required="true"/>

                    </td> 
                </tr>
                <tr >
                    <td style="color:white">
                        <label path="lname">
                            <spring:message text="Last Name"/>
                        </label>
                    </td>
                    <td>
                        <input path="lname" id="lname" name="lname" value="${person.lname}" required="true"/>
                    </td>
                </tr>
                <tr >
                    <td style="color:white">
                        <label path="country">
                            <spring:message text="Country"/>
                        </label>
                    </td>
                    <td>
                        <input path="country" id="country" name="country" value="${person.country}" required="true"/>
                    </td>
                </tr>

                <tr >
                    <td style="color:white">
                        <label path="phone">
                            <spring:message text="Phone no."/>
                        </label>
                    </td>
                    <td>
                        <input path="phone" id="phone" name="phone" value="${person.phone}" required="true"/>
                    </td>
                </tr>

                <tr >
                    <td style="color:white">
                        <label path="email">
                            <spring:message text="Email_ID"/>
                        </label>
                    </td>
                    <td>
                        <input path="email" type="email" id="email" name="email" value="${person.email}" required="true"/>
                    </td>
                </tr>

                <tr >
                    <td style="color:white">
                        <label path="password">
                            <spring:message text="Password"/>
                        </label>
                    </td>
                    <td>
                        <input path="password" type="password" id="password" name="password" value="${person.password}" required="true"/>
                    </td>
                </tr>

                <tr >
                    <td style="color:white">
                        <label path="cpass">
                            <spring:message text="Confirm_Password"/>
                        </label>
                    </td>
                    <td>
                        <input path="cpass" type="password" id="cpass" name="cpass" value="${person.cpass}" required="true" />
                    </td>
                </tr>

                <tr >
                    <td style="color:white">
                        <label path="userType">
                            <spring:message text="User Type"/>
                        </label>
                    </td>
                    <td>
                        <input path="userType" readonly="true" disable="true" id="cpass" name="userType" value="${person.userType}" required="true" />
                    </td>
                </tr>
                <tr >
                    <td>


                <tr >
                    <td colspan="2">

                        <input type = "submit" value = "Edit Person"/>
                        <a href='edit/${person.id}' ></a>

                    </td>

                </tr>

            </table>
        </form>

    </body>
</html>
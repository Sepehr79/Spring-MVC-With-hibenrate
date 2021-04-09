<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sepehr79
  Date: 4/7/2021
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

    <h1>Add new user</h1>
    <hr>

    <table>
        <form:form action="addUser" modelAttribute="user" method="post">

            <form:hidden path="id"/>

            <tr>
               <td>Enter name: </td> <td><form:input path="name" /></td>
                <td>
                    <form:errors path="name" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Enter lastname: </td> <td><form:input path="lastName" /></td>
                <td>
                    <form:errors path="lastName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Enter age: </td> <td><form:input path="age" /></td>
                <td>
                    <form:errors path="age" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>Enter email: </td> <td><form:input path="email" /></td>
                <td>
                    <form:errors path="email" cssClass="error"/>
                </td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Send" style="width: 100%"></td>
            </tr>
        </form:form>
    </table>

    <p id="message">${message}</p>
    <a href="${pageContext.request.contextPath}/users/list"> Back to main page </a>
</body>
</html>

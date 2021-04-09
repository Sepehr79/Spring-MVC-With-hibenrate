<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Sepehr79
  Date: 3/31/2021
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head id="mainPage">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    <title>Main page</title>
    <meta charset="UTF-8">
</head>
<body onload="alertHello()">
    <h1 id="test">People list</h1>

    <a href="addingUserList">Add new customer</a>

    <div>
        <table>
            <thead>
            <tr>
                <td>Email</td><td>Name</td><td>Lastname</td><td>Age</td><td>Options</td>
            </tr>
            </thead>

            <c:forEach var="user" items="${users}">

                <c:url var="updateLine" value="/users/updateUser">
                    <c:param name="userId" value="${user.id}"/>
                </c:url>

                <tr>
                    <td>${user.email}</td><td>${user.name}</td><td>${user.lastName}</td><td>${user.age}</td>
                    <td> <a href="${updateLine}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>

<%@ page import="java.util.*" %>
<%@ page import="com.zephie.jd2.classwork.core.entity.User" %>
<%@ page import="com.zephie.jd2.classwork.services.UserService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% Set<User> users = UserService.getInstance().get(); %>
<% request.setAttribute("users", users); %>
<html>
<head>
    <title>Messenger</title>
</head>
<body>
<h1>Messenger</h1>
<p>===========================================================</p>
<p>Users:<br>
    <c:forEach items="${users}" var="entry">
        User id: ${entry.id} <br>
        User login: ${entry.login} <br>
        User password: ${entry.password} <br>
        Ussr first name: ${entry.firstName} <br>
        User last name: ${entry.lastName} <br>
        User role id: ${entry.role} <br><br><br><br><br>
    </c:forEach>
</p>
</body>
</html>

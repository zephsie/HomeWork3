<%@ page import="com.zephie.jd2.classwork.services.UserService" %>
<%@ page import="com.zephie.jd2.classwork.services.MessageService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% long usersTotal = UserService.getInstance().numberOfUsers(); %>
<% long messagesTotal = MessageService.getInstance().numberOfMessages(); %>
<% request.setAttribute("usersTotal", usersTotal); %>
<% request.setAttribute("messagesTotal", messagesTotal); %>
<html>
<head>
    <title>Stats</title>
</head>
<body>
<h1>Stats</h1>
<p>===========================================================</p>
<p>Total Users:
    <c:out value="${usersTotal}"/>
</p>

<p>Total Messages:<br>
    <c:out value="${messagesTotal}"/>
</p>
</body>
</html>

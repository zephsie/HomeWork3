<%@ page import="com.zephie.jd2.classwork.services.UserService" %>
<%@ page import="com.zephie.jd2.classwork.services.MessageService" %>
<%@ page import="com.zephie.jd2.classwork.controllers.listeners.SessionCounter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setAttribute("usersTotal", UserService.getInstance().numberOfUsers()); %>
<% request.setAttribute("messagesTotal", MessageService.getInstance().numberOfMessages()); %>
<% request.setAttribute("usersActive", SessionCounter.getSessionCount()); %>
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
<p>Total Messages:
    <c:out value="${messagesTotal}"/>
</p>
<p>Number of active sessions are:
    <c:out value="${usersActive}"/>
<p>
</body>
</html>
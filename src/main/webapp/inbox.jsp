<%@ page import="java.util.*" %>
<%@ page import="com.zephie.jd2.classwork.core.entity.User" %>
<%@ page import="com.zephie.jd2.classwork.core.entity.Message" %>
<%@ page import="com.zephie.jd2.classwork.services.MessageService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<% User user = (User) request.getSession().getAttribute("user"); %>
<% request.setAttribute("messageSet", MessageService.getInstance().get(user.getLogin())); %>
<html>
<head>
  <title>Inbox</title>
</head>
<body>
<h1>Inbox</h1>
<p>===========================================================</p>
<p>
  <c:forEach items="${messageSet}" var="message">
    Sender: ${message.sender} <br>
    Recipient: ${message.recipient} <br>
    Text: ${message.text} <br><br><br><br><br>
  </c:forEach>
</p>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Inbox</title>
</head>
<body>
<h1>Inbox</h1>
<p>===========================================================</p>
<p>
  <c:forEach items="${messageSet}" var="message">
    Sender: <c:out value="${message.sender}"/> <br>
    Recipient: <c:out value="${message.recipient}"/> <br>
    Text: <c:out value="${message.text}"/> <br><br><br><br><br>
  </c:forEach>
</p>
<p>===========================================================</p>

<a href="${pageContext.request.contextPath}${sendMessageLink}">Send a message</a><br>
<a href="${pageContext.request.contextPath}${mainPageLink}">Main page</a>

</body>
</html>

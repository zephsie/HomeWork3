<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Messenger</title>
</head>
<body>
<h1>Messenger</h1>
<p>===========================================================</p>
<p>Users:<br>
    <c:forEach items="${users}" var="entry">
        User login: <c:out value="${entry.login}"/> <br>
        User password: <c:out value="${entry.password}"/> <br>
        Ussr first name: <c:out value="${entry.firstName}"/> <br>
        User last name: <c:out value="${entry.lastName}"/> <br>
        User role id: <c:out value="${entry.role}"/> <br><br><br>
    </c:forEach>
</p>
<p>===========================================================</p>

<a href="${pageContext.request.contextPath}${signInLink}">Sign in</a><br>
<a href="${pageContext.request.contextPath}${signUpLink}">Sign up</a><br>
<a href="${pageContext.request.contextPath}${sendMessageLink}">Send a message</a><br>
<a href="${pageContext.request.contextPath}${inboxLink}">Inbox</a><br>
<a href="${pageContext.request.contextPath}${statisticsLink}">Stats</a>

<form method="POST" action="${pageContext.request.contextPath}/api/logout">
    <input type="submit" value="Sign out">
</form>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Stats</title>
</head>
<body>

<h1>Statistics</h1>
<h2>Users: <c:out value="${numberOfUsers}"/></h2>
<h2>Messages: <c:out value="${numberOfMessages}"/></h2>
<h2>Active users: <c:out value="${numberOfActiveUsers}"/></h2>

</body>
</html>
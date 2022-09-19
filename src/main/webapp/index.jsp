<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% String loginPath = request.getContextPath() + "/ui/signIn"; %>
<% String registerPath = request.getContextPath() + "/ui/signUp"; %>
<html>
<head>
    <title>Welcome page</title>
</head>
<body>

<a href=<%=loginPath%>> Login </a><br>
<a href=<%=registerPath%>> Register </a>

</body>
</html>

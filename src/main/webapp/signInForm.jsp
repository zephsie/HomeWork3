<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h1>Login</h1>

<form method="POST" action="${pageContext.request.contextPath}/api/login">

  Login:<br>
  <label>
    <textarea rows="1" cols="30" name="login"></textarea>
  </label>

  <br>
  <br>
  <br>

  Password:<br>
  <label>
    <textarea rows="1" cols="30" name="password"></textarea>
  </label>

  <br>
  <br>
  <br>

  <input type="submit" value="submit">
</form>

<br>

<a href="${pageContext.request.contextPath}${signUpLink}">Sign up</a><br>
<a href="${pageContext.request.contextPath}${mainPageLink}">Main page</a>

</body>
</html>
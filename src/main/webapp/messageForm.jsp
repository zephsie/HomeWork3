<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Send message</title>
</head>
<body>
<h1>Send message</h1>

<form method="POST" action="${pageContext.request.contextPath}/api/message">

  Login:<br>
  <label>
    <textarea rows="1" cols="30" name="login"></textarea>
  </label>

  <br>
  <br>
  <br>

  Message:<br>
  <label>
    <textarea rows="1" cols="30" name="message"></textarea>
  </label>

  <br>
  <br>
  <br>

  <input type="submit" value="submit">
</form>

<br>

</body>
</html>

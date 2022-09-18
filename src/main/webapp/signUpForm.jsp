<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<form method="POST" action="${pageContext.request.contextPath}/api/user">

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

    First name:<br>
    <label>
        <textarea rows="1" cols="30" name="firstName"></textarea>
    </label>

    <br>
    <br>
    <br>

    Last name:<br>
    <label>
        <textarea rows="1" cols="30" name="lastName"></textarea>
    </label>

    <br>
    <br>
    <br>

    Date of birth:<br>
    <label>
        <input type="date" name="birthDate">
    </label>

    <br>
    <br>
    <br>

    <input type="submit" value="submit">
</form>

<br>

</body>
</html>

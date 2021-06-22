<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MySet</title>
</head>
<body>
<h1>WELCOME IN MYSET</h1>
<div>
    <form method="post" action="/login">
        EMAIL: <input type="text" name="username"/><br>
        PASSWORD: <input type="password" name="password"/><br>
        <input type="submit" value="LOGIN">
    </form><br>
    <a href="/register">REGISTER</a>
</div>
</body>
</html>

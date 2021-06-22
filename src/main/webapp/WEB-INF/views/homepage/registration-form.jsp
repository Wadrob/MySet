<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>REGISTRATION</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:input path="email" placeholder="email"/><br>
    <form:errors path="email"/>
    <form:input path="password" placeholder="password" type="password"/><br>
    <form:errors path="password"/>
    <input type="submit" value="Register">
</form:form>
</body>
</html>

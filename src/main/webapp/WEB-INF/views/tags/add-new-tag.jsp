<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ADD NEW TAG</title>
</head>
<body>
<form:form method="post" modelAttribute="Tag">
    <form:input path="name" placeholder="Name your tag"/>
    <input type="hidden" name="user" value="${user}"/>
    <input type="submit" value="Add tag">
</form:form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>EDIT ITEM</title>
</head>
<body>
<form:form method="post" modelAttribute="item">
    <form:input path="name"/><br>
    <form:input path="description"/><br>
    <form:select path="status" items="${statuses}"/><br>
    <form:input path="date" type="date"/><br>
    <form:hidden path="collection"/>
    <input type="submit" value="Upgrade">
</form:form>
</body>
</html>

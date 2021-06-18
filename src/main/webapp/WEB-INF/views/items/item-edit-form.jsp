<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>EDIT ITEM</title>
</head>
<body>
<form:form method="post" modelAttribute="item">
    <form:input path="name"/>
    <form:input path="description"/>
    <form:input path="status"/>
    <input type="submit" value="Upgrade">
</form:form>
</body>
</html>

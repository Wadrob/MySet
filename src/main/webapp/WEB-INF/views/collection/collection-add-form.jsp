<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new collection</title>
</head>
<body>
<form:form method="post" modelAttribute="collection">
    <form:input path="name" placeholder="Name of your collection"/><br>
    <form:input path="description" placeholder="Describe your collection"/><br>
    <input type="submit" value="Add">
</form:form>
</body>
</html>

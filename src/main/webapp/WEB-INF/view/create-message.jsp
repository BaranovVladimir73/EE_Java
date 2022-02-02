<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create message</title>
</head>
<body>
<form:form action="create" modelAttribute = "message">
    <form:hidden path="id" value="${message.id}"/>
    From: <form:input path="from"/>
    <br>
    To: <form:input path="to"/>
    <br>
    Message: <form:textarea path="body"/>
    <br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
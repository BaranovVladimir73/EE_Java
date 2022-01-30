<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<ul>
    <c:forEach var="product" items="${products}">
        <li>
            <br>
            id: ${product.id}
            <br>
            Product title: ${product.title}
            <br>
            Cost: ${product.cost}
            <br>
        </li>
    </c:forEach>
</ul>
<br>
<c:url var="createUrl" value="/main/add"/>

<a href="${createUrl}">CREATE</a>
</body>
</html>
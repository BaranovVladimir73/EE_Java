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
        <c:url var="viewUrl" value="/product/ + ${product.id}"/>
        <li>
            <a href="${viewUrl}">View</a>
            <br>
            id: ${product.id}
            <br>
            Product title: ${product.title}
            <br>
            Cost: ${product.cost}
            <br>
            Version: ${product.version}
            <br>
            Created by: ${product.createdBy}
            <br>
            Created date: ${product.createdDate}
            <br>
            Last modified by: ${product.lastModifiedBy}
            <br>
            Last modified date: ${product.lastModifiedDate}
        </li>
    </c:forEach>
</ul>
<br>
<c:url var="createUrl" value="/product/add"/>

<a href="${createUrl}">CREATE</a>
<br>
<c:url var="order" value="/product/all?sort=name_desc"/>
<a href="${order}">Direction DESC</a>

<br>
<c:url var="order" value="/product/all?sort=name_asc"/>
<a href="${order}">Direction ASC</a>
</body>
</html>
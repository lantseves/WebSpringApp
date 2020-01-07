<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 14.12.2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
        <title>Edit Order</title
</head>
<body>
    <c:if test="${empty order.name}">
        <c:url value="orders/add" var="var"/>
    </c:if>
    <c:if test="${!empty order.name}">
        <c:url value="orders/edit" var="var"/>
    </c:if>
    <form action="${var}" method="POST">
        <c:if test="${empty order.name}">
            <input type="hidden" name="id" value=0>
        </c:if>
        <c:if test="${!empty order.name}">
            <input type="hidden" name="id" value="${order.id}">
        </c:if>

        <label for="name">Name</label>
        <c:if test="${empty order.name}">
            <input type="text" name="name" id="name">
        </c:if>
        <c:if test="${!empty order.name}">
            <input type="text" name="name" id="name" value="${order.name}">
        </c:if>

        <label for="salary">Salary</label>
        <c:if test="${empty order.name}">
            <input type="text" name="salary" id="salary">
        </c:if>
        <c:if test="${!empty order.name}">
            <input type="text" name="salary" id="salary" value="${order.salary}">
        </c:if>

        <c:if test="${empty order.name}">
            <input type="submit" value="Add new order">
        </c:if>
        <c:if test="${!empty order.name}">
            <input type="submit" value="Edit Order">
        </c:if>

    </form>
</body>
</body>
</html>

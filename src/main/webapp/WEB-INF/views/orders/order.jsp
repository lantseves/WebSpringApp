<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 14.12.2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value = "orders/" var="orderUrl"/>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h2>Orders</h2>
    <a href="?form">Add new Order</a>
    <p>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th width="120">date</th>
            <th>salary</th>
            <th width="80">status</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.name}</td>
                <td align="center">${order.dateOrdered}</td>
                <td>${order.salary}</td>
                <td align="center">${order.statusOrder}</td>
                <td>
                    <a href="${orderUrl}${order.id}?form">edit</a>
                    <a href="${orderUrl}/delete/${order.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

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
    <title>Orders</title>
</head>
<body>
    <h2>Orders</h2>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>salary</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.name}</td>
                <td>${order.salary}</td>
                <td>
                    <a href="edit/${order.id}">edit</a>
                    <a href="delete/${order.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add</h2>
    <a href="add">Add new Order</a>
</body>
</html>

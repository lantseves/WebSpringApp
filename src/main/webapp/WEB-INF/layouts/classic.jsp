<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 22.12.2019
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
    <table width="100%">
        <tr >
            <td colspan="2">
                <tiles:insertAttribute name="header"/>
            </td>
        </tr>
        <tr>
            <td width="20%" nowrap="nowrap">
                <tiles:insertAttribute name="menu" />
            </td>
            <td width="80%">
                <tiles:insertAttribute name="body" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <tiles:insertAttribute name="footer" />
            </td>
        </tr>
    </table>
</body>
</html>

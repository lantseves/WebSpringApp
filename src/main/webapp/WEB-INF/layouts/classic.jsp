<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <spring:url value="/resources/scripts/jquery-1.12.4.js"
                var="jquery_url" />
    <spring:url value="/resources/scripts/jquery-ui.min.js"
                var="jquery_ui_url" />
    <spring:url value="/resources/styles/custom-theme/jquery-ui.theme.min.css"
                var="jquery_ui_theme_css" />
    <link rel="stylesheet" type="text/css" media="screen"
          href="${jquery_ui_theme_css}" />
    <script src="${jquery_url}" type="text/javascript">
        <jsp:text/></script>
    <script src="${jquery_ui_url}" type="text/javascript">
        <jsp:text/></script>

    <!-- Библиотека CKEditor -->
    <spring:url value="/resources/ckeditor/ckeditor.js"
                var="ckeditor_url" />
    <spring:url value="/resources/ckeditor/adapters/jquery.js"
                var="ckeditor_jquery_url" />
    <script type="text/javascript" src="${ckeditor_url}">
        <jsp:text/></script>
    <script type="text/javascript"
        src="${ckeditor_jquery_url}">
        <jsp:text/></script>

    <!-- Компонент jqGrid -->
    <spring:url value="/resources/jqgrid/css/ui.jqgrid.css"
                var="jqgrid_css" />
    <spring:url value="/resources/jqgrid/js/i18n/grid.locale-en.js"
                var="jqgrid_locale_url" />
    <spring:url value="/resources/jqgrid/js/jquery.jqGrid.min.js"
                var="jqgrid_url" />
    <link rel="stylesheet" type="text/css" media="screen"
          href="${jqgrid_css}" />
    <script type="text/javascript" src="${jqgrid_locale_url}">
        <jsp:text/></script>
    <script type="text/javascript" src="${jqgrid_url}">
        <jsp:text/></script>

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

<%-- 
    Document   : detail
    Created on : 20.7.2016, 12:51:31
    Author     : Milan
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="title" value="${\"Student details\"}"/>
<my:pagetemplate title="${title}">
    <jsp:attribute name="body">
        <table>
            <tr><td>First name</td><td>${student.firstName}</td></tr>
            <tr><td>Surname</td><td>${student.surname}</td></tr>
            <tr><td>Date of birth</td><td><fmt:formatDate value="${student.dateOfBirth}" type="DATE" pattern="dd.MM.yyyy"/></td></tr>
            <tr><td>Gender</td><td>${student.gender.toString()}</td></tr>
        </table>
        <a href="${pageContext.request.contextPath}/student/edit/${student.id}" class="btn-sm btn-primary">Edit</a>
    </jsp:attribute>
</my:pagetemplate>
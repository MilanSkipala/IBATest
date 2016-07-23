<%-- 
    Document   : index
    Created on : 21.7.2016, 11:52:08
    Author     : Milan
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%-- declare my own tags --%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%-- declare JSTL libraries --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="title" value="${\"Evidence of students\"}"/>
<my:pagetemplate title="${title}">
    <jsp:attribute name="body">
        <table class="table table-striped table-hover ">
            <thead>
                <tr>
                    <th>First name</th>
                    <th>Surname</th>
                    <th>Date of birth</th>
                    <th>Gender</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td><c:out value="${student.firstName}"/></td>
                        <td><c:out value="${student.surname}"/></td>
                        <td><c:out value="${student.dateOfBirth.date.toString()}. ${student.dateOfBirth.month + 1}. ${student.dateOfBirth.year.toString()}"/></td>
                        <td><c:out value="${student.gender}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/student/detail/${student.id}" class="btn-sm btn-default">Detail</a>
                            <a href="${pageContext.request.contextPath}/student/remove/${student.id}" class="btn-sm btn-primary">Remove</a>
                        </td>
                        
                    </tr>
                </c:forEach>
            </tbody>
        </table> 
    </jsp:attribute>
</my:pagetemplate>
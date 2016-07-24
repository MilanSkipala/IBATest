<%-- author: Milan Skipala --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="title" value="${\"Edit student\"}"/>
<my:pagetemplate title="${title}">
    <jsp:attribute name="body">
        <form:form class="form-horizontal" action="${pageContext.request.contextPath}/student/editSave/${student.id}" modelAttribute="student" id="studentForm">
                <legend>Edit student details.</legend>
                <div class="form-group ${firstName_error?'has-error':''}">
                    <form:label cssClass="col-sm-2 control-label" path="firstName">Name</form:label>
                    <div class="col-sm-4">
                        <form:input cssClass="form-control" placeholder="First name" path="firstName" type="text"/>
                        <form:errors path="firstName" cssClass="help-block"></form:errors>
                    </div>
                </div>
                <div class="form-group ${surname_error?'has-error':''}">
                    <form:label cssClass="col-sm-2 control-label" path="surname">Surname</form:label>
                    <div class="col-sm-4">
                        <form:input cssClass="form-control" placeholder="Surname" path="surname" type="text"/>
                        <form:errors path="surname" cssClass="help-block"></form:errors>
                    </div>
                </div>
                <div class="form-group ${dateOfBirth_error?'has-error':''}">
                    <form:label cssClass="col-sm-2 control-label" path="dateOfBirth">Date of birth</form:label>
                    <div class="col-sm-4">
                        <form:input cssClass="form-control" placeholder="Date of birth" path="dateOfBirth" id="datepicker" type="text"/>
                        <form:errors path="dateOfBirth" cssClass="help-block"></form:errors>
                    </div>
                </div>
                <div class="form-group">
                    <form:label cssClass="col-sm-2 control-label" path="gender">Gender</form:label>
                    <form:select name="genderSelect" class="col-sm-4" path="gender">
                        <c:forEach items="${genders}" var="gnd">
                            <form:option value="${gnd}">

                                ${gnd.toString()}
                            </form:option>
                        </c:forEach>
                    </form:select>
                </div>

                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button type="submit" class="btn btn-primary">Save details</button>
                        <a href="${pageContext.request.contextPath}/student/list" class="btn btn-default">Cancel</a>
                    </div>
                </div>
            </form:form>
    </jsp:attribute>
</my:pagetemplate>


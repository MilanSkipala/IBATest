<%-- 
    Document   : new
    Created on : 20.7.2016, 12:51:31
    Author     : Milan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>New student</title>
        <link rel="stylesheet" type="text/css" href="https://bootswatch.com/journal/bootstrap.min.css" media="screen">
    </head>
    <body>
        <div class="container-fluid" id="content">
        <h1>New student</h1>
            <form:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/student/create" modelAttribute="newStudent">
                <legend>Add new student in the system.</legend>
                <div class="form-group">
                    <form:label cssClass="col-sm-2 control-label" path="firstName">Name</form:label>
                    <div class="col-sm-4">
                        <form:input cssClass="form-control" placeholder="First name" path="firstName" />
                        <form:errors path="firstName" cssClass="help-block"></form:errors>
                    </div>
                </div>
                <div class="form-group">
                    <form:label cssClass="col-sm-2 control-label" path="surname">Surname</form:label>
                    <div class="col-sm-4">
                        <form:input cssClass="form-control" placeholder="Surname" path="surname"/>
                        <form:errors path="surname" cssClass="help-block"></form:errors>
                    </div>
                </div>
                <div class="form-group">
                    <form:label cssClass="col-sm-2 control-label" path="dateOfBirth">Date of birth</form:label>
                    <div class="col-sm-4">
                        <form:input cssClass="form-control" placeholder="Date of birth" path="dateOfBirth"/>
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
                        <button type="submit" class="btn btn-primary">Register member</button>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>

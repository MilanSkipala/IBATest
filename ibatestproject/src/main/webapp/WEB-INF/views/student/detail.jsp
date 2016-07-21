<%-- 
    Document   : detail
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
        <title>Student details</title>
        <link rel="stylesheet" type="text/css" href="https://bootswatch.com/journal/bootstrap.min.css" media="screen">
    </head>
    <body>
        <div class="container-fluid" id="content">
        <h1>Student ${student.firstName} ${student.surname}</h1>
        <table>
            <tr><td>First name</td><td>${student.firstName}</td></tr>
            <tr><td>Surname</td><td>${student.surname}</td></tr>
            <tr><td>Date of birth</td><td>${student.dateOfBirth.date.toString()}. ${student.dateOfBirth.month + 1}. ${student.dateOfBirth.year.toString()}</td></tr>
            <tr><td>Gender</td><td>${student.gender.toString()}</td></tr>
        </table>
        </div>
    </body>
</html>

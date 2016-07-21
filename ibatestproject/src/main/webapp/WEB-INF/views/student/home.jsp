<%-- 
    Document   : index
    Created on : 21.7.2016, 11:52:08
    Author     : Milan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="https://bootswatch.com/journal/bootstrap.min.css" media="screen">
    </head>
    <body>
        <div class="container-fluid" id="content">
        <h1>Evidence of students</h1>
        <a href="${pageContext.request.contextPath}/student/new" class="btn btn-primary">Add new student</a>
        </div>
    </body>
</html>

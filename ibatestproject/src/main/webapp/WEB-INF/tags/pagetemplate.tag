<%-- 
    Document   : pagetemplate
    Created on : 23.7.2016, 10:00:22
    Author     : Milan
--%>

<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="body" fragment="true" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en-EN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title><c:out value="${title}"/></title>
        <!-- Bootstrap -->        
        <link rel="stylesheet" type="text/css" href="https://bootswatch.com/journal/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css"/>
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
        
        <script>
            $( function() {
                $( "#datepicker" ).datepicker({dateFormat: "dd.mm.yy"});
            } );
        </script>
        <jsp:invoke fragment="head"/>
    </head>
    <body>
        <div class="header-image"></div>
        <!--page navigation starts here-->
        <nav class="navbar navbar-inverse /*navbar-fixed-top*/" id="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/student">Student evidence</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="${pageContext.request.requestURI.contains("/new") ? 'active' : ''}"><a href="${pageContext.request.contextPath}/student/new">Add student</a></li>
                        <li class="${pageContext.request.requestURI.contains("/list") ? 'active' : ''}"><a href="${pageContext.request.contextPath}/student/list">List of students</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        <!--page headline starts here-->
        <div class="container-fluid">
            <div class="page-header" id="banner">
                <div class="row">
                    <div class="col-lg-8 col-md-7 col-sm-6">
                        <h1><c:out value="${title}"/></h1>
                        <p class="lead"></p>
                    </div>
                    <div class="col-lg-4 col-md-5 col-sm-6">
                        <div class="sponsor">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- alerts -->
        <c:if test="${not empty alert_info}">
            <div class="alert alert-info" role="alert"><c:out value="${alert_info}"/></div>
        </c:if>
        <c:if test="${not empty alert_danger}">
            <div class="alert alert-danger" role="alert"><c:out value="${alert_danger}"/></div>
        </c:if>

        <!--page content starts here-->

        <div class="container-fluid" id="content">
            <jsp:invoke fragment="body"/>
        </div>
        <!--footer can be placed here--> 
        <script>
                $("#studentForm").validate({
                            rules: {
                                    firstName: {
                                            required: true,
                                            minlength: 1,
                                            maxlength: 60
                                    },
                                    surname: {
                                            required: true,
                                            minlength: 1,
                                            maxlength: 60
                                    },
                                    dateOfBirth: "required"
                            },
                            messages: {
                                    firstName: {
                                            required: "Please enter a first name",
                                            minlength: "First name must consist of at least 1 character",
                                            maxlength: "First name must consist of at most 60 characters"
                                    },
                                    surname: {
                                            required: "Please enter a first name",
                                            minlength: "First name must consist of at least 1 character",
                                            maxlength: "First name must consist of at most 60 characters"
                                    },
                                    dateOfBirth: "Please enter a date of birth"
                            }
                    });
        </script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>
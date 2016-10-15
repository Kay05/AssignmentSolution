<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kuda
  Date: 10/13/2016
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>
<div class="container-fluid" id="main">
  <!-- Header Starts -->
  <div class="navbar-wrapper">
    <div class="container-fluid">

      <div class="navbar navbar-default" role="navigation" id="top-nav">
        <div class="container">
          <div class="navbar-header">
            <!-- Logo Starts -->
            <a class="navbar-brand" href="/home">Tangent Assignment</a>
            <!-- #Logo Ends -->


            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>

          </div>


          <!-- Nav Starts -->
          <div class="navbar-collapse  collapse">
            <ul class="nav navbar-nav navbar-right scroll">
              <li <c:if test="${page == 'home'}">class="active" </c:if> > <a href="/home">Home</a></li>
              <li role="presentation" class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  <i class="fa fa-user-md"></i> ${msg}<span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                  <li><a href="/signout"><i class="fa fa-lock"></i> Logout</a></li>
                </ul>
              </li>
            </ul>
          </div>
          <!-- #Nav Ends -->

        </div>
      </div>

    </div>
  </div>
  <!-- #Header Starts -->

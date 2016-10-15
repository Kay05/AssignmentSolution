<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kuda
  Date: 10/13/2016
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>
<div class="wrapper">
    <form class="form-signin" action="/signin" name="submitForm" method="POST">
        <c:if test="${msg!=null}"><p class="help-block alert alert-info">${msg}</p></c:if>
        <h2 class="form-signin-heading">Please login</h2>
        <input type="text" class="form-control" name="userName" placeholder="Email Address" required="" autofocus="" />
        <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
        <label class="checkbox">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        <c:if test="${error!=null}"><p class="help-block alert alert-danger">${error}</p></c:if>
    </form>
</div>
<!--<div id="msg"></div>-->

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>
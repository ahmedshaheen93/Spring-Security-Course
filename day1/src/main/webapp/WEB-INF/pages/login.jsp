<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <%--@elvariable id="user" type="com.shaheen.model.User"--%>
    <form:form modelAttribute="user" method="post">
    <p class="error">${errorMessage}</p>
    <div class="from-row md-4">
        <label for="username"><spring:message code="user.username"/></label>
        <form:input path="username" cssClass="form-control" id="username"/>
        <form:errors path="username" cssClass="error"/>
    </div>
    <div class="from-row">
        <label for="password"><spring:message code="user.password"/> </label>
        <form:password path="password" cssClass="form-control" id="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <br>
    <input type="submit" class="btn btn-primary" value="Login">
    </form:form>

</body>
</html>

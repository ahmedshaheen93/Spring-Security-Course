<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <%--@elvariable id="user" type="com.shaheen.model.User"--%>
    <form:form modelAttribute="user" method="post">
        <div class="from-row md-4">
            <label for="firstName"><spring:message code="user.firstName"/></label>
            <form:input path="firstName" cssClass="form-control" id="firstName"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div class="from-row">
            <label for="lastName"><spring:message code="user.lastName"/> </label>
            <form:input path="lastName" cssClass="form-control" id="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
        <div>
            <label for="email"><spring:message code="user.email"/> </label>
            <form:input path="email" cssClass="form-control" id="email" type="email" min="0" step="0.01"/>
            <form:errors path="email" cssClass="error"/>
        </div>
        <div>
            <label for="username"><spring:message code="user.username"/> </label>
            <form:input path="username" cssClass="form-control" id="username" type="text"/>
            <form:errors path="username" cssClass="error"/>
        </div>
        <div>
            <label for="password"><spring:message code="user.password"/> </label>
            <form:input path="password" cssClass="form-control" id="password" type="text"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <br>
        <input type="submit" class="btn btn-primary" value="register">
    </form:form>

</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>all users</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">

    <a href="${pageContext.request.contextPath}/users/userReport.htm" target="_blank" class="btn btn-primary">print</a>
    <a href="${pageContext.request.contextPath}/users/pdfUserReport.htm" target="_blank"
       class="btn btn-primary">download</a>
    <a href="${pageContext.request.contextPath}/users/excelUserReport.htm" target="_blank"
       class="btn btn-primary">download excel</a>
    <table class="table">
        <thead class="table table-dark">
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Username</td>
            <td>Email</td>
        </tr>
        </thead>
        <tbody>
        <c:if test="${!empty users}">
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>

        </c:if>
        </tbody>

    </table>
</div>
</body>
</html>

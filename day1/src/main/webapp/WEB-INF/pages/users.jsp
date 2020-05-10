<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>all users</title>
    <jsp:include page="head.jsp"/>
</head>
<body class="container">
<jsp:include page="navbar.jsp"/>
<a href="${pageContext.request.contextPath}/users/userReport.htm" target="_blank" class="btn btn-primary">print</a>
<a href="${pageContext.request.contextPath}/users/pdfUserReport.htm" target="_blank"
   class="btn btn-primary">download</a>
<a href="${pageContext.request.contextPath}/users/excelUserReport.htm" target="_blank"
   class="btn btn-primary">download excel</a>
<table class="table">
    <thead class="table table-dark">
    <tr>
        <td>firstName</td>
        <td>lastName</td>
        <td>salary</td>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty users}">
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.salary}</td>
            </tr>
        </c:forEach>

    </c:if>
    </tbody>

</table>
</body>
</html>

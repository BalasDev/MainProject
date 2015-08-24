<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<link href="webres/css/input.css" rel="stylesheet">
<link href="webres/css/errors.css" rel="stylesheet">
<link href="webres/css/style.css" rel="stylesheet">

<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">

        <div class="panel panel-default">
            <div class="panel-heading">Summary</div>
            <div class="panel-body">${project.name}: ${project.description}</div>
        </div>


        <div class="table-responsive">
            <table class="table table-condensed table-hover table-striped table-bordered">

                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Login</th>
                    <th>Role</th>
                    <th>Position</th>
                </tr>

                <c:forEach items="${memberList}" var="member">
                <tr>
                    <td> ${member.employee.firstName} </td>
                    <td> ${member.employee.lastName} </td>
                    <td> ${member.employee.login} </td>
                    <td> ${member.employee.position.name} </td>
                    <td> ${member.role.name} </td>
                    </c:forEach>
            </table>
            <security:authorize url="/administrator">
                <div class="navbar-form navbar-left">
                    <a href="<c:url value="/toaddmember" />" class="btn btn-primary form-control">Add member</a>
                </div>
            </security:authorize>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>


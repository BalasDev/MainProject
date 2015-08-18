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


        <h1>${projectName}</h1>

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


                        <%--  <td>
                            <div class="btn-group">

                              <a style="cursor: pointer" data-toggle="modal" data-target="#delete_${member.id}"><i
                                      class="fa fa-remove"
                                      style="color: red"></i>
                              </a>
                            </div>
                          </td>--%>

                        <%--modal--%>
                        <%--<div class="modal fade" id="delete_${personality.id}">
                        <div class="modal-dialog">
                        <div class="modal-content">
                        <div class="modal-header">
                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Подтверждение удаления</h4>
                        </div>
                        <div class="modal-body">
                        <p class="text-center">Удаление записи пользователя
                        <strong>${personality.lastName}</strong>
                        </p>
                        </div>
                        <div class="modal-footer">
                        <button type="button" class="btn btn-primary"
                        onclick="location.href='<%=request.getContextPath()%>/delete/${personality.id}'">
                        Да
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                        Отмена
                        </button>
                        </div>
                        </div>
                        </div>
                        </div>--%>

                    </c:forEach>
            </table>
            <div class="navbar-form navbar-left">
                <a href="<c:url value="/toaddmember" />" class="btn btn-primary form-control">Add member</a>
            </div>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>


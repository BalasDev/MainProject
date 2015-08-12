<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<link href="webres/css/input.css" rel="stylesheet">
<link href="webres/css/errors.css" rel="stylesheet">
<link href="webres/css/style.css" rel="stylesheet">
<jsp:include page="header.jsp"/>
  <h1>Projects</h1>

  <div class="table-responsive">
  <table class="table table-condensed table-hover table-striped table-bordered">

  <tr>
  <%--  <th></th>--%>
  <th>Project name</th>
  <th>Description</th>

  <th></th>
  <%--<th>Образование</th>
  <th>Окончил</th>
  <th>Специальность</th>
  <th>Учёная степень</th>
  <th>Иностранные языки</th>
  <th>Был ли за границей</th>
  <th>Взыскания</th>
  <th>Участие в выборочных органах</th>
  <th>Имеет ли госнаграды</th>--%>
  </tr>

  <c:forEach items="${listProject}" var="project">
    <tr>
    <td>
    <div style="cursor: pointer" data-toggle="modal"
    data-target="#info_${project.id}">${project.name}</div>
    </td>
    <td>${project.description}</td>


      <td>
        <div class="btn-group">

          <a style="cursor: pointer" data-toggle="modal" data-target="#delete_${project.id}"><i
                  class="fa fa-remove"
                  style="color: red"></i>
          </a>
        </div>
      </td>

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
          <a href="<c:url value="/tocreateproject" />" class="btn btn-primary form-control">Create project</a>
      </div>
  </div>



<jsp:include page="footer.jsp"/>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<link href="webres/css/input.css" rel="stylesheet">
<link href="webres/css/errors.css" rel="stylesheet">
<link href="webres/css/style.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="webres/jquery/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="webres/bootstrap/dist/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        $("#btnStart").click(function () {
            $("#btnStart").attr('disabled', true);
            $("#btnResolve").removeAttr('disabled');
            $("#btnDone").removeAttr('disabled');
            $("#lblStatus").text('started');

        });

        $("#btnResolve").click(function () {
            $("#btnStart").removeAttr('disabled');
            $("#btnResolve").attr('disabled', true);
            $("#btnDone").removeAttr('disabled');
            $("#lblStatus").text('resolved');
        });

        $("#btnDone").click(function () {
            $("#btnStart").removeAttr('disabled');
            $("#btnResolve").removeAttr('disabled');
            $("#btnDone").attr('disabled', true);
            $("#lblStatus").text('finished');
        });
    });
</script>

<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="btn-group">

                            <button class="btn btn-success" id="btnStart">
                                Start Progress
                            </button>

                            <button class="btn btn-success" id="btnResolve">
                                Resolve Issue
                            </button>

                            <button class="btn btn-success" id="btnDone">
                                Done
                            </button>
                        </div>
                    </div>
                    <div class="panel-body">
                        Status:
                        <label id="lblStatus">fgfgfg</label>
                    </div>
                </div>
            </div>
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
            <div class="navbar-form navbar-left">
                <a href="<c:url value="/toaddmember" />" class="btn btn-primary form-control">Add member</a>
            </div>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>


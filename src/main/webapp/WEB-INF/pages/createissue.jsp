<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <!-- Bootstrap -->
    <link href="webres/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <link href="webres/bootstrap/dist/css/font-awesome.css" rel="stylesheet">
    <link href="webres/css/style.css" rel="stylesheet">
    <link href="webres/css/input.css" rel="stylesheet">
    <link href="webres/css/errors.css" rel="stylesheet">

</head>
<body>
<script type="text/javascript">

    function doAjax() {

        var id = projectId.options[projectId.selectedIndex].value;

        $.ajax({
            url: "getemployees",
            type: 'POST',
            data: JSON.stringify(id),
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data) {
                var obj = data;
                $.each(obj, function (key, value) {
                    $('#roleId').append($("<option></option>")
                            .
                            attr("value", value.id)
                            .text(value.login));
                });


            }
        });
    }
</script>

<div class="panel panel-warning">
    <div class="panel-heading">
        <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Create issue</a>
        </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
        <div class="form-horizontal">
            <form action="addmember" method="post">
                <%-- <fieldset style="padding-top: 10px" id="filterForm">--%>
                <div class="row">
                    <div class="col-lg-6 col-md-6 ">

                        <label class="col-lg-6 col-md-6 control-label" for="projectId">Choose employee</label>

                        <div class="col-lg-6 col-md-6 form-group">

                            <select class="form-control" name="projectId" id="projectId" onchange="doAjax();">
                                <option></option>
                                <c:forEach items="${projectList}" var="project">
                                    <option value=${project.id}> ${project.name} </option>
                                </c:forEach>
                            </select>

                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">

                        <label class="col-lg-6 col-md-6 control-label" for="roleId">Choose role</label>

                        <div class="col-lg-6 col-md-6 form-group">

                            <select class="form-control" name="roleId" id="roleId">

                                <option value=""></option>

                            </select>

                        </div>
                    </div>
                </div>
                <%--</fieldset>--%>
                <div class="col-lg-3 col-lg-3 col-md-6 form-group">
                    <button id='search' type="submit" class="btn btn-outline btn-block btn-success">Add</button>
                </div>

            </form>

        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="webres/jquery/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="webres/bootstrap/dist/js/bootstrap.min.js"></script>

</body>
</html>

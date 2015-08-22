<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<!-- Bootstrap -->
<link href="webres/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="webres/bootstrap/dist/css/font-awesome.css" rel="stylesheet">
<link href="webres/css/style.css" rel="stylesheet">
<link href="webres/css/input.css" rel="stylesheet">


<jsp:include page="header.jsp"/>

<script>
    $(document).ready(function () {
        $("#btnStart").click(function () {
            var s;
            $.ajax({
                url: "updatestatus",
                type: 'POST',
                data: JSON.stringify(2),
                contentType: 'application/json',
                mimeType: 'application/json',
                success: function (data) {
                    $("#btnStart").attr('disabled', true);
                    $("#btnResolve").removeAttr('disabled');
                    $("#btnDone").removeAttr('disabled');
                    $("#lblStatus").text(data.name);
                }
            });


        });

        $("#btnResolve").click(function () {

            $.ajax({
                url: "updatestatus",
                type: 'POST',
                data: JSON.stringify(3),
                contentType: 'application/json',
                mimeType: 'application/json',
                success: function (data) {
                    $("#btnStart").removeAttr('disabled');
                    $("#btnResolve").attr('disabled', true);
                    $("#btnDone").removeAttr('disabled');
                    $("#lblStatus").text(data.name);
                }
            });

        });

        $("#btnDone").click(function () {
            $.ajax({
                url: "updatestatus",
                type: 'POST',
                data: JSON.stringify(4),
                contentType: 'application/json',
                mimeType: 'application/json',
                success: function (data) {
                    $("#btnStart").removeAttr('disabled');
                    $("#btnResolve").removeAttr('disabled');
                    $("#btnDone").attr('disabled', true);
                    $("#lblStatus").text(data.name);

                }
            });

        });
    });
</script>

<div class="container">

    <div class="row">
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-heading text-center">
                    <div class="btn-group">
                        <button class="btn btn-default" id="btnStart">
                            Start Progress
                        </button>

                        <button class="btn btn-default" id="btnResolve">
                            Resolve Issue
                        </button>

                        <button class="btn btn-default" id="btnDone">
                            Done
                        </button>
                    </div>
                </div>
                <div class="panel-body">
                    Status:
                    <label id="lblStatus">${task.status.name}</label>
                </div>
            </div>
        </div>
        <form method="post" action="createActivity">
            <div class="col-lg-4">
                <div id="accordion" class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading text-center">
                            <a href="#collapse-1" data-parent="#accordion" data-toggle="collapse"> <i
                                    class="fa fa-pencil"></i> Report </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse-1">
                            <div class="panel-body">
                                <input type="text" class="form-control" id="duration" name="duration"
                                       placeholder="duration">
                                <textarea placeholder="comment" class="form-control" rows="3" id="comment"
                                          name="comment"></textarea>
                            </div>
                            <div class="panel-footer">
                                <button class="btn btn-success btn-block" id="btnAddReport" type="submit">Add</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="col-lg-2">
            <p class="text-center well-sm">Assigne to ${login}</p>
        </div>
        <div class="col-lg-2">
            <button class="btn btn-default pull-right btn-sm" type="button"><i class="fa fa-external-link-square"></i>
                Export
            </button>
        </div>
    </div>

    <div class="row">

    </div>


</div>


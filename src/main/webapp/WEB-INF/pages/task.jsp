<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<!-- Bootstrap -->
<link href="webres/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="webres/bootstrap/dist/css/font-awesome.css" rel="stylesheet">
<link href="webres/css/style.css" rel="stylesheet">


<jsp:include page="header.jsp"/>

<script>
    $(document).ready(function () {
        var status = $("#lblStatus").text();

        if (status == "to do") {
            $("#btnResolve").attr('disabled', true);
            $("#btnDone").attr('disabled', true);
        }
        ;

        if (status == "in progress") {
            $("#btnStart").attr('disabled', true);
            $("#btnDone").attr('disabled', true);
        }
        ;

        if (status == "delivered") {
            $("#btnStart").attr('disabled', true);
            $("#btnResolve").attr('disabled', true);
        }
        ;

        if (status == "done") {
            $("#btnStart").attr('disabled', true);
            $("#btnResolve").attr('disabled', true);
            $("#btnDone").attr('disabled', true);
        }
        ;


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
                    $("#btnDone").attr('disabled', true);
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
                    $("#btnStart").attr('disabled', true);
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
                    $("#btnStart").attr('disabled', true);
                    $("#btnResolve").attr('disabled', true);
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
        <div class="col-lg-4">
            <div class="container-fluid">

                <div id="accordion" class="panel-group">
                    <form:form method="post" action="save" modelAttribute="uploadForm" enctype="multipart/form-data">
                        <div class="panel panel-default">
                            <div class="panel-heading text-center">
                                <a href="#collapse-2" data-parent="#accordion" data-toggle="collapse"> <i
                                        class="fa fa-paperclip"></i> Attach file </a>
                            </div>
                            <div class="collapse panel-collapse" id="collapse-2">
                                <div class="panel-body">
                                    <input class="well-sm" type="file" name="file"
                                           style="padding-top: 5px;padding-bottom: 15px;"/>
                                    <input class="form-control" type="text" name="description" id="description"
                                           placeholder="description">
                                </div>
                                <div class="panel-footer text-center">
                                    <input class="btn btn-default btn-block" type="submit" value="attach"/>
                                </div>
                            </div>
                        </div>
                    </form:form>

                    <form method="post" action="createActivity">
                        <div class="panel panel-default">
                            <div class="panel-heading text-center">
                                <a href="#collapse-1" data-parent="#accordion" data-toggle="collapse"> <i
                                        class="fa fa-pencil"></i> Report </a>
                            </div>
                            <div class="collapse panel-collapse" id="collapse-1">
                                <div class="panel-body">
                                    <input type="text" class="form-control well-sm" id="duration" name="duration"
                                           placeholder="duration">
                                    <textarea placeholder="comment" class="form-control" rows="3" id="comment"
                                              name="comment"></textarea>
                                </div>
                                <div class="panel-footer">
                                    <button class="btn btn-default btn-block" id="btnAddReport" type="submit">Add
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>

        </div>
        <div class="col-lg-2">
            <p class="text-center well"><i class="fa fa-user fa-1x"></i> Assignee to ${login}</p>
        </div>
        <div class="col-lg-2">
            <button class="btn btn-default pull-right btn-sm" type="button"><i class="fa fa-external-link-square"></i>
                Export
            </button>
        </div>
    </div>

    <div class="row" style="padding-top: 70px;">
        <div class="col-lg-6">
            <div class="frame" style="height: 60%">
                <div class="rowStyle scroll" style="height: 400px">
                    <table class="table table-bordered" id="tblActiv">
                        <th class="text-center">Activity</th>
                        <c:forEach items="${listActivity}" var="activity">
                            <tr>
                                <td>
                                        ${activity.member.employee.lastName} ${activity.member.employee.firstName}
                                    project:${activity.member.project.name} task:${activity.assigment.task.description}
                                    <br>${activity.comment}
                                    <br>

                                    <div class="col-lg-6 text-left text-danger"
                                         style="font-size: x-small">Duration:${activity.duration}</div>
                                    <div class="col-lg-6 text-right text-danger"
                                         style="font-size: x-small">${activity.date}</div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>
        </div>
        <div class="col-lg-6">
            <div class="frame" style="height: 60%">
                <div class="rowStyle scroll" style="height: 400px">
                    <table class="table table-bordered" id="tblAttach">
                        <caption>Attachments</caption>
                        <th class="text-center">File</th>
                        <th class="text-center">Description</th>
                        <c:forEach items="${listAttachment}" var="attachment">
                            <tr>
                                <td>${attachment.name}</td>
                                <td>${attachment.description}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>
        </div>
    </div>

</div>


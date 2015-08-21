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

<jsp:include page="header.jsp"/>

<div class="container">
    <div class="row">
        <div class="row">
            <div class="col-lg-4">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <%--<div class="btn-group">--%>

                            <button class="btn btn-success" id="btnStart">
                                Start Progress
                            </button>

                            <button class="btn btn-success" id="btnResolve">
                                Resolve Issue
                            </button>

                            <button class="btn btn-success" id="btnDone">
                                Done
                            </button>
                        <%--</div>--%>
                    </div>
                    <div class="panel-body">
                        Status:
                        <label id="lblStatus">${task.status.name}</label>
                    </div>
                </div>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-condensed table-hover table-striped table-bordered">

                <tr>
                    <th>dfdfdf</th>
                    <th>dfddfdf</th>

                </tr>


            </table>

        </div>
    </div>
</div>


<jsp:include page="footer.jsp"/>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<!-- Bootstrap -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="webres/jquery/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="webres/bootstrap/dist/js/bootstrap.min.js"></script>
<link href="webres/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="webres/bootstrap/dist/css/font-awesome.css" rel="stylesheet">
<link href="webres/css/style.css" rel="stylesheet">
<link href="webres/css/input.css" rel="stylesheet">
<link href="webres/css/errors.css" rel="stylesheet">

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
                        <label id="lblStatus">fgfgfg</label>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-4">
                <div id="accordion" class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="#collapse-1" data-parent="#accordion" data-toggle="collapse"> <i class="fa fa-pencil "></i> Report </a>
                        </div>
                        <div class="collapse panel-collapse" id="collapse-1">
                            <div class="panel-body">
                                <input type="text" class="form-control" id="duration" placeholder="duration">
                                <textarea placeholder="comment" class="form-control" rows="3" ></textarea>
                            </div>
                            <div class="panel-footer">
                                <button class="btn btn-success btn-block" id="btnAddReport">Add</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



</div>


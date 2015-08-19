<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<link href="webres/css/dashboard.css" rel="stylesheet">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="webres/jquery/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="webres/bootstrap/dist/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function () {
        $("#btnShow").click(function () {
            $.post("showMore",
                    function (data) {
                        var activity = data;
                        $.each(activity, function (key, value) {
                            $("#tblActiv").append('<tr><td>' + value.lastName + ' ' + value.firstName +
                                    ' project:' + value.project + ' task:' + value.task + '<br>' + value.comment +
                                    '<br><div class="text-right text-danger" style="font-size: x-small">' + value.date +
                                    '</div></td></tr>');
                        });
                    });
        });
    });
</script>


<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div class="row" style="padding-left: 40px">
        <h3>System Dashboard</h3>
    </div>
    <div class="row">
        <div class="col-lg-6">

            <div class="frame scroll" style="height: 75%">
                <div class="container-fluid">
                    <div class="row">
                        <div class="navbar navbar-inverse navbar-static-top" style="height: 50px">
                            <div class="navbar-header">
                                <p class="navbar-brand" style="color: #FFFFFF; font-size: larger">Activity stream</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="rowStyle">
                    <table class="table" id="tblActiv">

                    </table>
                    <button id="btnShow">Show more</button>
                </div>
            </div>
        </div>


        <div class="col-lg-6">
            <div class="frame scroll" style="height: 75%">
                <div class="container-fluid">
                    <div class="row">
                        <div class="navbar navbar-inverse navbar-static-top" style="height: 50px">
                            <div class="navbar-header">
                                <p class="navbar-brand" style="color: #FFFFFF; font-size: larger">Assigned to ME</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="rowStyle">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="text-center">Key</th>
                            <th class="text-center">Summary</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Key</td>
                            <td>Summary</td>
                        </tr>
                        <tr>
                            <td>Key</td>
                            <td>Summary</td>
                        </tr>
                        <tr>
                            <td>Key</td>
                            <td>Summary</td>
                        </tr>
                        <tr>
                            <td>Key</td>
                            <td>Summary</td>
                        </tr>
                        <tr>
                            <td>Key</td>
                            <td>Summary</td>
                        </tr>
                        <tr>
                            <td>Key</td>
                            <td>Summary</td>
                        </tr>
                        <tr>
                            <td>Key</td>
                            <td>Summary</td>
                        </tr>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>

</div>
<jsp:include page="footer.jsp"/>
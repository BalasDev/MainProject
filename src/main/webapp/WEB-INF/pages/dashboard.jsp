<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<link href="webres/css/dashboard.css" rel="stylesheet">
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
                                <p class="navbar-brand" style="color: #FFFFFF; font-size: larger">Activity system</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="rowStyle">
                    <table class="table">
                        <tbody>

<c:forEach items="${listActivity}" var="activity">
    <tr>
        <td>${activity.comment} date ${activity.date}</td>
        <td>${activity.member.employee.firstName} </td>
    </tr>
</c:forEach>

                        </tbody>
                    </table>
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
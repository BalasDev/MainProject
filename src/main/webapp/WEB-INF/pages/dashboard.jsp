<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<link href="webres/css/dashboard.css" rel="stylesheet">
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div class="row" style="padding-left: 40px">
        <h1>System Dashboard</h1>
    </div>
    <div class="row"></div>
    <div class="col-lg-6">
        <div class="jumbotron panelSing scroll" style="height: 75%">
           <div class="row">
               <div class="navbar navbar-inverse">
                   <div class="container">
                       <div class="navbar-header">
                           <p  class="navbar-collapse" style="color: #FFFFFF">Activity system</p>
                       </div>
                   </div>
               </div>
           </div>



        </div>


    </div>
</div>
<jsp:include page="footer.jsp"/>
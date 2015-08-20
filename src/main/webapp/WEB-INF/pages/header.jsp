<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>

<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf8">
  <!-- Bootstrap -->
  <link href="webres/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
  <link href="webres/bootstrap/dist/css/font-awesome.css" rel="stylesheet">
  <link href="webres/css/style.css" rel="stylesheet">
  <script src="webres/jquery/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="webres/bootstrap/dist/js/bootstrap.min.js"></script>

</head>

<body>
<div class="containerNbar">
  <div class="rowNbar">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
            <span class="sr-only">Открыть навигацию</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="/" class="navbar-brand"><i class="fa fa-home pull-left fa-border"></i></a>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
          <ul class="nav navbar-nav">
           <%-- <li><a href="/">Dashboards</a></li>--%>
           <%-- <security:authorize url="/delete/">--%>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>

              </ul>
            </li>
           <%-- </security:authorize>--%>
          </ul>
          <form action="" class="navbar-form navbar-left">
            <a href="<c:url value="/tocreateissue" />" class="btn btn-primary form-control">Create issue</a>
          </form>
          <form action="" class="navbar-form navbar-left">
            <a href="<c:url value="/toprojectadministration" />" class="btn btn-primary form-control">Project administration</a>
          </form>
          <form action="" class="navbar-form navbar-right">
            <a href="<c:url value="/logout" />" class="btn btn-danger form-control">Exit</a>
          </form>
        </div>
      </div>
    </div>
  </div>
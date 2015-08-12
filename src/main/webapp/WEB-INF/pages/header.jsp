<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

</head>

<body>
<div class="container">
  <div class="row">
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
            <li><a href="/adds">Dashboards</a></li>
           <%-- <security:authorize url="/delete/">--%>
              <li><a href="/searchs">Projects</a></li>
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
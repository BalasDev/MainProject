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
 <H1>Create project</H1>
</head>
<body>

<form:form method="post" action="createproject" commandName="project">

<table>
    <tr>
        <td>Name</td>
        <td><form:input path="name"/> <%--<form:errors path="lastName" cssClass="error"/>--%></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><form:input path="description"/> <%--<form:errors path="firstName" cssClass="error"/>--%></td>
    </tr>

</table>
  <br>

</form:form>
        <button class="btn btn-primary" type="submit">Create</button>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="webres/jquery/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="webres/bootstrap/dist/js/bootstrap.min.js"></script>

</body>
</html>

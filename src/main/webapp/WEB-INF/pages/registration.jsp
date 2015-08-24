<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="webres/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
<link href="webres/bootstrap/dist/css/font-awesome.css" rel="stylesheet">
<link href="webres/css/style.css" rel="stylesheet">

<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
  <div class="row">
    <form role="form"  action="/createuser" method="post">
      <div class="col-lg-6">
        <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Create new Employee</strong></div>
        <div class="form-group">
          <label for="inputFirstName">Firstname</label>
          <div class="input-group">
            <input type="text" class="form-control" name="inputFirstName" id="inputFirstName" placeholder="Enter firstname" required>
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
          </div>
        </div>
        <div class="form-group">
          <label for="inputLastName">Lastname</label>
          <div class="input-group">
            <input type="text" class="form-control" name="inputLastName" id="inputLastName" placeholder="Enter lastname" required>
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
          </div>
        </div>
        <div class="form-group">
          <label for="inputLogin">Login</label>
          <div class="input-group">
            <input type="text" class="form-control" name="inputLogin" id="inputLogin" placeholder="Enter login" required>
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
          </div>
        </div>
        <div class="form-group">
          <label for="inputPassword">Password</label>
          <div class="input-group">
            <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Enter password" required>
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
          </div>
        </div>
        <div class="form-group">
          <label for="inputConfirmPassword">Confirm password</label>
          <div class="input-group">
            <input type="password" class="form-control" id="inputConfirmPassword" name="inputConfirmPassword" placeholder="Confirm password" required>
            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
          </div>
        </div>
        <div class="form-group">
          <label for="inputConfirmPassword">Select position</label>

        <select class="form-control" name="position" id="position">
          <option></option>
          <c:forEach items="${positions}" var="position">
            <option value=${position.id}> ${position.name} </option>
          </c:forEach>
        </select>
        </div>


        <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
      </div>
    </form>
    <%--<div class="col-lg-5 col-md-push-1">
      <div class="col-md-12">
        <div class="alert alert-success">
          <strong><span class="glyphicon glyphicon-ok"></span> Success! Message sent.</strong>
        </div>
        <div class="alert alert-danger">
          <span class="glyphicon glyphicon-remove"></span><strong> Error! Please check all page inputs.</strong>
        </div>
      </div>
    </div>--%>
  </div>
</div>
</body>
</html>

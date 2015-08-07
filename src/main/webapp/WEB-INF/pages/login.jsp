<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Sign in</title>
     <!-- Bootstrap -->
    <link href="webres/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
    <link href="webres/bootstrap/dist/css/font-awesome.css" rel="stylesheet">
    <link href="webres/css/signInStyle.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="jumbotron panelSing">
        <div class="textBlue textSmaller">
            Please use your EPAM domain credentials: domain login without @epam.com and domain password.
            <div>
                <font class="textRed">(!)Note: </font> Due to technicak limitations, JIRA username is truncated to 20
                first symbols. So, if your NAME_Surname exceeds 20 symbols?
                please use the truncated version. Sorry for an inconvenience.
            </div>
        </div>

        <div style="padding-top: 10px">
            <form id="slick-login" name="f" action="/j_spring_security_check" method="POST">
                <!--<div class="row"></div>-->
                <!--<div class="row"></div>-->
                <div class="row">
                    <div class="col-lg-3 text-right">
                        <label class="normal">Username</label>
                    </div>
                    <div class="col-lg-9">
                        <input type="text" name="j_username" value="" class="placeholder" placeholder="Username">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 text-right">
                        <label class="normal">Password</label>
                    </div>
                    <div class="col-lg-9">
                        <input input type="password" name="j_password" class="placeholder" placeholder="Password">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-9 col-lg-offset-3 checkbox">
                        <label for="remember_me" class="normal"><input type="checkbox" name="_spring_security_remember_me" id="remember_me"> Remember my login on this computer</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-9 col-lg-offset-3">
                        <label class="normal">
                            Not a member? To request an account, please contact ypur JIRA administrators.
                        </label>
                    </div>
                </div>


                <div class="row">
                    <div class="col-lg-9 col-lg-offset-3">
                        <button class="btn btn-primary" type="submit">Login with EPAM SSO</button>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-9 col-lg-offset-3">
                        <button class="btn btn-default" type="submit">Log In</button>
                    </div>
                </div>
            </form>

            <div>
                Security Disclaimer
                <div class="textSmaller">
                    This system is owned by EPAM Systems. If you are not aythorized to access this system, exit immediately.
                    Unauthorized access to this system is forbidden by company policies, national, and international laws.
                    Unauthorized users are subject to criminal and civil penalties as well as company initiated disciplinary
                    proceeding. By entering this system you acknowledge that you have authorized access and appropriate
                    level of privilege within the system.
                </div>
            </div>
        </div>


    </div>


</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="webres/jquery/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="webres/bootstrap/dist/js/bootstrap.min.js"></script>

</body>

</html>
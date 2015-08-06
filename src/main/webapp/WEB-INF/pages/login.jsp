<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<title>Авторизация</title>


</head>
<body>
<form id="slick-login" name="f" action="/j_spring_security_check" method="POST">
	<label>Логин:</label><input type="text" name="j_username" value="" class="placeholder" placeholder="Логин">
	<label>Пароль:</label><input type="password" name="j_password" class="placeholder" placeholder="Пароль...">
	<input name="submit" type="submit" value="ВОЙТИ">
</form>
</body>
</html>
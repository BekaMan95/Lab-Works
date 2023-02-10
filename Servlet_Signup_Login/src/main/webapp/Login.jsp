<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
<form action="Login" method ="post">
<table>
                <tr>
                    <th>UserName:</th><th><input type="text" name="username"/></th>
                </tr>
                <tr>
                    <th>Password:</th><th><input type="password" name="pass"/></th>
                </tr>
                <tr>
                    <th></th>
                    <th><input type="submit" name="Login" value="Login"></th>
                </tr>
            </table>
</form>
</body>
</html>
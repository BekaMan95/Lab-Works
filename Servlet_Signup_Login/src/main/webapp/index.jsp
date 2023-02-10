<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp page</title>
</head>
<body>
<form action="Signup" method ="post">
<table>
                <tr>
                    <th>UserName:</th><th><input type="text" name="username"/></th>
                </tr>
                <tr>
                    <th>Password:</th><th><input type="password" name="pass"/></th>
                </tr>
                <tr>
                    <th>email:</th><th><input type="email" name="email"/></th>
                </tr>
                <tr>
                    <th>Department:</th><th><input type="text" name="dept"/></th>
                </tr>
                <tr>
                    <th>Position:</th><th><input type="text" name="pos"/></th>
                </tr>
                <tr>
                    <th></th>
                    <th><input type="submit" name="Signup" value="sign up"></th>
                </tr>
            </table>
</form>
</body>
</html>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="login" method="post">

    <input type="text" name="email"
           maxlength="20" placeholder="Your name..."/>

    <input type="password" name="password"
           maxlength="25" placeholder="Your password..."/>

    <input type="submit" value="Next">
    <input type="reset" value="Clear">

</form>
    <p style="color: red">${error}</p>
</body>
</html>


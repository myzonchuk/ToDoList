<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--    <link rel="stylesheet" type="text/css" href="CSS/CSS.css">--%>
    <title>Registration form</title>
</head>
<body>
<div id="divWindow">
    <div class="divForm">
        <h3> registration form </h3>

        <form action="registration" method="post">

            <input type="hidden" name="role" value="USER">

            <input type="text" name="name"
                   maxlength="20" placeholder="Your name..."/>

            <input type="password" name="password"
                   maxlength="25" placeholder="Your password..."/>


            <button type="submit">Submit</button>
            <input type="reset" value="Clear">

        </form>
    </div>
</div>

</body>
</html>
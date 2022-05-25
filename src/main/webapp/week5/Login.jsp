<%--
  Created by IntelliJ IDEA.
  User: ZJY
  Date: 2022/5/25
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>


<%@include file="header.jsp"%>
<div style="text-align: center;">
    <b>Login</b>
    <form method="post" action="login">
        ID : <input type="text" name="ID" /> <br/>
        Password: <input type="password" name="password"/><br/>
        <input type="submit" value="Login"/>
    </form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>

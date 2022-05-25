<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>
<html>
<head>
    <title>UsrInfo</title>
</head>
<body>
<div style="text-align: center;">
    <h1> User Info </h1>

    <table border="1" cellpadding="3" cellspacing="0" style="width: 60%;margin:auto">
        <tr><td>ID:</td><td><%=request.getAttribute("id")%></td></tr>
        <tr><td>name:</td><td><%=request.getAttribute("name")%></td></tr>
        <tr><td>password:</td><td><%=request.getAttribute("password")%></td></tr>
        <tr><td>email:</td><td><%=request.getAttribute("email")%></td></tr>
        <tr><td>gender:</td><td><%=request.getAttribute("gender")%></td></tr>
        <tr><td>birthdate:</td><td><%=request.getAttribute("birthdate")%></td></tr>
    </table>
</div>
</body>
</html>

<%@include file="footer.jsp"%>

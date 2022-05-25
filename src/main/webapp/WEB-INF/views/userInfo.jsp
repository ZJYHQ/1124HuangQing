<%@ page import="com.HuangQing.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 15392
  Date: 2022/3/30
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>UsrInfo</title>
</head>
<body>
<div style="text-align: center;">
    <h1> User Info </h1>
    <%
        User usr = (User) request.getAttribute("user");
        if(request.getAttribute("update") != null) {
            usr = (User) request.getAttribute("user");
        } else {
            usr = (User) session.getAttribute("user");
        }
    %>
    <table border="1" cellpadding="3" cellspacing="0" style="width: 60%;margin:auto">
        <tr><td>ID:</td><td><%=usr.getID()%></td></tr>
        @@ -25,7 +30,11 @@
        <tr><td>email:</td><td><%=usr.getEmail()%></td></tr>
        <tr><td>gender:</td><td><%=usr.getGender()%></td></tr>
        <tr><td>birthdate:</td><td><%=usr.getBirthdate()%></td></tr>
        <tr>
            <a href="updateUser"> Update your message</a>
        </tr>
    </table>

</div>
</body>
</html>
<%@include file="footer.jsp"%>
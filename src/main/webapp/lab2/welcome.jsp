<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome,

    <%--todo 9 : use jsp:useBean to access the same instance of login bean from request scope--%>
    <jsp:useBean id="Login" scope="request" class="com.HuangQing.Lab2.login"/>
    <%--todo 10 : use jsp:getProperty to display username --%>
    <jsp:getProperty name="Login" property="username" />
</h2>
</body>
</html>

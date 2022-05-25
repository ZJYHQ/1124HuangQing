<%--
  Created by IntelliJ IDEA.
  User: ZJY
  Date: 2022/5/18
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>New User Registration</h1>
<form action="/HuangQing_war_exploded/MyDearJsp"  method="post">
    <label>
        name:
        <input type="text"
               name="name">
    </label>
    <br>

    <label>
        class:
        <input type="text" name="class">
    </label>
    <br>

    <label>
        ID:
        <input type="text" name="ID">
    </label>
    <br>


    <input type="submit" value="Send data to sever" onclick="onk()">

</form>
</body>
</html>

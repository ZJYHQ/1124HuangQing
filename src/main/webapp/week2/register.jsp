<%--
  Created by IntelliJ IDEA.
  User: ZJY
  Date: 2022/3/8
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

    <h1>New User Registration</h1>
    <form action="/register"  method="post">
        Username:
        <input type="text"
               name="username">
        <br>

        Password:
        <input type="password" name="password">
        <br>

        Email:
        <input type="text" name="email">
        <br>

        Gender
        <input type="checkbox" name="gender"  >Male
        <input type="checkbox" name="gender"  >Female
        <br>

        Date of Birth(yyyy-mm-dd):
        <input type="text" name="date">
        <br>

        <input type="submit" value="Register" onclick="onk()">

    </form>

<script type="text/javascript">
    //函数onk，在html中绑定
    function onk(){
        //id获取文档
        var user = document.getElementById("username").value;
        var pwd= document.getElementById("password").value;

        //判断用户名是否为空
        if(user.trim() == "" || pwd.trim() == ""){
            alert("用户和密码专不能为空");
            //判断用户名长度
        }else if(user.length < 8 || user.length > 24){
            alert("用户名长度是8---24位哦");
            //判断密码长度
        }else if(pwd.length < 8 || pwd.length > 16){
            alert("密码长度是6---16位哦");
        }
    }

    function check(obj) {
        $('.dept').attr('checked', false);//清空所有复选框
        $(obj).attr('checked', true);//给当前对象赋值
    }

</script>
</body>
</html>

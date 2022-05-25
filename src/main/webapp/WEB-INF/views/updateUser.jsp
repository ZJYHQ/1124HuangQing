<%@ page import="com.HuangQing.model.User" %><%--
  Created by IntelliJ IDEA.
  User: ZJY
  Date: 2022/5/26
  Time: 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1> User Update </h1>

<%
    User usr = (User) session.getAttribute("user");
%>

<form method="post" action="updateUser">
    ID : <input type="text" name="ID" value="<%=usr.getID()%>"/> <br/>
    Username: <input type="text" name="username" value="<%=usr.getName()%>"/><br/>
    Password: <input type="password" name="password" value="<%=usr.getPassword()%>"/><br/>
    Email: <input type="text" name="email" value="<%=usr.getEmail()%>"/><br>

    Gender: <input type="radio" name="gender" value="male"<%=usr.getGender().equals("male") ? "checked" : ""%>" />男
    <input type="radio" name="gender" value="fmale"<%=usr.getGender().equals("fmale") ? "checked" : ""%>"/>女<br/>

    Birthdate: <input type="text name=" name="Birthdate" value="<%=usr.getBirthdate()%>"/><br/>
    <input type="submit" value="Update"/>
</form>

<%@include file="footer.jsp"%>
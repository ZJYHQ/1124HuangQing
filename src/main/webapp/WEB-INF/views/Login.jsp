<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div style="text-align: center;">
    <h2>Login</h2>
    <%
        if(!(request.getAttribute("message") == null)) {
            out.println(request.getAttribute("message"));
        }
    %>
    <form method="post" action="login">
        ID : <input type="text" name="ID" /> <br/>
        Password: <input type="password" name="password"/><br/>
        <input type="submit" value="Login"/>
    </form>
</div>
<%@include file="footer.jsp"%>

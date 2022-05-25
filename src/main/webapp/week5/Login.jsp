<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div style="text-align: center;">
    <b>Login</b>
    <h2>Login</h2>
    <%
        if(!(request.getAttribute("message") == null)) {
            PrintWriter writer = response.getWriter();
            writer.println(
                    "<h2>" + request.getAttribute("message") + "</h2>"
            );
        }
    %>
    <form method="post" action="login">
        ID : <input type="text" name="ID" /> <br/>
        Password: <input type="password" name="password"/><br/>
        <input type="submit" value="Login"/>
    </form>
</div>
<%@include file="footer.jsp"%>


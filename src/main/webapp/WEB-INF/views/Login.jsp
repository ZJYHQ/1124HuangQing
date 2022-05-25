<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div style="text-align: center;">
    <h2>Login</h2>
    <%
        if(!(request.getAttribute("message") == null)) {
            out.println(request.getAttribute("message"));
        }
    %>
    <%
        Cookie[] allCooikes = request.getCookies();
        String username="", passowrd="", rememberMe="";
        if(allCooikes!=null) {
            for (Cookie c : allCooikes) {
                if(c.getName().equals("cUsername")) {
                    username = c.getValue();
                }
                if(c.getName().equals("cpassword")) {
                    passowrd = c.getValue();
                }
                if(c.getName().equals("crememberMe")) {
                    rememberMe = c.getValue();
                }
            }
        }
    %>
    <form method="post" action="login">
        ID : <input type="text" name="ID" /> <br/>
        Password: <input type="password" name="password"/><br/>
        ID : <input type="text" name="ID" value="<%=username%>"/> <br/>
        Password: <input type="password" name="password" value="<%=passowrd%>"/><br/>
        <input type="checkbox" name="rememberMe" value="1" <%= rememberMe.equals("1") ? "checked": "" %>checked/> RememberMe <br/>
        <input type="submit" value="Login"/>
    </form>
</div>
<%@include file="footer.jsp"%>

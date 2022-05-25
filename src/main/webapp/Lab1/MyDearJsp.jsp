<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using java code in jsp or EL </title>
</head>
<body>
<%--Use Java code--%>
<%--    <%--%>
<%--        String Name = request.getParameter("name");--%>
<%--        String Class = request.getParameter("Class");--%>
<%--        String ID = request.getParameter("ID");--%>
<%--    %>--%>
<%--    <p>name: <%=Name%></p>--%>
<%--    <p>Class: <%=Class%></p>--%>
<%--    <p>ID: <%=ID%></p>--%>
<%--Use EL--%>
<p>name: ${param.name}</p>
<p>Class ${param.Class}</p>
<p>ID: ${param.ID}</p>
</body>
</html>
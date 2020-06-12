<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/6
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>getSession</title>
</head>
<body>
    <%
        String name= (String) session.getAttribute("name");
    %>
session中的name：<%=name%>
</body>
</html>

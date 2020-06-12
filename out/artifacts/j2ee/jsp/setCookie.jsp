<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/6
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>setCookie</title>
</head>
<body>
    <%
        Cookie cookie=new Cookie("name","gareen");
        cookie.setMaxAge(60*24*60);
        cookie.setPath("/");
        response.addCookie(cookie);
    %>
    <a href="getCookie.jsp">跳转到获取cookie的页面</a>
</body>
</html>

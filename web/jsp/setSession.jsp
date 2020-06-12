<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/6
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>setSession</title>
</head>
<body>
<%
    session.setAttribute("name", "teemo");
%>

<a href="<%=response.encodeURL("getSession.jsp")%>">跳转到获取session的页面</a>
</body>
</html>

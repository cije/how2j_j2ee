<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/31
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jump</title>
</head>
<body>
<%--客户端跳转--%>
<%--
    <%
        response.sendRedirect("hello.jsp");
    %>
--%>
<%-- 服务端跳转 --%>
<!-- request.getRequestDispatcher("hello.jsp").forward(request, response);相当于jsp:forward-->
<jsp:forward page="hello.jsp"></jsp:forward>
</body>
</html>

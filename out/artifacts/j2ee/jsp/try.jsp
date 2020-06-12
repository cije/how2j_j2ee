<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/6
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="catch.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>exception 对象只有当前页面的@page 指令设置为isErrorPage="true"的时候才可以使用。
<br/>
    同时，在其他页面也需要设置 @page 指令 errorPage="" 来指定一个专门处理异常的页面。
</p>
<%
    int[] a = new int[10];
    a[20] = 5;
%>
</body>
</html>

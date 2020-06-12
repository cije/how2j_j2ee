<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/6
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>setContent</title>
</head>
<body>
<p>JSP有4个作用域，分别是<br/>
    pageContext 当前页面<br/>
    requestContext 一次请求<br/>
    sessionContext 当前会话<br/>
    applicationContext 全局，所有用户共享
</p>
<br/>
pageContext表示当前页面作用域,通过pageContext.setAttribute(key,value)的数据，只能在当前页面访问，在其他页面就不能访问了。<br/>
<%
    pageContext.setAttribute("pageContext","gareen");
%>
requestContext 表示一次请求。随着本次请求结束，其中的数据也就被回收。<br/>
<%
    request.setAttribute("requestContext","gareen");
%>
</body>
</html>

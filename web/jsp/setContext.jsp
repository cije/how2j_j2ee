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
    &nbsp;&nbsp;pageContext 当前页面<br/>
    &nbsp;&nbsp;requestContext 一次请求<br/>
    &nbsp;&nbsp;sessionContext 当前会话<br/>
    &nbsp;&nbsp;applicationContext 全局，所有用户共享
</p>
<br/>
<p><b>pageContext</b>表示当前页面作用域,通过pageContext.setAttribute(key,value)的数据，只能在当前页面访问，在其他页面就不能访问了。</p>
<%
    pageContext.setAttribute("pageContext", "gareen");
%>
<p><b>requestContext </b>表示一次请求。随着本次请求结束，其中的数据也就被回收。 服务端跳转 <%-- <jsp:forward page="getContext.jsp"/> --%>也是一次请求。页面间客户端跳转的情况下，是无法通过request传递数据的<br/></p>
<%
    request.setAttribute("requestContext", "gareen");
%>
<%--<jsp:forward page="getContext.jsp"></jsp:forward>--%>
<p><b>sessionContext</b>指的是会话，从一个用户打开网站的那一刻起，无论访问了多少网页，链接都属于同一个会话，直到浏览器关闭。

    所以页面间传递数据，也是可以通过session传递的。

    但是，不同用户对应的session是不一样的，所以session无法在不同的用户之间共享数据。</p>
<%
    session.setAttribute("sessionContext", "gareen");
%>
<p><b>applicationContext</b> 指的是全局，所有用户共享同一个数据

    在JSP中使用application对象， application对象是ServletContext接口的实例
    也可以通过 request.getServletContext()来获取。
    所以 application == request.getServletContext() 会返回true
    application映射的就是web应用本身。</p>
<%
    application.setAttribute("applicationContext", "gareen");
%>
<a href="getContext.jsp">getContext</a>
</body>
</html>

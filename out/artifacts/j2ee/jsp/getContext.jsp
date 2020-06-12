<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/6
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getContent</title>
</head>
<body>
pageContext.getAttribute("pageContext"):<%=pageContext.getAttribute("pageContext")%><br/>
request.getAttribute("requestContext")：<%=request.getAttribute("requestContext")%><br/>
session.getAttribute("sessionContext")：<%=session.getAttribute("sessionContext")%><br/>
application.getAttribute("applicationContext")：<%=application.getAttribute("applicationContext")%>
</body>
</html>

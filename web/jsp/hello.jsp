<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/31
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
你好 JSP <%=LocalDate.now()%>
<%-- 指令include  footer.jsp的内容会被插入到 hello.jsp 转译 成的hello_jsp.java中，最后只会生成一个hello_jsp.java文件
--%>
<%--<%@include file="footer.jsp"%>--%>

<%--动作 include
footer.jsp的内容不会被插入到 hello.jsp 转译 成的hello_jsp.java中，还会有一个footer_jsp.java独立存在。 hello_jsp.java 会在服务端访问footer_jsp.java,然后把返回的结果，嵌入到响应中。 --%>
<jsp:include page="footer.jsp">
    <jsp:param name="year" value="2020"/>
</jsp:include>
</body>
</html>

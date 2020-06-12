<%@ page import="bean.Hero" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/8
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>EL表达式语言</title>
</head>
<body>
<c:set var="name" value="Teemo"/>
取值用EL只需要\${name}<br/>
通过标签获取name: <c:out value="${name}" /> <br>
通过 EL 获取name: ${name}<br/>
EL会按照从高到低的优先级顺序获取 pageContext>request>session>application<br/>
EL获取JavaBean的属性<br/>
\${hero.name} ，就会自动调用getName方法了<br/>
<%
    Hero hero=new Hero(1,"gareen",300,80);
    request.setAttribute("hero",hero);
%>
英雄的名字：${hero.name}<br/>
英雄的血量：${hero.hp}<br/>
EL表达式还可以做到request.getParameter("name") 这样的形式获取浏览器传递过来的参数<br/>
<a href="http://localhost:8080/j2ee/jsp/EL.jsp?hero=123">http://localhost:8080/j2ee/jsp/EL.jsp?hero=123</a>
${param.hero}<br/>
进行条件判断<br/>
<ul>
    <li>eq相等 ne、neq不相等</li>
    <li></li>gt大于， lt小</li>
    <li></li>gt大于， lt小</li>
    <li></li>gte、ge大于等</li>
    <li></li>lte、le 小于</li>
    <li>not非 mod求模</li>
    <li>is [not] div by是否能被某数整除</li>
    <li>is [not] even是否为偶数</li>
    <li>is [not] odd是否为奇</li>
</ul>
<%
    pageContext.setAttribute("killNumber",8);
%>
${killNumber eq 8?"超神":"未超神"}
</body>
</html>

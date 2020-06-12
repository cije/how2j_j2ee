<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/6
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<c:set var="name" value="${'gareen'}" scope="request"/>
相当于在作用域request中设置name,相当于request.setAttribute("name","gareen")<br/>
通过标签获取name：<c:out value="${'name'}"/><br/>
<!-- 相当于 request.getAttribute("name") -->

<c:remove var="name" scope="request"/> <br>

在作用域request中删掉name,相当于request.removeAttribute("name")<br/>
通过标签获取name: <c:out value="${name}"/> <br>
<br>

<p>
    JSTL通过c:if test="" 进行条件判断<br/>

    但是JSTL没有c:else，所以常用的办法是在c:if 的条件里取反<br/>
    配合if使用的还有通过empty进行为空判断<br/>
    empty可以判断对象是否为null,字符串长度是否为0，集合长度是否为0
</p>
<c:set var="hp" value="${10}" scope="request"/>
<c:if test="${hp<5}">
    <p>血量不足5，即将死亡</p>
</c:if>
<c:if test="${!(hp<5)}">
    <p>血量足够，还可以再战</p>
</c:if>
<%
    pageContext.setAttribute("weapon", null);
    pageContext.setAttribute("lastwords", "");
    pageContext.setAttribute("items", new ArrayList<>());
%>
<c:if test="${empty weapon}">
    <p>没有装备武器</p>
</c:if>
<c:if test="${empty lastwords}">
    <p>挂了也没有遗言</p>
</c:if>
<c:if test="${empty items}">
    <p>物品栏为空</p>
</c:if>
<c:set var="hp1" value="${3}" scope="request"/>
<c:choose>
    <c:when test="${hp1<5}">
        <p>杨文超血量小于5</p>
    </c:when>
    <c:otherwise>
        <p>杨文超</p>
    </c:otherwise>
</c:choose>
<p>
    c:foreach标签
</p>
<%
    List<String> heros = new ArrayList<>();
    heros.add("爱丽丝");
    heros.add("德莉莎");
    heros.add("奥丽莎");
    request.setAttribute("heros", heros);
%>
使用jsp中的for循环来遍历List
<table width="200px" align="center" border="1" cellspacing="0">
    <tr>
        <td>编号</td>
        <td>英雄</td>
    </tr>
        <%
        int i=0;
        for (String hero : heros) {
            i++;

        %>
    <tr>
        <td><%=i%>
        </td>
        <td><%=hero%>
        </td>
    </tr>
        <%}%>
    <table/>
    <br/>
使用jstl的foreach
    <table width="200px" align="center" border="1" cellspacing="0">
        <tr>
            <td>编号</td>
            <td>英雄</td>
        </tr>
        <c:forEach items="${heros}" var="hero" varStatus="st">
            <tr>
                <td>
                    <c:out value="${st.count}"/>
                </td>
                <td>
                    <c:out value="${hero}"/>
                </td>
            </tr>
        </c:forEach>
        <table/>
        c:forTokens专门用于字符串拆分，并且可以指定多个分隔符<br/>
        <c:set var="heros1" value="塔姆,艾克;巴德|雷克塞!卡莉斯塔"/>
        <c:forTokens items="${heros1}" delims=":;|!" var="hero">
            <c:out value="${hero}"/><br/>
        </c:forTokens>
        fmt 标签常用来进行格式化，其中fmt:formatNumber用于格式化数字<br/>
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <c:set var="money" value="888.8"/>
        <c:set var="pi" value="3.1415926"/>
        最少两位小数点<br/>
        <fmt:formatNumber type="number" value="${money}" minFractionDigits="2"/>
        <br/>
        最多两个小数点<br/>
        <fmt:formatNumber type="number" value="${pi}" maxFractionDigits="2"/><br/>
        fmt:formatDate 用于格式化日期<br/>
          <ul>
              <li>yyyy 表示年份</li>
              <li>MM 表示月份</li>
              <li>dd 表示日期</li>
              <li> E 表示星期几</li>
              <li>a 表示是上午还是下午</li>
              <li>HH 表示小时</li>
              <li>mm 表示分钟</li>
              <li>ss 表示秒</li>
              <li>S 表示毫秒</li>
              <li>z 表示时区</li>
          </ul>
        <%
            Date now=new Date();
            pageContext.setAttribute("now",now);
            %>
        完整日期：<fmt:formatDate value="${now}" pattern="G yyyy年MM月dd日 E"/><br/>
        完整时间：<fmt:formatDate value="${now}" pattern="a HH:mm:ss.S z"/><br/>
        常见格式：<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/><br/>
        <br/>
        fn标签提供各种实用功能，首先使用之前使用加入如下指令<br/>
        @ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"<br/>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <table align="center" border="1" cellspacing="0">
            <tbody>
            <tr>
                <td><strong>函数</strong></td>
                <td><strong>描述</strong></td>
            </tr>
            <tr>
                <td><p>fn:contains(string, substring)</p></td>
                <td><p>如果参数string中包含参数substring，返回true</p></td>
            </tr>
            <tr>
                <td><p>fn:containsIgnoreCase(string, substring)</p></td>
                <td><p>如果参数string中包含参数substring（忽略大小写），返回true</p></td>
            </tr>
            <tr>
                <td><p>fn:endsWith(string, suffix)</p></td>
                <td><p>如果参数 string 以参数suffix结尾，返回true</p></td>
            </tr>
            <tr>
                <td><p>fn:escapeXml(string)</p></td>
                <td><p>将有特殊意义的XML (和HTML)转换为对应的XML character entity code，并返回</p></td>
            </tr>
            <tr>
                <td><p>fn:indexOf(string, substring)</p></td>
                <td><p>返回参数substring在参数string中第一次出现的位置</p></td>
            </tr>
            <tr>
                <td><p>fn:join(array, separator)</p></td>
                <td><p>将一个给定的数组array用给定的间隔符separator串在一起，组成一个新的字符串并返回。</p></td>
            </tr>
            <tr>
                <td><p>fn:length(item)</p></td>
                <td><p>返回参数item中包含元素的数量。参数Item类型是数组、collection或者String。如果是String类型,返回值是String中的字符数。</p></td>
            </tr>
            <tr>
                <td><p>fn:replace(string, before, after)</p></td>
                <td><p>返回一个String对象。用参数after字符串替换参数string中所有出现参数before字符串的地方，并返回替换后的结果</p></td>
            </tr>
            <tr>
                <td><p>fn:split(string, separator)</p></td>
                <td><p>返回一个数组，以参数separator 为分割符分割参数string，分割后的每一部分就是数组的一个元素</p></td>
            </tr>
            <tr>
                <td><p>fn:startsWith(string, prefix)</p></td>
                <td><p>如果参数string以参数prefix开头，返回true</p></td>
            </tr>
            <tr>
                <td><p>fn:substring(string, begin, end)</p></td>
                <td><p>返回参数string部分字符串, 从参数begin开始到参数end位置，包括end位置的字符</p></td>
            </tr>
            <tr>
                <td><p>fn:substringAfter(string, substring)</p></td>
                <td><p>返回参数substring在参数string中后面的那一部分字符串</p></td>
            </tr>
            <tr>
                <td><p>fn:substringBefore(string, substring)</p></td>
                <td><p>返回参数substring在参数string中前面的那一部分字符串</p></td>
            </tr>
            <tr>
                <td><p>fn:toLowerCase(string)</p></td>
                <td><p>将参数string所有的字符变为小写，并将其返回</p></td>
            </tr>
            <tr>
                <td><p>fn:toUpperCase(string)</p></td>
                <td><p>将参数string所有的字符变为大写，并将其返回</p></td>
            </tr>
            <tr>
                <td><p>fn:trim(string)</p></td>
                <td><p>去除参数string 首尾的空格，并将其返回</p></td>
            </tr>
            </tbody>
        </table>

        <c:set var="testStr" value=" asa sa sae "/>
        <c:out value="${fn:length(testStr)}"/><br/>
        <c:out value="${fn:trim(testStr)}"/><br/>
        <c:out value="${fn:length(fn:trim(testStr))}"/><br/>
        <c:out value="${fn:toUpperCase(testStr)}"/><br/>
</body>
</html>

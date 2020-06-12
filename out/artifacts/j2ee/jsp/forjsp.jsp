<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/31
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>forjsp</title>
</head>
<body>
<%
    List<String> list=new ArrayList<>();
    list.add("tody");
    list.add("is");
    list.add("a");
    list.add("great");
    list.add("day");
%>
<table  width="200px" align="center" border="1" cellspacing="0">
    <%for (String s : list) { %>
    <tr>
        <td><%=s%></td>
    </tr>
    <%};%>
</table>
</body>
</html>

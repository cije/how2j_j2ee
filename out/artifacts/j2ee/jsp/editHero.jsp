<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/6/8
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>editHero</title>
</head>
<body>
    <form action="updateHero" method="post">
        名字：<input type="text" name="name" value="${hero.name}"><br/>
        血量：<input type="text" name="hp" value="${hero.hp}"><br/>
        伤害：<input type="text" name="damage" value="${hero.damage}"><br/>
        <input type="hidden" name="id" value="${hero.id}"><br/>
        <input type="submit" value="更新">
    </form>
</body>
</html>

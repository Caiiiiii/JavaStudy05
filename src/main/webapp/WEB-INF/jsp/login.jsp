<%--
  Created by IntelliJ IDEA.
  User: CYQ
  Date: 2018/5/25
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 ${msg}
 <form action="${pageContext.request.contextPath}/login" method="post">
     用户名：<input type="text" name="username"> <br>
     密码：<input type="password" name="password"><br>
     <input type="submit" value="登录">
 </form>
</body>
</html>

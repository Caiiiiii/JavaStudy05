<%--
  Created by IntelliJ IDEA.
  User: CYQ
  Date: 2018/5/25
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    当前用户: ${USER_SESSION.username}
<a href="${pageContext.request.contextPath}/logout">退出</a>
</body>
</html>

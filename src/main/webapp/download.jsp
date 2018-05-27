<%--
  Created by IntelliJ IDEA.
  User: CYQ
  Date: 2018/5/27
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.net.URLEncoder" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/download?filename=<%=URLEncoder.encode("壁纸.jpg","UTF-8")%>">下载</a>

</body>
</html>

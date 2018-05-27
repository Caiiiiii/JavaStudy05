<%--
  Created by IntelliJ IDEA.
  User: CYQ
  Date: 2018/5/21
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <script src="/js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">

        function testJson() {
            var username = $("#username").val();
            var password = $("#password").val();
            $.ajax({
                url: "${pageContext.request.contextPath}/textJson",
                type:"post",
                data:JSON.stringify({username:username,password:password}),
                contentType:"application/json;charset=UTF-8",
                dataType:"json",
                success:function (data) {
                    if(data != null){
                        alert("您 输入的用户名为："+data.username+"密码为："+data.password);
                    }
                }
            });
          }

    </script>
</head>
<body>
     <form>
         用户名：<input type="text" name="username" id="username"><br />
         密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"> <br/>
         <input type="button" value="测试json交互" onclick=" testJson();" />
     </form>
</body>

</html>

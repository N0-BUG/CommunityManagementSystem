<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2022/12/3
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>昌盛社区管理系统注册</title>
    <style>
        body {
            background-color: skyblue;
        }

        #login {
            width: 300px;
            height: 350px;
            border: 1px solid;
            font-size: 20px;
            text-align: center;
            background-color: white;
            border: 5px lightslategray solid;
            border-radius: 10px 10px 0 0;
            padding-top: 35px;
            position: fixed;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);

        }

        .t1 {
            width: 240px;
            height: 35px;
            border-radius: 10px;
            font-family: 方正粗黑宋简体;
            font-size: 15px;
            border: 2px blue solid;
        }

        #register {
            float: left;
            margin-top: 10px;
            margin-left: 50px;
        }

        .text {
            margin-top: 20px;
            font-family: 幼圆;
            font-size: 20px;
        }

        #radio {
            margin-top: 15px;
            margin-left: 20px;
            font-family: 幼圆;
        }

        button {
            color: navy;
            width: 240px;
            height: 40px;
            font-size: 20px;
            font-family: 幼圆;
        }

    </style>
</head>
<body>
<div id="login">
    <form action="/SystemControl?method=register" method="post">
        <div id="head">在这里进行注册</div>
        <div class="text">账号:<input placeholder="用户名" class="t1" type="text" name="user_name"></div>
        <div class="text">密码:<input placeholder="自定义一个6位数字密码" class="t1" type="text" name="user_password">
        </div>
        <div id="radio"><input type="radio" name="user_ident" value="resident">居民
            <input type="radio" name="user_ident" value="manager">管理员
        </div>
        <div id="register">
            <button type="submit" onclick="alertTips()">注册</button>
        </div>
    </form>
</div>
</body>
</html>
<script>
    function alertTips() {
        if (confirm("注册成功，请返回首页登录！"))
            window.location.href = "/index.jsp"
    }
</script>
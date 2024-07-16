<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2022/12/4
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>联系我们</title>
    <style>
        body {
            background-color: skyblue;
        }

        #login {
            width: 1000px;
            height: 700px;
            border: 1px solid;
            font-size: 40px;
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

        #login ul li {
            font-size: 30px;
            list-style-type: none;
            padding-top: 20px;
            font-family: "微軟正黑體 Light";
            text-align: left;
        }

        button {
            font-size: 30px;
            font-family: 方正舒体;
            color: silver;
        }
    </style>
</head>
<body>
<div id="login">以下是各部门联系方式
    <div>
        <ul>
            <li>社区党群服务中心联系方式：<B>8888-9999-6660</B></li>
            <li>综合党委联系方式：<B>8888-9999-6661</B></li>
            <li>老年协会联系方式:<B>8888-9999-6662</B></li>
            <li>总工会联系方式：<B>8888-9999-6663</B></li>
            <li>文体所联系方式：<B>8888-9999-6664</B></li>
            <li>团委联系方式:<B>8888-9999-6665</B></li>
            <li>妇联联系方式：<B>8888-9999-6666</B></li>
        </ul>
        <div>
            <button><a href="index.jsp" style="text-decoration: none">返回首页</a></button>
        </div>
    </div>
</div>
</body>
</html>

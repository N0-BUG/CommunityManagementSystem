<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2022/12/17
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>楼宇信息添加</title>
    <style>
        #login {
            width: 500px;
            height: 450px;
            border: 1px solid;
            font-size: 20px;
            text-align: center;
            background-color: white;
            border: 5px lightslategray solid;
            border-radius: 10px 10px 0 0;
            padding-top: 35px;
            margin: auto;

        }

        .t1 {
            width: 240px;
            height: 35px;
            border-radius: 10px;
            font-family: 方正粗黑宋简体;
            font-size: 15px;
            border: 2px blue solid;
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
    <form action="/FloorControl?method=add" method="post">
        <div id="head">在这里添加楼宇信息</div>
        <div class="text">&nbsp&nbsp&nbsp&nbsp楼栋号:<input class="t1" type="text" name="floor_no"></div>
        <div class="text">楼栋管理员:<input class="t1" type="text" name="floor_manager"></div>
        <div class="text">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp户主:<input class="t1" type="text" name="floor_host"></div>
        <div class="text">户主门牌号:<input class="t1" type="text" name="floor_houseNumber"
                                            placeholder="请按（楼栋-楼层-门牌）输入"></div>
        <div class="text">楼栋总人数:<input class="t1" type="text" name="floor_sum"></div>
        <div id="register">
            <button type="submit">添加</button>
        </div>
    </form>
</div>
</body>
</html>
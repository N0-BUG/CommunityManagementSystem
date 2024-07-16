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
  <title>发布公告</title>
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

    #register {
      float: left;
      margin-top: 10px;
      margin-left: 180px;
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
  <form action="/NoticeControl?method=add" method="post">
    <div id="head">在这里发布公告</div>
    <div class="text">公告信息:<input class="t1" type="text" name="notice_info"></div>
    <div class="text">&nbsp&nbsp发布人:<input class="t1" type="text" name="notice_publisher"></div>
    <div class="text">发布时间:<input class="t1" type="text" name="notice_date" placeholder="请按（yyyy-mm-dd）输入"></div>
    <div id="register">
      <button type="submit">发布</button>
    </div>
  </form>
</div>
</body>
</html>
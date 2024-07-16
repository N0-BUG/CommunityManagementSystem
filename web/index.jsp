<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2022/12/1
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sql:setDataSource var="s" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost/CommunitySystem?serverTimezone=GMT%2B8" user="root" password="241372"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>社区管理系统首页</title>
    <style>
        body {
            background-image: url("/imag/2.jpg");
            background-size: 100%;
            opacity: 0.5;
            background-attachment: fixed;
            background-repeat: no-repeat;
            min-width: 1000px;
            min-height: 1000px;
        }

        #container {
            width: 1000px;
            margin: auto;
        }

        #logo {
            background-image: url("/imag/2.webp");
            background-size: 100px 100px;
            float: left;
            width: 100px;
            height: 100px;
            border-radius: 100%;
        }

        #top {
            width: 1000px;
            height: 100px;
        }

        #top_div1 {
            float: left;
            font-size: 31px;
            font-family: 方正舒体;
            opacity: 55%;
            margin-top: 30px;
            margin-left: 30px;
            color: whitesmoke;
        }

        #top_div2 {
            float: left;
            font-size: 26px;
            font-family: 方正舒体;
            opacity: 55%;
            margin-top: 40px;
            margin-left: 15px;
            color: yellow;
        }

        #nav {
            width: 1000px;
            height: 80px;
            background-color: ghostwhite;
            border-radius: 10px 10px 40px 40px;
            border: 5px deepskyblue solid;
        }

        #nav ul {
            margin: 0px;
            padding: 0px;
        }

        #nav ul li {
            float: left;
            font-size: 32px;
            list-style-type: none;
            line-height: 30px;
            text-align: center;
            margin-left: 150px;
            padding-top: 25px;
            font-family: 华文彩云;
        }

        #nav ul li a {
            text-decoration: none;
            color: orangered;
        }

        #nav ul li a:hover {
            scroll-behavior: smooth;
        }

        #login {
            width: 350px;
            height: 300px;
            border: 1px solid;
            float: left;
            font-size: 20px;
            text-align: center;
            background-color: white;
            border: 5px skyblue solid;
            border-radius: 40px 0 0 0;
        }

        .t1 {
            width: 240px;
            height: 35px;
            border-radius: 10px;
            font-family: 方正粗黑宋简体;
            font-size: 20px;
            border: 2px blue solid;
        }

        #sign {
            float: left;
            margin-left: 76px;
            margin-top: 30px;
        }

        #register {
            float: right;
            margin-right: 35px;
            margin-top: 10px;
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

        #sign input {
            color: navy;
            width: 80px;
            height: 30px;
            font-size: 20px;
            font-family: 幼圆;
        }

        button {
            color: navy;
            width: 80px;
            height: 30px;
            font-size: 20px;
            font-family: 幼圆;
        }

        #head {
            background-color: cornflowerblue;
            text-align: center;
            margin-left: 53px;
            padding-top: 20px;
            width: 250px;
            height: 50px;
            font-size: 25px;
            font-family: 方正舒体;
            border-radius: 0 0 30px 30px;
        }

        #message {
            width: 628px;
            height: 300px;
            float: right;
            background-color: cornflowerblue;
            font-size: 40px;
            border: 5px limegreen solid;
            border-radius: 0 40px 0 0;
            font-family: "等线 Light";
            overflow: auto;

        }

        #message_logo {
            background-image: url("/imag/6.webp");
            background-size: 100%;
            width: 50px;
            height: 50px;
            border-radius: 100%;
            float: left;
            margin-left: 200px;
            margin-top: 5px;
        }

        #message_title {
            padding-top: 8px;
        }

        #message_tabel {
            width: 590px;
            height: auto;
            float: left;
            margin-left: 18px;
            font-size: 25px;
            text-align: center;
            font-family: 方正姚体;
            padding-top: 5px;
        }

        #message_tabel tr th {
            width: auto;
        }

        #message_tabel tr td {
            padding-top: 10px;
            width: auto;
        }

        #clear {
            clear: both;
        }

        #notice {
            width: 990px;
            text-align: left;
            font-size: 35px;
            font-family: 幼圆;
            background-color: white;
            height: 600px;
            border: 5px skyblue dashed;
            overflow: auto;
        }

        #notice_logo {
            width: 55px;
            height: 50px;
            background-image: url("/imag/7.webp");
            background-size: 100%;
            float: left;
            text-align: center;
            margin-left: 400px;
            padding-top: 5px;
        }

        #notice_title {
            float: left;
            padding-top: 10px;
        }

        #notice_tabel {
            width: 970px;
            height: auto;
            float: left;
            font-size: 28px;
            text-align: center;
            font-family: 方正姚体;
            padding-top: 5px;
        }

        #notice_tabel tr th {
            width: auto;
            padding-top: 10px;
        }

        #notice_tabel tr td {
            padding-top: 18px;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="top">
        <div id="logo"></div>
        <div id="top_div1">昌&nbsp;盛&nbsp;社区&nbsp;&nbsp&nbsp管&nbsp;理&nbsp;系&nbsp;统</div>&nbsp;
        <div id="top_div2">ChangSheng&nbspCommunity&nbsp&nbspManagement&nbspSystem</div>&nbsp;
    </div>
    <div id="nav">
        <ul>
            <li><a href="index.jsp">首页</a></li>
            <li>&nbsp&nbsp&nbsp&nbsp</li>
            <li><a href="contact.jsp">联系我们</a></li>
        </ul>
    </div>
    <div id="message">
        <div id="message_logo"></div>
        <div id="message_title"><b>留言板</b></div>
        <div>
            <sql:query var="result_message" dataSource="${s}" sql="select * from message"/>
            <table id="message_tabel">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>留言信息</th>
                    <th>留言人</th>
                    <th>时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="row" items="${result_message.rows}">
                    <tr>
                        <td><c:out value="${row.message_index}"/></td>
                        <td><c:out value="${row.message_info}"/></td>
                        <td><c:out value="${row.message_publisher}"/></td>
                        <td><c:out value="${row.message_date}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div id="login">
        <div id="head">欢迎登录社区管理系统</div>
        <form method="post" action="/login">
            <div class="text">账号:<input required placeholder="请输入你的用户名" class="t1" type="text"
                                          name="user_name"></div>
            <div class="text">密码:<input required placeholder="请输入密码" class="t1" type="text" name="user_password">
            </div>

            <div id="radio"><input required type="radio" name="user_ident" value="resident">居民
                <input required type="radio" name="user_ident" value="manager">管理员
            </div>
            <div id="sign">
                <input type="submit" value="登录">
            </div>
        </form>
        <div id="register">
            <button class="button" onclick=window.location.href="/register.jsp">注册</button>
        </div>
    </div>
    <div id="clear"></div>
    <div id="notice">
        <div id="notice_logo"></div>
        <div id="notice_title"><b>公告栏</b></div>
        <div>
            <sql:query var="result_notice" dataSource="${s}" sql="select * from notice"/>
            <table id="notice_tabel">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>公告信息</th>
                    <th>发布人</th>
                    <th>时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="row" items="${result_notice.rows}">
                    <tr>
                        <td><c:out value="${row.notice_index}"/></td>
                        <td><c:out value="${row.notice_info}"/></td>
                        <td><c:out value="${row.notice_publisher}"/></td>
                        <td><c:out value="${row.notice_date}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
<script>
    const error = '<%=request.getParameter("error")%>';
    if (error === "user_nameError") {
        alert("账号错误或该账号不存在,请重新登录或进行注册！")
    }
    if (error === "user_identError") {
        alert("该账号与身份信息不匹配！")
    }
    if (error === "user_passwordError") {
        alert("用户名或密码错误,请重新登录！")
    }
</script>
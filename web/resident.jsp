<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2022/12/4
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>居民中心</title>
    <style>
        #container {
            width: 100%;
            height: 100%;
            min-height: 1000px;
            min-width: 1000px;
        }

        #logo {
            background-image: url("/imag/2.webp");
            background-size: 100px 100px;
            float: left;
            width: 100px;
            height: 100px;
            border-radius: 100%;
            margin-left: 20px;
        }

        #title_l {
            font-size: 30px;
            color: whitesmoke;
            margin-left: 50px;
            font-family: 幼圆;
            float: left;
            padding-top: 30px;
        }

        #title_r {
            font-size: 30px;
            color: whitesmoke;
            margin-right: 150px;
            font-family: 幼圆;
            float: right;
            padding-top: 30px;
        }

        #title_r1 {
            font-size: 30px;
            color: whitesmoke;
            margin-right: -300px;
            font-family: 幼圆;
            float: right;
            padding-top: 20px;
        }

        #title_r1 button {
            width: 110px;
            height: 50px;
            font-family: 方正姚体;
            font-size: 21px;
        }

        #title_back {
            width: 100%;
            height: 100px;
            background-color: skyblue;
            border: 1px solid;
            z-index: -1;
        }

        #left {
            height: 300px;
            width: 200px;
            float: left;
        }

        #right {
            height: 100%;
            width: 1200px;
            float: right;
        }

        #ltable {
            border: 1px black solid;
            width: 230px;
            height: 350px;
            background: white;
            border-collapse: collapse;
            text-align: center;

        }

        #ltable td {
            border: 2px black solid;

        }

        #ltable button {
            width: 230px;
            height: 100px;
            font-family: 隶书;
            font-size: 30px;
            color: orange;
        }

        #table table {
            text-align: center;
            font-size: 25px;
            text-space: 15px;
            font-family: 方正舒体;
            width: 1200px;
            height: auto;
            border: 2px skyblue solid;
            border-radius: 5px;
        }

        #table table tr {
            padding-top: 15px;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="logo"></div>
    <div id="title_l">社区管理系统—居民中心</div>
    <%
        String user_name = (String) request.getSession().getAttribute("user_name");
    %>
    <div id="title_r">欢迎你：<%=user_name%>
    </div>
    <div id="title_r1">
        <button><a href="<c:url value="/index.jsp"/>" style="text-decoration: none">退出登录</a></button>
    </div>
    <div id="title_back"></div>
    <div id="left">
        <table id="ltable">
            <tr>
                <td>
                    <button onclick="managerControl()">管理员一览</button>
                </td>
            </tr>
            <tr>
                <td>
                    <button onclick="messageControl()">留言板一览</button>
                </td>
            </tr>
            <tr>
                <td>
                    <button onclick="noticeControl()">公告一览</button>
                </td>
            </tr>
        </table>
    </div>
    <div id="right">
        <div>
            <iframe style="width:1200px;height: 100%" id="myFrame" src="/ManagerControl?method=list"></iframe>
        </div>
    </div>
</div>
</body>
</html>
//各功能对应页面
<script>
    function managerControl() {
        document.getElementById('myFrame').src = "/ManagerControl?method=list";
    }

    function messageControl() {
        document.getElementById('myFrame').src = "/ResidentMessageControl?method=list";
    }

    function noticeControl() {
        document.getElementById('myFrame').src = "/ResidentNoticeControl?method=list";
    }

</script>
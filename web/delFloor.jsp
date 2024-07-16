<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2022/12/17
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sql:setDataSource var="s" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost/CommunitySystem?serverTimezone=GMT%2B8" user="root" password="241372"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>楼宇信息删除</title>
    <style>
        #login {
            width: 520px;
            height: 300px;
            border: 1px solid;
            font-size: 20px;
            text-align: center;
            background-color: white;
            border: 5px lightslategray solid;
            border-radius: 10px 10px 0 0;
            padding-top: 35px;
            margin: auto;

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

        .t1 {
            width: 200px;
            height: 35px;
            border-radius: 10px;
            font-family: 方正粗黑宋简体;
            font-size: 15px;
            border: 2px blue solid;
        }

        button {
            margin-top: 10px;
            color: navy;
            width: 85px;
            height: 35px;
            font-size: 25px;
            font-family: 幼圆;
            cursor: pointer;

        }

    </style>
</head>
<body>
<%--接收回填信息--%>
<sql:query var="result" dataSource="${s}" sql="select *from floor where floor_index='${param.floor_index}'"/>
<div id="login">
    <form action="/FloorControl?method=del" method="post">
        <c:forEach var="row" items="${result.rows}">
            <div class="text">你确定要删除以下对象的信息吗？</div>
            <div class="text">&nbsp&nbsp序号:<input class="t1" type="text" name="floor_index" readonly
                                                    value="${row.floor_index}"></div>
            <div class="text">楼栋号:<input class="t1" type="text" name="floor_no" readonly value="${row.floor_no}">
            </div>
        </c:forEach>
        <div id="register">
            <button type="submit" style="background-color: red">删除</button>
            <a href="/FloorControl?method=list" style="text-decoration: none">
                <button type="button">取消</button>
            </a>
        </div>
    </form>
</div>
</body>
</html>


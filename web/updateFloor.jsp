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
    <title>楼宇信息修改</title>
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
<%--接收回填信息--%>
<sql:query var="result" dataSource="${s}" sql="select *from floor where floor_index='${param.floor_index}'"/>
<div id="login">
    <form action="/FloorControl?method=update" method="post">
        <div id="head">在这里修改楼宇信息</div>
        <c:forEach var="row" items="${result.rows}"> <%--考虑到对序号不做更新，设置为只读readonly--%>
            <div class="text">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp序号:<input class="t1" type="text" name="floor_index"
                                                                        readonly value="${row.floor_index}"></div>
            <div class="text">&nbsp&nbsp&nbsp&nbsp楼栋号:<input class="t1" type="text" name="floor_no"
                                                                value="${row.floor_no}"></div>
            <div class="text">楼栋管理员:<input class="t1" type="text" name="floor_manager"
                                                value="${row.floor_manager}"></div>
            <div class="text">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp户主:<input class="t1" type="text" name="floor_host"
                                                                        value="${row.floor_host}"></div>
            <div class="text">户主门牌号:<input class="t1" type="text" name="floor_houseNumber"
                                                value="${row.floor_houseNumber}"></div>
            <div class="text">楼栋总人数:<input class="t1" type="text" name="floor_sum" value="${row.floor_sum}"></div>
        </c:forEach>
        <div id="register">
            <button type="submit">修改</button>
        </div>
    </form>
</div>
</body>
</html>


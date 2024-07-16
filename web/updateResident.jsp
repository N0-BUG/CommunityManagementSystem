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
    <title>居民信息修改</title>
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
<sql:query var="result" dataSource="${s}" sql="select *from resident where resident_index='${param.resident_index}'"/>
<div id="login">
    <form action="/SystemControl?method=resident_update" method="post">
        <div id="head">在这里修改居民信息</div>
        <c:forEach var="row" items="${result.rows}"> <%--考虑到对序号不做更新，设置为只读readonly--%>
            <div class="text">&nbsp&nbsp&nbsp&nbsp序号:<input class="t1" type="text" name="resident_index" readonly
                                                              value="${row.resident_index}"></div>
            <div class="text">居民姓名:<input class="t1" type="text" name="resident_name" value="${row.resident_name}">
            </div>
            <div class="text">居民电话:<input class="t1" type="text" name="resident_phone"
                                              value="${row.resident_phone}"></div>
            <div class="text">居民门牌:<input class="t1" type="text" name="resident_houseNumber"
                                              value="${row.resident_houseNumber}"></div>
            <div id="radio"><input type="radio" name="resident_gender" value="男" <c:if
                    test="${row.resident_gender=='男'}"> checked="checked"</c:if>>男
                <input type="radio" name="resident_gender" value="女" <c:if test="${row.resident_gender=='女'}">
                       checked="checked"</c:if>>女
            </div>
        </c:forEach>
        <div id="register">
            <button type="submit">修改</button>
        </div>
    </form>
</div>
</body>
</html>


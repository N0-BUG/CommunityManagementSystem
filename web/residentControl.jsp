<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 666
  Date: 2022/12/16
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>residentControl</title>
    <style>
        #table table {
            text-align: center;
            font-size: 25px;
            text-space: 15px;
            font-family: 方正姚体;
            width: 1200px;
            height: auto;
            border-radius: 5px;
            padding-top: 50px;
        }

        #table table tr {
            padding-top: 15px;
        }

        #add_button {
            width: 145px;
            height: 50px;
            float: left;
            font-family: 方正舒体;
            font-size: 20px;
            margin-left: 15px;
            text-align: center;
            margin-top: 15px;
            cursor: pointer;
        }

        #update_button {
            font-family: 隶书;
            width: auto;
            height: auto;
            font-size: 20px;
            cursor: pointer;
        }

        #del_button {
            font-family: 隶书;
            background-color: red;
            width: auto;
            height: auto;
            font-size: 20px;
            cursor: pointer;
        }

        #right {
            width: 1180px;
            height: 100px;
            background-color: whitesmoke;
            border: 2px skyblue solid;
            border-radius: 5px;
            margin-top: 5px;
            margin-right: -5px;
            float: right;
        }

        #right input {
            width: 180px;
            height: 30px;
            border: 2px skyblue solid;
            border-radius: 5px;
        }

        #right_text1 {
            float: left;
            margin-top: 30px;
            text-align: center;
            font-size: 25px;
            font-family: 方正舒体;
        }

        #right_button {
            width: 90px;
            height: 40px;
            color: darkcyan;
            float: left;
            margin-left: 50px;
            font-family: 幼圆;
            margin-top: 25px;
            font-size: 30px;
            cursor: pointer;
        }

        #right_text2 {
            float: left;
            margin-left: 50px;
            margin-top: 30px;
            text-align: center;
            font-size: 20px;
            font-family: 方正舒体;
        }
    </style>
</head>
<div id="right">
    <form method="post" action="/SystemControl?method=resident_search">
        <div id="right_text1">查询字段:
            <select name="key" style="width: 100px;height: 30px">
                <option value="resident_name">居民姓名</option>
                <option value="resident_phone">居民电话</option>
                <option value="resident_houseNumber">居民门牌号</option>
            </select></div>
        <div id="right_text2"><input name="value" value="" type="text" placeholder="字段值"></div>
        <div>
            <button type="submit" id="right_button">搜索</button>
            <button id="add_button" type="button" onclick="add()">添加居民信息</button>
        </div>
    </form>
    <div id="table">
        <table>
            <thead>
            <tr>
                <th>序号</th>
                <th>居民姓名</th>
                <th>居民电话</th>
                <th>居民门牌号</th>
                <th>居民性别</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="Resident">
                <tr>
                    <td>${Resident.resident_index}</td>
                    <td>${Resident.resident_name}</td>
                    <td>${Resident.resident_phone}</td>
                    <td>${Resident.resident_houseNumber}</td>
                    <td>${Resident.resident_gender}</td>
                    <td>
                        <a href="/updateResident.jsp?resident_index=${Resident.resident_index}"
                           style="text-decoration: none">
                            <button type="submit" id="update_button">
                                修改
                            </button>
                        </a>
                        <a href="/delResident.jsp?resident_index=${Resident.resident_index}"
                           style="text-decoration: none">
                            <button type="submit" id="del_button">
                                删除
                            </button>
                        </a>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
<script>
    function add() {
        window.location.href = "/addResident.jsp";
    }
</script>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("basePath", pageContext.getServletContext().getContextPath());
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath}/jQuery/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".deleteA").click(function () {
                $("#deleteForm").attr("action",this.href);
                $("#deleteForm").submit();
                return false;
            })
        })
    </script>
</head>
<body>
    <table border="1" cellspacing="0px" cellpadding="5px">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.userName}</td>
                <td>${student.userAge}</td>
                <td><a studentId="${student.id}" class="updateA" href="${basePath}/student/detail/${student.id}">修改</a></td>
                <td><a studentId="${student.id}" class="deleteA" href="${basePath}/student/detail/${student.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${basePath}/addStudent.jsp">新增学生</a>

    <form id="deleteForm" method="post">
        <input type="hidden" name="_method" value="delete">
    </form>
</body>

</html>

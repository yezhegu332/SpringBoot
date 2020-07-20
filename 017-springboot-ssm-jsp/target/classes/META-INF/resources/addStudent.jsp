<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("basePath", pageContext.getServletContext().getContextPath());
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${basePath}/jQuery/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("input:submit").click(function () {
                var userName = $("input[name='userName']").val();
                var userAge = $("input[name='userAge']").val();
                $("#addForm").attr("action", "${basePath}/student/detail/" + userName + "/" + userAge);
                $("#addForm").submit();
                return false;
            })
        })
    </script>
</head>
<body>
<form id="addForm" method="post">
    姓名：<input type="text" name="userName"><br>
    年龄：<input type="text" name="userAge"><br>
    <input type="submit" value="新增学员">
</form>
</body>
</html>

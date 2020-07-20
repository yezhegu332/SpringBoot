<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20
  Time: 19:59
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
            $("input[name='userName']").val("${student.userName}");
            $("input[name='userAge']").val("${student.userAge}");
            $("input:submit").click(function () {
                var userName = $("input[name='userName']").val();
                var userAge = $("input[name='userAge']").val();
                $.ajax({
                    url:"/student/detail/${student.id}"+"/"+userName+"/"+userAge,
                    data:{},
                    type:"put",
                    success:function () {
                        window.location.href="${basePath}/student";
                    }
                })
                return false;
            })

        })
    </script>
</head>
<body>
    <form action="/student/detail/${student.id}" method="post">
        <input type="hidden" name="_method" value="put">
        姓名：<input type="text" name="userName"><br>
        年龄：<input type="text" name="userAge"><br>
        <input type="submit" value="修改学员">
    </form>
</body>
</html>

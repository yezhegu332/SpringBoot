<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/20
  Time: 19:30
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
        window.location.href="${basePath}/student";
    </script>
</head>
<body>

</body>
</html>

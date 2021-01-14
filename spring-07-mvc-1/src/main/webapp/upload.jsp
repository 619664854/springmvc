<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/1/8
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<form method="post" action="${pageContext.request.contextPath}/user/quick17" enctype="multipart/form-data">
        名称:<input type="text" name="userName"></br>
        文件:<input type="file" name="upload"></br>
        文件:<input type="file" name="upload"></br>
        文件:<input type="file" name="upload"></br>
        <input type="submit" value="提交">
    </form>--%>
    <%--单文件上传--%>
    <form method="post" action="${pageContext.request.contextPath}/user/quick16" enctype="multipart/form-data">
        名称:<input type="text" name="userName"></br>
        文件:<input type="file" name="upload"></br>
        <input type="submit" value="提交">
    </form>
</body>
</html>

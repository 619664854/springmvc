<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/24
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick11" method="post" id="formId">
        <%--表明是第几个User的userName age--%>
        <input type="text" name="userList[0].userName" value="张三"></br>
        <input type="text" name="userList[0].age" value="22"></br>
        <input type="text" name="userList[1].userName" value="李四"></br>
        <input type="text" name="userList[1].age" value="30"></br>
        <input type="submit" value="提交" name="提交" >
    </form>
</body>
</html>

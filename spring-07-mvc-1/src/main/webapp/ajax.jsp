<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AjaxTest</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"/>
</head>
<body>
<script>
    var userList = new Array();
    userList.push({userName:"asd",age:18});
    userList.push({userName:"qwe",age:28});
    console.log(userList);
    $.ajax({
        type:"POST",
        url:"/user/quick12",
        data:JSON.stringify(userList),
        contentType:"application/json;charset=utf-8"
    });
</script>

</body>
</html>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    恭喜您成功登录xx系统

    <shiro:guest>
        <a href="/f/login">登录</a>
    </shiro:guest>

    <shiro:user>
        ${loginUser.nickName}
    </shiro:user>

    <%--Hello, <shiro:principal/>, how are you today?--%>
    <shiro:hasRole name="defaultRole">
        <a href="/test/beet">测试 Beetl</a>
    </shiro:hasRole>


    <h5>提示信息:${message}</h5>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    欢迎访问xx系统,请填写登录信息


    <form method="post" action="/f/login">
        <input name="account" type="text" placeholder="账号">
        <input name="pwd" type="text" placeholder="密码">
        <input name="rememberMe" type="checkbox" value="1" checked="true">
        <button type="reset">重置</button>
        <button type="submit">提交</button>
    </form>

    <h5>提示:${message}</h5>

</body>
</html>

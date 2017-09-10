<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    欢迎访问xx系统,请填写登录信息


    <form method="post" action="${ctx}/f/login">
        <input name="account" type="text" placeholder="账号">
        <input name="pwd" type="text" placeholder="密码">
        <input name="goUrl" type="hidden" value="index.jsp">
        <input name="rememberMe" type="checkbox" value="0" checked="false">记住我
        <button type="reset">重置</button>
        <button type="submit">提交</button>
    </form>

    <c:if test="${not empty message}">
        <h5>提示:${message}</h5>
    </c:if>


</body>
</html>

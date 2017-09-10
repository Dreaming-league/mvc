<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到RequireJS学习模块</title>
    <link rel="stylesheet" href="${ctxStatic}/css/bootstrap.css">
    <link rel="stylesheet" href="${ctxStatic}/css/bootstrap-theme.css">
</head>
<body>
    <h1>欢迎来到RequireJS学习模块</h1>
    <button class="btn btn-primary" id="user">加载用户信息</button>
    <div id="userinfo"></div>

    <script src="${ctxStatic}/js/lib/require.js"></script>
    <script src="${ctxStatic}/js/require.config.js"></script>
    <script src="${ctxStatic}/js/test/app.js"></script>
</body>
</html>

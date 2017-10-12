<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>
    <input type="hidden" id="ctxStatic" value="${ctxStatic}">
    <div id="bk_img" class="container" style="background:#fff url('${ctxStatic}/images/login/bg_img1.jpeg') no-repeat center center;background-size:cover;width: 100%;height:100%;">
        <div class="row">
            <div class="col-md-12 text-center">
                <h2>欢迎来到梦想联盟管理系统</h2>
            </div>
        </div>
        <br><br>

        <div class="row">
            <div class="col-md-offset-4 col-md-4">
                <form class="form-signin" method="post" action="/f/login">
                    <h2 class="form-signin-heading">Please sign in</h2>
                    <label for="inputAccount" class="sr-only">Account</label>
                    <input class="form-control" id="inputAccount" name="account" type="text" placeholder="账号" required autofocus>
                    <label class="sr-only">Password</label>
                    <input class="form-control" name="pwd" type="password" placeholder="密码" required>
                    <div class="checkbox">
                        <label>
                            <input name="rememberMe" type="checkbox" value="1"> <span id="rememberMe">Remember me</span>
                        </label>
                    </div>
                    <c:if test="${not empty message}">
                        <span>提示:${message}</span>
                    </c:if>
                    <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>
        
    </div>

    <script src="${ctxStatic}/js/lib/require.js"></script>
    <script src="${ctxStatic}/js/require.config.js"></script>
    <script src="${ctxStatic}/js/login/app.js"></script>
</body>
</html>

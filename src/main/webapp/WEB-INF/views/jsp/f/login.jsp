<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>
    <div class="container" style="background-image: url('${ctxStatic}/images/login/3b292df5e0fe99254df1c2783ea85edf8db1711d.jpg');width: 100%;height:100%;">
        <div class="row">
            <div class="col-md-12 text-center">
                <h2>欢迎来到梦想联盟管理系统</h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-offset-4 col-md-4">
                <form class="form-signin" method="post" action="/f/login">
                    <h2 class="form-signin-heading">Please sign in</h2>
                    <label for="inputAccount" class="sr-only">Email address</label>
                    <input class="form-control" id="inputAccount" name="account" type="text" placeholder="账号" required autofocus>
                    <label class="sr-only">Password</label>
                    <input class="form-control" name="pwd" type="password" placeholder="密码" required>
                    <div class="checkbox">
                        <label>
                            <input name="rememberMe" type="checkbox" value="1"> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>
        
    </div>

    

    <c:if test="${not empty message}">
        <h5>提示:${message}</h5>
    </c:if>

    <script src="${ctxStatic}/js/lib/require.js"></script>
    <script src="${ctxStatic}/js/require.config.js"></script>
    <script src="${ctxStatic}/js/login/app.js"></script>
</body>
</html>

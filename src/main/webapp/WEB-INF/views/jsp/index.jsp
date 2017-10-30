<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
</head>
<body>
    <input type="hidden" id="ctxStatic" value="${ctxStatic}">

    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">梦想联盟-管理平台</a>
            </div>
            <div>
                <!--向左对齐-->
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a href="/test/requirejs/index">
                            RequireJs
                        </a>
                    </li>
                    <shiro:hasRole name="defaultRole">
                    <li>
                        <a href="/test/beet">
                            Beetl
                        </a>
                    </li>
                    </shiro:hasRole>
                    <li>
                        <a href="/api/index">
                            接口文档
                        </a>
                    </li>
                    <li>
                        <a href="/front/theme/templates/admin/index.html">
                            模版页面
                        </a>
                    </li>
                    <li>
                        <a href="/shiro/menu/index">
                            菜单管理
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            用户管理
                        </a>
                    </li>
                </ul>
                <p class="navbar-text navbar-left">
                    <c:if test="${not empty message}">
                    提示：${message}
                    </c:if>
                </p>
                <!--向右对齐-->
                <ul class="nav navbar-nav navbar-right">
                    <shiro:guest>
                        <li><a href="javascript:void(0)"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                        <li><a href="/f/login"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
                    </shiro:guest>
                    <shiro:user>
                        <li><a href="/f/logout"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
                    </shiro:user>
                </ul>
                <p class="navbar-text navbar-right">欢迎加入梦想联盟</p>
            </div>
        </div>
    </nav>

    <pre>
        说明:

        1. 学习\练习在com.tikie.test模块下
        2. 其他模块开发可在tikie的下级,和test同级开发其他相应模块
        3. 个人维护个人的类,不要轻易更改别人的代码
        4. 每次打开项目先同步线上代码,(先git pull),每次确定无bug后方可提交代码到线上

    代码更新规范：
        1. 第一次拉取代码:git clone https://github.com/Dreaming-league/mvc.git
        2. 在本地建立本地分支练习、修改:git branch -b develop
        3. 拉取线上开发最新代码到本地:git pull origin develop(从远程获取最新版本并merge到本地,存在冲突就解决冲突)
        4. 查看代码修改状态：git status
        5. 提交本地代码：1）git add .(把本地所有修改压入提交本地仓库的队列或逐个压入,后跟文件路径)
                       2) git commit -m "更新注释，提交说明 "(提交到本地git仓库)
                       3) git commit -a -m "更新注释，提交说明" (简化操作，作用同1、2)
        6. 更新到线上develop分支：git push origin develop
        7. 确定代码不再更改后同步到线上proposed(建议)分支：git push origin proposed

        8. 最终项目负责人把稳定版同步到主分支master(有权限限制哦)：git push origin master

        ps:关于git的相关指令等操作可自我百度学习;

           设置默认push/pull行为
           (push当前分支到远程同名分支，如果远程同名分支不存在则自动创建同名分支)
           git config push.default "current"
           git config pull.default "current"

           #在对应的分支上执行：如develop分支
           git branch --set-upstream-to=origin/develop

    基本规范:

        1. 写上类注释和方法注释,最好也上逻辑流程注释(可参考HelloWorldController的相关注释)
        2. 类名,方法名采用驼峰命名法,entity包里的实体类的字段必需和数据库一一对应
        3. 实体类统一采用Lombok注解生成Getter,Setter等方法
        4. 前端展示所需的字段和数据库不一致可以另建一个对应的PO类
        5. 异步请求返回的数据需要封装为String格式的json数据（避免有些浏览器接收json格式的数据直接下载）

    数据库规范:

        1. 数据库字段尽量不做非空,外健限制(限制在代码实现)
        2. 各个表的ID统一为32位uuid
        3. 以后新建的表统一增加模块前缀,如:test_helloworld(表明全小写,字段名驼峰)

    接口开发规范:

        1. 开发完每个接口后必需写对应的测试类,确保无bug
        2. 接口采取见名知义\言简意赅的原则,如:getById(或get),add,delete,update,getAll,getSimilarByMessage等
        3. add和update返回值为true／false,delete返回删除成功了几条数据
    </pre>

    <script src="${ctxStatic}/js/lib/require.js"></script>
    <script src="${ctxStatic}/js/require.config.js"></script>
    <script src="${ctxStatic}/js/login/app.js"></script>
</body>
</html>

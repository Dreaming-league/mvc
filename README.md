#一. Springmvc起航
    以Springmvc架构搭建最简单的web项目，做为一个引子
    
    
##二. 关于我们
    我们是一群有理想、有抱负的愤青，一直不满足于当下的技术积累，决定团结一致，追求更高深的技术！
    
    组织发起者：Tikie
    QQ:290313636
    QQ群：282781158
    [gitbook](https://www.gitbook.com/book/290315636/springmvc/details)
    
    
##三. 技术方向
    javaWeb相关技术
    
    python相关技术
    
    ElasticSearch
    
##四. 更新
    1.0.1 更改为注解模式,方法已同步到gitbook
    
    1.1.1 增加mybatis-spring技术,实现数据持久化(c3p0为数据源连接池实现,连接mysql5.6+数据库)
    
    1.2.1 增加shiro权限控制和beetl\jsp视图支持
    1.2.2 增加异步请求返回数据封装格式
    
    1.3.1 数据库时间字段默认值统一为当前时间
          更新样例：ALTER TABLE `shiro_role` MODIFY COLUMN `createdTime` TIMESTAMP null DEFAULT CURRENT_TIMESTAMP;
          
    1.4.1 更新常用工具类，添加允许跨域访问过滤器
    
    1.5.1 项目增加develop和proposed分支，在develop分支上开发，确定没问题了提交到proposed分支，项目负责人确定没问题后更新proposed分支到master主分支
    
    1.6.1 增加页面子模块 https://github.com/Dreaming-league/static.git
    
##五. 下次更新 
    后台管理模块之权限管理  
        
    
##六. 开发规范

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
                   
        ps:关于git的相关指令等操作可自我百度学习
                      
    基本规范:
    
        1. 写上类注释和方法注释,最好也上逻辑流程注释(可参考HelloWorldController的相关注释)
        2. 类名,方法名采用驼峰命名法,entity包里的实体类的字段必需和数据库一一对应
        3. 实体类统一采用Lombok注解生成Getter,Setter等方法
        4. 前端展示所需的字段和数据库不一致可以另建一个对应的PO类
        5. 异步请求返回的数据需要封装为String格式的json数据（避免有些浏览器接收json格式的数据直接下载）
        
    数据库规范:
    
        1. 数据库字段尽量不做非空,外健限制(限制在代码实现)
        2. 各个表的ID统一为32位bigint
        3. 以后新建的表统一增加模块前缀,如:test_helloworld(表明全小写,字段名驼峰)
        
    接口开发规范:
    
        1. 开发完每个接口后必需写对应的测试类,确保无bug
        2. 接口采取见名知义\言简意赅的原则,如:getById(或get),insert,delete,update,getAll,getSimilarByMessage等
        
##七.加入我们
    直接发送你的git账号到290315636@qq.com邮箱，申请加入权限，或加入梦想群申请加入。
# 一. Springmvc起航
    以Springmvc架构搭建最简单的web项目，做为一个引子
    
    
## 二. 关于我们
    我们是一群有理想、有抱负的愤青，一直不满足于当下的技术积累，决定团结一致，追求更高深的技术！
    
    组织发起者：Tikie
    QQ:290313636
    QQ群：282781158
    [资料](https://www.gitbook.com/book/290315636/springmvc/details)
    [百度](https://www.baidu.com/)
    
    主要负责人：tikie
    开发人员：tikie,and so on 
    
## 三. 技术方向
    javaWeb相关技术
    
    python相关技术
    
    ElasticSearch
    
## 四. 更新
    1.0.1 更改为注解模式,方法已同步到gitbook
    
    1.1.1 增加mybatis-spring技术,实现数据持久化(c3p0为数据源连接池实现,连接mysql5.6+数据库)
    
    1.2.1 增加shiro权限控制和beetl\jsp视图支持
    1.2.2 增加异步请求返回数据封装格式
    1.2.3 更新shiro-principal携带的用户信息
    
    1.3.1 数据库时间字段默认值统一为当前时间
          更新样例：ALTER TABLE `shiro_role` MODIFY COLUMN `createdTime` TIMESTAMP null DEFAULT CURRENT_TIMESTAMP;
    1.3.2 数据库isActive更改默认值为1，isDelete默认值为0，isSys默认值为1     
          
    1.4.1 更新常用工具类，添加允许跨域访问过滤器
    
    1.5.1 项目增加develop和proposed分支，在develop分支上开发，确定没问题了提交到proposed分支，项目负责人确定没问题后更新proposed分支到master主分支
    
    1.6.1 增加页面子模块 https://github.com/Dreaming-league/static.git
    1.6.2 暂时去掉子模块 前端页面不太成熟，成型后再做成子模块
    
    1.7.1 集成HikariCP数据源(统计表明比c3p0快20%，感谢mujourney的建议)
    
    1.8.1 service层增加缓存处理（测试类需要启动服务才能使用缓存）
    1.8.2 UserService增加其他方法
    
    1.9.1 使用mybatis generator生成service基本代码
    1.9.2 生成的代码--插入时改为自增主键，增加基于example的动态where条件处理
    1.9.3 生成代码及使用步骤
          1. 更改resources/config/test/jdbc.properties中的配置（主要更改模块名）
          2. 更改resources/generatorConfig.xml关于表的配置（基于哪些表生成对应的代码）
          3. 运行maven命令：mvn mybatis-generator:generate
          4. 对于每个生成的Mapper接口增加@MyBatisRepository注解
          5. 书写service层接口及实现
          6. 书写测试类
          ps:可参考generator模块学习基本使用方法
          
    2.0.0 更新pom依赖，去掉过时依赖
    
    2.1.0 前端技术增加RequireJS,测试用例请看/static/js下的代码
    
## 五. 下次更新 
    后台管理模块之权限管理  
        
    
## 六. 开发规范

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
        2. 各个表的ID统一为32位bigint
        3. 以后新建的表统一增加模块前缀,如:test_helloworld(表明全小写,字段名驼峰)
        
    接口开发规范:
    
        1. 开发完每个接口后必需写对应的测试类,确保无bug
        2. 接口采取见名知义\言简意赅的原则,如:getById(或get),add,delete,update,getAll,getSimilarByMessage等
        3. add和update返回值为true／false,delete返回删除成功了几条数据
        
## 七.加入我们
    直接发送你的git账号到290315636@qq.com邮箱，申请加入权限，或加入梦想群申请加入。
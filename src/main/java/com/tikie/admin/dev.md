##后台管理模块

###一、技术框架

    1. 视图采用jsp页面展示(已集成bettl，也可以尝试使用)
    
    2. bootstrap页面布局
    
    3. requirejs控制引入的js ----[requirejs](http://www.requirejs.cn/home.html) 
    
    4. jquery相关组件实现操作友好性、简便性
    
    5. 基于html5新特性和vue(正在集成)框架

###二、功能模块

    1. 用户管理
        1）右键加载操作选项，此选项是根据当前用户的权限动态加载好的，右键管理时显示出来
    
    2. 角色管理
    
    3. 权限管理
    
    ps: 1）给用户赋予什么角色就是对用户角色表对维护；  -----支持右键操作
        2）把角色分配给哪些用户也是对用户角色表的维护；-----支持右键操作
        
        3）给角色赋予什么权限就是对角色权限表的维护；  -----支持右键操作
        4）把权限分配给哪些角色也是对角色权限表对维护；-----支持右键操作
        
        5) 筛选权限时可以左边点击加到右边，右边点击还到左边的形式；或者树状勾选
        
###三、扩展
   
     1. 第三方登录，增加group为第三方组，包括qq、微信等，及用户组中间表，注册第三方登录时更新中间表
     2. 扫一扫完善信息
     3. 添加联系人（支持扫一扫），增加relation表及更新用户信息（增加是否为系统用户字段），
     如果系统中存在就直接建立关联并通知好友（前提实现通知系统），否则新建好友并建关联，发送邀请链接
     
     
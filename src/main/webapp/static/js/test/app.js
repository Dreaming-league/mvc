require(["jquery",
    "helper","api",
    "modernizr",
    "bootstrap",
    "i18n!nls/messages"],function($,helper,api,modernizr,bootstrap,i18n){
    //测试自定义函数
    var str = helper.trim("   AMD   ");
    console.log(str);

    $("#user").click(function(){
        //测试自定义对象
        // api.getUser().then(function(user){
        //     console.log(user);
        // });

        //测试text插件
        api.loadUser();

        //测试i18n
        // $(this).after('<button class="btn btn-default">'+i18n.edit+'</button>');
    });

    //测试AMD处理模块
    // console.log(modernizr);

});

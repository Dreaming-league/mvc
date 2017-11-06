define(["jquery"],function($){
    return {
        getUser :function(){
            var def = $.Deferred();//延迟加载
            require(["user"],function(user){
                def.resolve(user);
            });
            return def;
        },
        loadUser :function(){
            require(["text!data/user.html"],function(template){
                $("#userinfo").html(template);
            });
        }
    }
});
require(["jquery",
    "bootstrap",
    "i18n!nls/messages"],function($, bootstrap, i18n){
    // console.log($);
    // 随机背景图
    var bg_imgs = ["bg_img0.jpg","bg_img1.jpeg","bg_img2.jpeg","bg_img3.jpeg","bg_img4.jpeg","bg_img5.jpeg","bg_img6.jpeg","bg_img7.jpeg","bg_img8.jpeg","bg_img9.jpeg"];
    $("#bk_img").css("background-image","url('"+ $("#ctxStatic").val() +"/images/login/"+ bg_imgs[Math.floor(Math.random()*10)] +"')");

    $(".form-signin-heading").text(i18n.login_title);
    $("#inputAccount").attr("placeholder",i18n.login_account);
    $("input[name=pwd]").attr("placeholder",i18n.login_password);
    $("#rememberMe").text(i18n.login_rememberMe);
    $("#submit").text(i18n.login_submit);
});

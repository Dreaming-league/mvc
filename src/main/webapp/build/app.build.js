({
    appDir:"./",
    baseUrl:"js",
    dir:"../build",
    optimize:"none",//none、uglify
    mainConfigFile:"js/require.config.js",
    inlineText:false,
    modules:[{
            name:"test/helper"
        },{
            name:"test/app",
            // exclude:["modernizr"],//不引用
            // include:["modernizr"],//打包引用
            // insertRequire:["modernizr"],//额外引用
            excludeShallow:["modernizr"]//不引用，不影响其他依赖
        }
    ]
});
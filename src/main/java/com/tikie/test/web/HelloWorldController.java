package com.tikie.test.web;


import com.tikie.test.entity.HelloWorld;
import com.tikie.test.service.HelloWorldService;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @targget     测试web响应测试Controller类
 *
 * @author      tikie
 * @date        2016-09-28
 * @version     1.0.0
 */
@Controller
@RequestMapping(value = "/test")
public class HelloWorldController{

    @Autowired
    private HelloWorldService helloWorldService;

    @Autowired
    private BeetlGroupUtilConfiguration beetlConfig;
    /**
     * @target      响应/test/hello的方法
     *
     * @return      ModelAndView    跳转到hello页面
     *              即WEB-INF/views/jsp/hello.jsp页面
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ModelAndView handleRequest(){
        /*
        1、收集参数、验证参数
        2、绑定参数到命令对象
        3、将命令对象传入业务对象进行业务处理
        4、选择下一个页面
        */
        ModelAndView mv = new ModelAndView();
        HelloWorld hello = helloWorldService.getById(0);

        if(hello!=null){
            //添加模型数据 可以是任意的POJO对象
            mv.addObject("message", hello.getMessage());
        }else{
            mv.addObject("message","数据库还没有欢迎信息");
        }

        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("hello.jsp");
        return mv;
    }

    @RequestMapping(value = "/beet",method = RequestMethod.GET)
    public ModelAndView beetMapper(){
        ModelAndView mv = new ModelAndView("hello.html");
        HelloWorld hello = helloWorldService.getById(0);

        if(hello!=null){
            //添加模型数据 可以是任意的POJO对象
            mv.addObject("message", hello.getMessage());
        }else{
            mv.addObject("message","数据库还没有欢迎信息");
        }

        //加载模板
        GroupTemplate gt = beetlConfig.getGroupTemplate();
        Template t = gt.getTemplate("WEB-INF/views/beetl/template/test/hello.txt");
        //绑定全局变量到模板
        t.binding("test","Beetl真好玩");

        //获得html内容
        String str = t.render();
        System.out.println(str);

        //渲染到页面的指定模块
        mv.addObject("content",str);
        return mv;
    }
}
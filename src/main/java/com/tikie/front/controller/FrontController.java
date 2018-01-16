package com.tikie.front.controller;

import java.util.HashMap;
import java.util.Map;

import com.tikie.common.util.string.StringUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/f")
public class FrontController {

	@Autowired
    private BeetlGroupUtilConfiguration beetlConfig;

	@RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("theme/templates/admin/index.html");
    	GroupTemplate gt = beetlConfig.getGroupTemplate();
    	Map<String,Object> shared = new HashMap<String,Object>();

		String ctxPath = StringUtils.substringBeforeLast(request.getRequestURL().toString(),":")
				+":"
				+request.getServerPort()
				+request.getContextPath();

    	shared.put("beetlCtx", ctxPath + "/front/theme/");
    	gt.setSharedVars(shared);
    	
    	//加载模板
        Template t = gt.getTemplate("front/theme/templates/tpl/index.txt");
        //绑定全局变量到模板
//        t.binding("test","Beetl真好玩");

        //获得html内容
        String str = t.render();
        System.out.println(str);
    	
    	return mv;
    }
	
	@RequestMapping(value = "/{module}/index",method = RequestMethod.GET)
    public ModelAndView handleModuleRequest(@PathVariable String module){
		ModelAndView mv = new ModelAndView("theme/templates/admin/"+module+"/index.html");
    	GroupTemplate gt = beetlConfig.getGroupTemplate();
    	
    	//加载模板
        Template t = gt.getTemplate("front/theme/templates/tpl/"+module+"/index.txt");

        //获得html内容
        t.render();
    	
    	return mv;
    }

	@RequestMapping(value = "/{module}.html",method = RequestMethod.GET)
	public ModelAndView handleModuleHtml(@PathVariable String module){
		ModelAndView mv = new ModelAndView("theme/templates/admin/"+module+".html");
		GroupTemplate gt = beetlConfig.getGroupTemplate();

		//加载模板
		Template t = gt.getTemplate("front/theme/templates/tpl/blank.txt");

		//获得html内容
		t.render();

		return mv;
	}
}

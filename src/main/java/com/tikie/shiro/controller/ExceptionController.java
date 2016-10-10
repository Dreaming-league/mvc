package com.tikie.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @targget     Controller类
 *
 * @author      tikie
 * @date        2016-10-10
 * @version     1.0.0
 */
@org.springframework.stereotype.Controller
public class ExceptionController {

    @RequestMapping("/403")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "/error/403";
    }
}

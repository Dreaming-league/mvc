package com.tikie.shiro.controller;

import com.tikie.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tikie
 * @desc 权限管理之用户管理
 * @date 2016/10/27
 */
@Controller
@RequestMapping(value = "/a")
public class UserController {
    @Autowired
    private UserService userService;

}

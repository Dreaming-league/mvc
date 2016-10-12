package com.tikie.shiro.controller;

import com.tikie.shiro.entity.User;
import com.tikie.shiro.service.UserService;
import com.tikie.shiro.vo.Login;
import com.tikie.util.security.EncrypMD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @targget     登录Controller类
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@Controller
@RequestMapping(value = "/f")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * @target      跳转到登录页面
     *
     * @return      ModelAndView    跳转到hello页面
     *              即WEB-INF/views/jsp/login.jsp页面
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView toLogin(){
        ModelAndView mv = new ModelAndView();
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("login.jsp");
        return mv;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(Login login,HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ModelAndView mv = new ModelAndView();
        //输入非空校验
        if(StringUtils.isEmpty(login.getAccount()) || StringUtils.isEmpty(login.getPwd())){
            session.setAttribute("message","用户名或密码为空");
            mv.setViewName("redirect:/f/login");
            return mv;
        }

        User user = userService.getByAccount(login.getAccount());
        if(user ==null || !user.getPwd().equals(new EncrypMD5().EncoderByMd5(new EncrypMD5().EncoderByMd5(login.getPwd())))){
            session.setAttribute("message","用户不存在或密码错误");
            mv.setViewName("redirect:/f/login");
            return mv;
        }else{
            //获取密码令牌并验证
            UsernamePasswordToken token = null;
            token = new UsernamePasswordToken(login.getAccount(), new EncrypMD5().EncoderByMd5(new EncrypMD5().EncoderByMd5(login.getPwd())));
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                //使用shiro来验证
                if(login.getRememberMe()!=null &&login.getRememberMe().equals("1"))
                    token.setRememberMe(true);
                currentUser.login(token);//验证角色和权限
            }

            //验证通过
            mv.addObject("message", "登录成功");
            //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
            mv.setViewName("index.jsp");
            return mv;
        }
    }

    @RequiresAuthentication
    @RequestMapping("/logout")
    public ModelAndView logout(){
        SecurityUtils.getSubject().logout();
        return new ModelAndView("hello.jsp");
    }
}

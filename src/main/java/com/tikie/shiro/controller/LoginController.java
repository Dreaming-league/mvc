package com.tikie.shiro.controller;

import com.tikie.shiro.entity.User;
import com.tikie.shiro.service.UserService;
import com.tikie.shiro.vo.Login;
import com.tikie.common.util.security.EncrypMD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * @target      跳转到登录页面
     *
     * @return      ModelAndView    跳转到对应login页面
     *              即WEB-INF/views/jsp/{module}/login.jsp页面
     */
    @RequestMapping(value = "/{module}/login",method = RequestMethod.GET)
    public ModelAndView toLogin(@PathVariable ("module")String module){
        ModelAndView mv = new ModelAndView();
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName(module + "/login.jsp");
        return mv;
    }

    /**
     * @target      跳转到列表页面
     *
     * @return      ModelAndView    跳转到对应index页面
     *              即WEB-INF/views/jsp/{module}/index.jsp页面
     */
    @RequestMapping(value = "/{module}/index",method = RequestMethod.GET)
    public ModelAndView toIndex(@PathVariable ("module")String module){
        ModelAndView mv = new ModelAndView();
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName(module + "/index.jsp");
        return mv;
    }

    /**
     * @target      跳转到列表页面
     *
     * @return      ModelAndView    跳转到对应index页面
     *              即WEB-INF/views/jsp/{module}/index.jsp页面
     */
    @RequestMapping(value = "/shiro/{module}/index",method = RequestMethod.GET)
    public ModelAndView toShiroIndex(@PathVariable ("module")String module){
        ModelAndView mv = new ModelAndView();
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("shiro/" + module + "/index.jsp");
        return mv;
    }

    /**
     * 更新为指定页面跳转
     * @param login
     * @param session
     * @return 登录成功页面
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/{module}/login",method = RequestMethod.POST)
    public ModelAndView login(@PathVariable ("module")String module, Login login,HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ModelAndView mv = new ModelAndView();
        //输入非空校验
        if(StringUtils.isEmpty(login.getAccount()) || StringUtils.isEmpty(login.getPwd())){
            session.setAttribute("message","用户名或密码为空");
            mv.setViewName(module + "/login.jsp");
            return mv;
        }

        User user = userService.getByAccount(login.getAccount());
        //TODO 邀请码验证，用户详情和登录信息分离;登录成功后验证有没有此应用/模块的使用权限
        if(null == user){
            session.setAttribute("message","用户不存在");
            mv.setViewName(module + "/login.jsp");
            return mv;
        }else if(!user.getPwd().equals(new EncrypMD5().EncoderByMd5(new EncrypMD5().EncoderByMd5(login.getPwd())))){
            session.setAttribute("message","用户密码错误");
            mv.setViewName(module + "/login.jsp");
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
            String goUrl = StringUtils.isEmpty(login.getGoUrl())?"index.jsp":login.getGoUrl();
            mv.setViewName(goUrl);
            return mv;
        }
    }


    @RequiresAuthentication
    @RequestMapping(value = "/f/logout",method = RequestMethod.GET)
    public ModelAndView logout(){
        SecurityUtils.getSubject().logout();
        return new ModelAndView("hello.jsp");
    }
}

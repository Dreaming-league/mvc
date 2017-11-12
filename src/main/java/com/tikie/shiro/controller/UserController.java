package com.tikie.shiro.controller;

import com.tikie.common.util.response.ResponseJson;
import com.tikie.shiro.entity.User;
import com.tikie.shiro.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    //日期格式化
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }

    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String getAllUsers(){

        // TODO 做数据权限限制，组里的管理员查看到组下到人员;做好分页
        return ResponseJson.getInstance().setData(userService.getAll()).toString();
    }

    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public String getById(@RequestParam String id){

        return ResponseJson.getInstance().setData(userService.getById(id)).toString();
    }

    @RequestMapping(value = "/deleteByIds",method = RequestMethod.DELETE)
    public String deleteById(@RequestParam String[] ids){

        return ResponseJson.getInstance().setData(userService.deleteByIds(ids)).toString();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestParam User user){
        if(StringUtils.isNoneBlank(user.getId())){
            return ResponseJson.getInstance().setData(userService.add(user)).toString();
        }
        return ResponseJson.getInstance().setData(userService.update(user)).toString();
    }
}
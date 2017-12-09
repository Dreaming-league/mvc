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
import java.util.List;

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

    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public String getAllUsers(){

        List<User> userList = userService.getAll();

        // TODO 做数据权限限制，组里的管理员查看到组下到人员;做好分页

        return ResponseJson.getInstance()
                .set2Default(true)
                .setTotal(userList.size())
                .setData(userList)
                .toString();
    }

    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public String getById(@RequestParam String id){

        User user = userService.getById(id);

        return ResponseJson.getInstance()
                .set2Default(true)
                .setTotal(1)
                .setData(user)
                .toString();
    }

    @RequestMapping(value = "/deleteByIds",method = RequestMethod.DELETE)
    public String deleteById(@RequestParam String[] ids){

        Boolean status = userService.deleteByIds(ids);

        String message = ResponseJson.RESPONSE_FAILED_MESSAGE;

        if(status)message = ResponseJson.RESPONSE_SUCCESS_MESSAGE;

        return ResponseJson.getInstance()
                .set2Default(true)
                .setData(ids)
                .setStatus(status)
                .setMessage(message)
                .toString();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@RequestParam User user){
        if(null == user){
            return ResponseJson.getInstance()
                    .set2Default(false)
                    .setMessage("用户不能为空")
                    .toString();
        }

        if(null == user.getId() || StringUtils.isBlank(user.getId())){
            Boolean status = userService.update(user);
            String message = ResponseJson.RESPONSE_FAILED_MESSAGE;
            if(status)message = ResponseJson.RESPONSE_SUCCESS_MESSAGE;
            return ResponseJson.getInstance()
                    .set2Default(true)
                    .setStatus(status)
                    .setMessage(message)
                    .toString();
        }

        Boolean status = userService.add(user);
        String message = ResponseJson.RESPONSE_FAILED_MESSAGE;
        if(status)message = ResponseJson.RESPONSE_SUCCESS_MESSAGE;
        return ResponseJson.getInstance()
                .set2Default(true)
                .setStatus(status)
                .setMessage(message)
                .toString();
    }
}
package com.tikie.shiro.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tikie.common.util.response.ResponseJson;
import com.tikie.shiro.entity.User;
import com.tikie.shiro.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    /**
     * @(dataTable格式)
     * @param:[onDuty, sEcho, start：开始索引数, length：每页显示数量]
     * @return:java.util.Map<java.lang.String,java.lang.Object>
      */
    @RequestMapping(value="find-user-info",method=RequestMethod.POST)
    @ResponseBody
    public String getUsers(@RequestParam(value = "sEcho",required = false)Integer sEcho,@RequestParam("draw")Integer draw, @RequestParam("start")Integer start,@RequestParam("length")Integer length) {

    	start = start<0?0:start;
    	length = length<0?0:length;
    	
    	ResponseJson.getInstance().setSize(length).setPage(start/length);
    	
    	Map<String,Object> map = new HashMap<String, Object>();

        
    	List<User> userList = userService.getAll();
    	
    	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    	
    	//当前页数据
//        map.put("aaData", userList);
        map.put("data", userList);
        map.put("draw", draw);
        //页数信息配置
        map.put("sEcho", sEcho);
//        map.put("iTotalDisplayRecords", userList.size());
        map.put("recordsTotal", userList.size());
        
        // 全部用户  TODO 全部数据数量可以放到缓存，参数一致性，更新机制
        ResponseJson.getInstance().setSize(Integer.MAX_VALUE).setPage(ResponseJson.RESPONSE_DEFAULT_PAGE);
        List<User> alluserList = userService.getAll();
//        map.put("iTotalRecords", alluserList.size());
        map.put("recordsFiltered", alluserList.size());
        
        ResponseJson.getInstance().set2Default(true);
        return gson.toJson(map);
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
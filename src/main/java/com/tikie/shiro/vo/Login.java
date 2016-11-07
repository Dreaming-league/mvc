package com.tikie.shiro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @targget     用户登录前端展示实体类
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    private String account;         //账号
    private String pwd;             //密码
    private String rememberMe;      //记住我
}

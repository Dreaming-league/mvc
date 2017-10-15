package com.tikie.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private String id;

    private String pId;             //用户ID
    private String type;            //名称
    private String icon;            //名称
    private String url;             //名称
    private String accessCode;      //名称
    private String sysId;           //名称
    private Integer order;          //顺序

    private Boolean isActive;       //是否有效/启用
}

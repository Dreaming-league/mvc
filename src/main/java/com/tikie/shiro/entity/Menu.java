package com.tikie.shiro.entity;

import com.tikie.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu extends Entity{
    private String name;            //类型
    private String type;            //类型
    private String icon;            //图标
    private String url;             //URL
    private String accessCode;      //访问码
    private String sysId;           //系统ID
    private Integer order;          //顺序

    private List<MenuAuthorizationRelation> authRelationList;    //被哪些权限拥有

    private List<Menu> children;

}

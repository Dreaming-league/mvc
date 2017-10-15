package com.tikie.shiro.entity;

import com.tikie.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author TiKie
 * @desc 权限实体类
 * @date 2017/10/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authorization extends Entity {
    private String name;              //权限名称
    private String permission;        //权限标识
    private String type;              //权限类型

    private List<RoleAuthorizationRelation> roleRelationList;    //被哪些角色拥有

    private List<Authorization> children;                        //子权限

}

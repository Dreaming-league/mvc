package com.tikie.shiro.entity;

import com.tikie.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @targget     角色实体类
 *
 * @author      tikie
 * @date        2016-10-02
 * @version     1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Entity{
    private String name;            //角色名称
    private String permission;      //角色权限标识

    private List<GroupRoleRelation>            groupRelationList;   //被哪些组拥有
    private List<RoleAuthorizationRelation>    authRelationList;    //拥有哪些权限

}

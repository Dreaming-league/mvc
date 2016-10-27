package com.tikie.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Role {
    private Integer id;

    private String name;            //角色名称
    private String permission;      //权限标识

    private List<UserRoleRelation>          userRelationList;          //被哪些用户关系拥有
    private List<RolePermissionRelation>    permissionRelationList;    //拥有哪些权限关系

    private String isActive;        //是否有效/启用
    private String isDelete;        //是否逻辑删除

    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

    private String note;            //备注

    private String e;              //扩展字段

}

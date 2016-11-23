package com.tikie.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @targget     用户角色关系对照实体类
 *
 * @author      tikie
 * @date        2016-10-02
 * @version     1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionRelation implements Serializable {

    private Long roleId;
    private Long permissionId;

    private String isActive;        //是否有效/启用
    private String isDelete;        //是否逻辑删除

    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

    private String note;            //备注
}

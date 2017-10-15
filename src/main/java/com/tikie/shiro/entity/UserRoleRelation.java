package com.tikie.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *              用户角色关系对照实体类
 *
 * @author      tikie
 *              2016-10-02
 * @version     1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleRelation implements Serializable {
    private String userId;
    private String roleId;

    private Boolean isActive;        //是否有效/启用
    private Boolean isDelete;        //是否逻辑删除

    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

    private String note;            //备注
}

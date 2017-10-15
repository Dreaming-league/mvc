package com.tikie.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author TiKie
 * @desc 角色授权关联实体类
 * @date 2017/10/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuthorizationRelation implements Serializable {
    private String roleId;
    private String authId;

    private Boolean isActive;        //是否有效/启用

    private String createdBy;
    private String updatedBy;
    private String createdTime;
    private String updatedTime;

    private String note;            //备注
}

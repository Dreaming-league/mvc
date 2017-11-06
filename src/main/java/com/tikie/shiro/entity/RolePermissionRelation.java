package com.tikie.shiro.entity;

import com.tikie.base.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户角色关系对照实体类
 * @author      TiKie
 * @date        2016-10-02
 * @version     1.0.0
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class RolePermissionRelation extends Relation {

    private String roleId;
    private String permissionId;

    private Boolean isDelete;        //是否逻辑删除
}

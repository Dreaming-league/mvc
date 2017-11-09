package com.tikie.shiro.entity;

import com.tikie.base.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *              用户角色关系对照实体类
 *
 * @author      TiKie
 *              2016-10-02
 * @version     1.0.0
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleRelation extends Relation {
    private String userId;
    private String roleId;

    private Boolean isDelete;        //是否逻辑删除
}

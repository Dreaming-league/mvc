package com.tikie.shiro.entity;

import com.tikie.base.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TiKie
 * @desc 角色授权关联实体类
 * @date 2017/10/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuthorizationRelation extends Relation {
    private String roleId;
    private String authId;
}

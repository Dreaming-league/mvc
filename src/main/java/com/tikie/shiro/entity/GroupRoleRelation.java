package com.tikie.shiro.entity;

import com.tikie.base.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TiKie
 * @desc 目的
 * @date 2017/10/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupRoleRelation extends Relation {
    private String groupId;
    private String roleId;
}

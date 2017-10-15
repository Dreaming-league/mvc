package com.tikie.shiro.entity;

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
public class GroupRoleRelation {
    private String groupId;
    private String roleId;
    private Boolean isActive;        //是否有效/启用
}

package com.tikie.shiro.entity;

import com.tikie.base.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author TiKie
 * 用户组和角色关联实体类
 * @date 2017/10/14
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class GroupRoleRelation extends Relation {
    private String groupId;
    private String roleId;
}

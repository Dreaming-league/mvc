package com.tikie.shiro.entity;

import com.tikie.base.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TiKie
 * @desc 菜单授权实体类
 * @date 2017/10/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuAuthorizationRelation extends Relation{
    private String menuId;
    private String authId;
}

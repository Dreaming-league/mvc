package com.tikie.shiro.entity;

import com.tikie.base.Relation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author TiKie
 * 菜单授权实体类
 * @date 2017/10/15
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class MenuAuthorizationRelation extends Relation{
    private String menuId;
    private String authId;
}

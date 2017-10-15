package com.tikie.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author TiKie
 * @desc 菜单授权实体类
 * @date 2017/10/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuAuthorizationRelation implements Serializable {
    private String menuId;
    private String authId;
}

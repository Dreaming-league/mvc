package com.tikie.shiro.entity;

import com.tikie.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author TiKie
 * 权限实体类
 * @date 2017/10/15
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Authorization extends Entity {
    /**
	 * 实现序列化
	 */
	private static final long serialVersionUID = 8007704398892192021L;
	private String name;              //权限名称
    private String permission;        //权限标识
    private String type;              //权限类型

    private List<RoleAuthorizationRelation> roleRelationList;    //被哪些角色拥有

    private List<Authorization> children;                        //子权限

}

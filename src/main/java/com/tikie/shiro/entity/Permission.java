package com.tikie.shiro.entity;

import com.tikie.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**  
 * 权限实体类
 * @author      TiKie
 * @date        2016-10-02
 * @version     1.0.0
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends Entity {
    /**
	 * 实现序列化
	 */
	private static final long serialVersionUID = -1052271367845540732L;
	private String name;              //权限名称
    private String permission;        //权限标识
    private String type;              //权限类型

    private List<RolePermissionRelation> roleRelationList;    //被哪些角色关系拥有

    private List<Permission> children;                        //子权限

    private String e;               //扩展字段

}

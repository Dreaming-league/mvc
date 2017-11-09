package com.tikie.shiro.entity;

import com.tikie.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/** 
 * 角色实体类
 * @author      TiKie
 * @date        2016-10-02
 * @version     1.0.0
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Entity{
    /**
	 * 实现序列化
	 */
	private static final long serialVersionUID = -4967637455109745549L;
	private String name;            //角色名称
    private String permission;      //角色权限标识

    private List<GroupRoleRelation>            groupRelationList;   //被哪些组拥有
    private List<RoleAuthorizationRelation>    authRelationList;    //拥有哪些权限

}

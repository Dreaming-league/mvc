package com.tikie.shiro.service;

import com.tikie.common.config.Global;
import com.tikie.shiro.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * @targget     权限管理
 *
 * @author      tikie
 * @date        2016-10-09
 * @version     1.0.0
 */
@Transactional
public class MyShiro extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;
    /**
     * @target  权限认证
     *
     * @param   principalCollection
     * @return  AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Principal principal = (Principal) getAvailablePrincipal(principalCollection);
        //获取登录时输入的用户名
        String loginName=principal.getAccount();
//        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();
//        String loginName = (String)super.getAvailablePrincipal(principalCollection);
        //到数据库查是否有此对象
        User user=userService.getByAccount(loginName);

        if(user!=null){
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            //用户的角色集合
            List<UserRoleRelation> roleRelationList = user.getRoleRelationList();
            List<Role> roleList = new ArrayList<Role>();
            Set<String> rolesName = new HashSet<String>();
            for(UserRoleRelation userRoleRelation:roleRelationList){
                Role role = roleService.getById(userRoleRelation.getRoleId());
                if(role!=null){
                    roleList.add(role);
                    rolesName.add(role.getPermission());
                }
            }

            info.setRoles(rolesName);
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的十行可以不要
            for (Role role : roleList) {
                Collection<String> perssions = new ArrayList<String>();
                List<RolePermissionRelation> permissionRelationList = role.getPermissionRelationList();
                for(RolePermissionRelation permissionRelation:permissionRelationList){
                    Permission p = permissionService.getById(permissionRelation.getPermissionId());
                    //添加所有的权限标识
                    perssions.addAll(getPerssions(p));
                }
                info.addStringPermissions(perssions);
            }

            return info;
        }
        return null;
    }

    /**
     * @target  查处权限及子权限的权限标识
     * @param   permission
     * @return  Collection<String>
     */
    private Collection<String> getPerssions(Permission permission){
        Collection<String> perssions = new ArrayList<String>();
        //权限不空
        if(permission!=null && !StringUtils.isEmpty(permission.getPermission())){
            perssions.add(permission.getPermission());
            //子权限不空
            if(permission.getChildren()!=null){
                List<Permission> permissionList = permission.getChildren();
                //循环子权限--直到没有子权限
                for(Permission p:permissionList){
                    perssions.addAll(getPerssions(p));
                }
            }
        }
        return perssions;
    }

    /**
     * @target  登录认证
     *
     * @param   authenticationToken
     * @return  AuthorizationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        if(StringUtils.isEmpty(token.getUsername()))return null;
        User user=userService.getByAccount(token.getUsername());
        if(user!=null){
            //若存在，将此用户存放到登录认证info中
            try {
                return new SimpleAuthenticationInfo(new Principal(user), user.getPwd(), getName());
            } catch (AuthenticationException e) {
//                e.printStackTrace();
                //验证不通过
                return null;
            }
        }
        return null;
    }

    /**
     * 授权用户信息
     */
    @Data
    @NoArgsConstructor
    public static class Principal implements Serializable {

        private static final long serialVersionUID = 1L;

        private Integer id;             // 编号
        private String account;         // 登录名
        private String nickName;        //昵称:页面显示
        private String photo;           //头像
        private String sign;            //签名

//		private Map<String, Object> cacheMap;

        public Principal(User user) {
            this.id = user.getId();
            this.account = user.getAccount();
            this.nickName = user.getNickName();
            this.photo = user.getPhoto();
            this.sign = user.getSign();
        }


//		@JsonIgnore
//		public Map<String, Object> getCacheMap() {
//			if (cacheMap==null){
//				cacheMap = new HashMap<String, Object>();
//			}
//			return cacheMap;
//		}

    }
}

package com.tikie.shiro.service;

import com.tikie.common.util.string.StringUtils;
import com.tikie.shiro.entity.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

/**
 *              权限管理
 *
 * @author      tikie
 *              2016-10-09
 * @version     1.0.0
 */
@Transactional
public class MyShiro extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorizationService authorizationService;
    /**
     *          权限认证
     *
     *          principalCollection
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
            //用户的角色集合 TODO 角色

            String groupIds[] = user.getGroupId().split(",");
            List<Role> roleList = new ArrayList<Role>();
            if(groupIds.length > 0){
                roleList = roleService.getByGroupIds(groupIds);
            }

            Set<String> rolesName = new HashSet<String>();
            String[] roleIds = new String[roleList.size()];
            for(int i=0;i<roleList.size();i++){
                if(roleList.get(i)!=null){
                    rolesName.add(roleList.get(i).getPermission());
                    roleIds[i] = roleList.get(i).getId();
                }
            }

            info.setRoles(rolesName);//设置角色
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的十行可以不要
            List<Authorization> authList = authorizationService.getByRoleIds(roleIds);

            if(null != authList && authList.size() >0){
                Collection<String> perssions = new ArrayList<String>();
                for(Authorization auth:authList){
                    //添加所有的权限标识
                    perssions.add(auth.getPermission());
                }
                info.addStringPermissions(perssions);
            }

            return info;
        }
        return null;
    }

    /**
     *          登录认证
     *
     *          authenticationToken
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

        private String id;             // 编号
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

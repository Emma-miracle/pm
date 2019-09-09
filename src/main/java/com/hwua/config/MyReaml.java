package com.hwua.config;

import com.hwua.po.Sys_Auth;
import com.hwua.po.Sys_Role;
import com.hwua.po.Sys_User;
import com.hwua.service.SysService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MyReaml extends AuthorizingRealm {
    @Autowired
    private SysService sysService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.err.println("-------------------------------doGetAuthenticationInfo------------------------");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+token);
        String username = token.getUsername();
        String password = new String(token.getPassword());
        System.err.println(username);
        System.err.println(password);
        //根据用户名，去查询用户信息，得到用户信息以后，可能会得到一个User对象。
        Sys_User user = sysService.findUserByName(username);
        if(user==null){
            return null;
        }
        if(user.getIs_valid()==1){
            throw new DisabledAccountException("帐号已经禁止登录！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        System.err.println(info);
        return info;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.err.println("-----------------------------------权限验证---------------------------------");
        Sys_User user = (Sys_User) principalCollection.getPrimaryPrincipal();
        List<Sys_Role> roles = sysService.getAllRolesByUser(user.getUsername());
        Set<String> allRoleNames = new HashSet<>();
        for (Sys_Role role:roles){
            allRoleNames.add(role.getRole_name());
        }
        List<Sys_Auth> auths = sysService.getAllAuthsByUser(user.getUsername());
        Set<String> allAuthNames =new HashSet<>();
        for (Sys_Auth a:auths){
            allAuthNames.add(a.getAuth_name());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(allRoleNames);
        info.addStringPermissions(allAuthNames);
        System.err.println(allRoleNames);
        System.err.println(allAuthNames);
        return info;
    }


}

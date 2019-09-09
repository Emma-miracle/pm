package com.hwua.dao;

import com.hwua.po.Sys_Role;
import com.hwua.po.Sys_User_Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    //查询角色个数
    Integer countRole();

    //查询所有角色
    List<Map<String,Object>> getAllRoles();

    //添加角色
    Integer addRole(Sys_Role role);

    //修改角色
    Integer editRole(Sys_Role role);

    //修改 角色 有效/无效
    Integer updateStatus(Sys_Role role);

    //user_role 条数
    Integer countUserRole();

    //查询所有的角色名称
    List<Sys_Role> getRoleName();

    //查询所有拥有角色的用户
    List<Map<String,Object>> getAllUserRoles();

    //添加用户角色 赋角
    Integer addUserRole(Sys_User_Role ur);

    //更新用户 角色
    Integer updateUserRole(Sys_User_Role ur);

}

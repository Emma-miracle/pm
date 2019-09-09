package com.hwua.dao;

import com.hwua.po.Sys_Auth;
import com.hwua.po.Sys_Role_Auth;

import java.util.List;
import java.util.Map;

public interface AuthMapper {
    //查询权限个数
    Integer countAuth();

    //查询所有权限
    List<Map<String,Object>> getAllAuths();

    //查询所有角色所拥有权限的条数
    Integer countRoleAuth(Map<String,Object> map);

    //查询所有角色所拥有的权限
    List<Map<String,Object>> getAllRoleAuths(Map<String,Object> map);

    //查询所有的权限名称
    List<Sys_Auth> getAllAuthName();

    //添加权限
    Integer addAuth(Sys_Auth auth);

    //修改权限
    Integer editAuth(Sys_Auth auth);

    //修改 权限 有效/无效
    Integer updateStatus(Sys_Auth auth);

    //添加角色权限
    Integer addRoleAuth(Sys_Role_Auth roleAuth);

    //修改角色权限
    Integer updateRoleAuth(Sys_Role_Auth roleAuth);

    //删除角色权限
    Integer delRoleAuth(Integer dbid);

}

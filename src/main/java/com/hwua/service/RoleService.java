package com.hwua.service;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Sys_Role;
import com.hwua.po.Sys_User_Role;

import java.util.List;

public interface RoleService {
    //查询所有角色
    JSONObject getAllRoles(Integer page,Integer limit);

    //查询所有拥有角色的用户
    JSONObject getAllUserRoles(Integer page,Integer limit);

    //查询所有的角色名称
    List<Sys_Role> getRoleName();

    //添加或修改角色
    boolean addOrUpdateRole(Sys_Role role);

    //修改 角色 有效/无效
    boolean updateStatus(Sys_Role role);

    //员工角色 赋角
    boolean addOrUpdateUserRole(Sys_User_Role userRole);


}

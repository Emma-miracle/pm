package com.hwua.service;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Sys_Auth;
import com.hwua.po.Sys_Role_Auth;

import java.util.List;

public interface AuthService {

    //查询所有权限
    JSONObject  getAllAuths();

    //查询所有的权限名称
    List<Sys_Auth> getAllAuthName();

    //查询所有角色所拥有的权限
    JSONObject getAllRoleAuths(Integer page,Integer limit,Integer role_id,Integer auth_id);

    //添加或修改权限
    boolean addOrUpdateAuth(Sys_Auth auth);

    //修改 权限 有效/无效
    boolean updateStatus(Sys_Auth auth);

    //添加或编辑角色权限
    boolean addOrUpdateRoleAuth(Sys_Role_Auth roleAuth);

    //删除角色权限 取消授权
    boolean delRoleAuth(Integer dbid);
}

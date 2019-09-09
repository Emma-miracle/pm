package com.hwua.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.hwua.dao.RoleMapper;
import com.hwua.po.Sys_Role;
import com.hwua.po.Sys_User_Role;
import com.hwua.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    //查看所有角色信息
    @Override
    public JSONObject getAllRoles(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> allRoles = roleMapper.getAllRoles();
        String s = JSON.toJSONString(allRoles);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = roleMapper.countRole();
        JSONObject jo = new JSONObject();
        jo.put("data",array);
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("count",count);
        return jo;
    }

    //查询所有拥有角色的用户
    @Override
    public JSONObject getAllUserRoles(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> allUserRoles = roleMapper.getAllUserRoles();
        String s = JSON.toJSONString(allUserRoles);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = roleMapper.countUserRole();
        JSONObject jo = new JSONObject();
        jo.put("data",array);
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("count",count);
        return jo;
    }

    @Override
    public List<Sys_Role> getRoleName() {
        List<Sys_Role> roleName = roleMapper.getRoleName();
        return roleName;
    }

    //添加或编辑角色信息
    @Override
    public boolean addOrUpdateRole(Sys_Role role) {
        if(role.getRole_id()==null){
            //添加角色信息
            Integer add = roleMapper.addRole(role);
            return add==1;
        }else {
            //编辑角色信息
            Integer update = roleMapper.editRole(role);
            return update==1;
        }
    }

    //修改角色信息的状态
    @Override
    public boolean updateStatus(Sys_Role role) {
        role.getIs_valid();
        role.getRole_id();
        Integer update = roleMapper.updateStatus(role);
        return update==1;
    }

    @Override
    public boolean addOrUpdateUserRole(Sys_User_Role userRole) {
        if (userRole.getDbid()==null){
            Integer add = roleMapper.addUserRole(userRole);
            return add==1;
        }else {
            Integer update = roleMapper.updateUserRole(userRole);
            return update==1;
        }
    }
}

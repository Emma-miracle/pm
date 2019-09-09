package com.hwua.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Sys_Role;
import com.hwua.po.Sys_User_Role;
import com.hwua.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 关于角色的增删改查
 *
 *
 *
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    //查询权限列表
    @RequestMapping(value = "/getJsonRoles",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonRoles(Integer page,Integer limit){
        JSONObject jo = roleService.getAllRoles(page, limit);
        return jo.toJSONString();
    }

    //赋予角色 列表
    @RequestMapping(value = "/getJsonUserRoles",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonUserRoles(Integer page,Integer limit){
        JSONObject jo = roleService.getAllUserRoles(page, limit);
        return jo.toJSONString();
    }

    @RequiresPermissions("赋角")
    @RequestMapping("/admin_empRole_edit")
    public ModelAndView userRoleEdit(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role/admin_empRole_edit");
        List<Sys_Role> roleName = roleService.getRoleName();
        mv.addObject("empRole",roleName);
        return mv;
    }

    @RequiresPermissions("赋角")
    @RequestMapping(value = "/addOrUpdateEmpRole",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateRoleAuth(Sys_User_Role userRole){
        boolean addOrUpdate = roleService.addOrUpdateUserRole(userRole);
        return addOrUpdate?"ok":"no";
    }

    @RequiresPermissions("编辑角色")
    @RequestMapping(value = "/addOrUpdateRole",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateRole(Sys_Role role){
        System.out.println(role);
        boolean addOrUpdate = roleService.addOrUpdateRole(role);
        return addOrUpdate?"ok":"no";
    }

    @RequiresPermissions("禁用角色")
    @RequestMapping(value = "/updateRoleStatus",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateRoleStatus(Sys_Role role){
        System.out.println(">>>>>>>>>>>>>>>>>>"+role);
        boolean update = roleService.updateStatus(role);

        return update?"ok":"no";
    }



}

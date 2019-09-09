package com.hwua.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Sys_Auth;
import com.hwua.po.Sys_Role;
import com.hwua.po.Sys_Role_Auth;
import com.hwua.service.AuthService;
import com.hwua.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 关于权限的增删改查
 *
 *
 *
 */
@Controller
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private RoleService roleService;
    //查询权限列表
    @RequestMapping(value = "/getJsonAuths",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonAuths(){
        JSONObject jo = authService.getAllAuths();
        return jo.toJSONString();
    }

    //查询所有角色所拥有的权限
    @RequestMapping(value = "/getJsonRoleAuths",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonRoleAuths(Integer page,Integer limit,Integer role_id,Integer auth_id){
        JSONObject jo = authService.getAllRoleAuths(page,limit,role_id,auth_id);
        return jo.toJSONString();
    }

    @RequiresPermissions("授予权限")
    @RequestMapping("/roleAuth/list")
    public ModelAndView roleAuthList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("auth/admin_roleAuth");
        List<Sys_Auth> allAuthName = authService.getAllAuthName();
        mv.addObject("authName",allAuthName);
        List<Sys_Role> roleName = roleService.getRoleName();
        mv.addObject("roleName",roleName);
        return mv;
    }

    @RequiresPermissions("授权")
    @RequestMapping("/admin_roleAuth_edit")
    public ModelAndView roleAuthEdit(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("auth/admin_roleAuth_edit");
        List<Sys_Auth> allAuthName = authService.getAllAuthName();
        mv.addObject("authName",allAuthName);
        List<Sys_Role> roleName = roleService.getRoleName();
        mv.addObject("roleName",roleName);
        return mv;
    }
    @RequiresPermissions("授权")
    @RequestMapping(value = "/addOrUpdateRoleAuth",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateRoleAuth(Sys_Role_Auth roleAuth){
        boolean addOrUpdate = authService.addOrUpdateRoleAuth(roleAuth);
        return addOrUpdate?"ok":"no";
    }



    @RequiresPermissions("取消授权")
    @RequestMapping(value = "/delRoleAuth",produces ="text/html;charset=utf-8")
    @ResponseBody
    public String delRoleAuth(Integer dbid){
        boolean delRoleAuth = authService.delRoleAuth(dbid);
        return delRoleAuth?"ok":"no";
    }



    @RequiresPermissions("编辑权限")
    @RequestMapping(value = "/addOrUpdateAuth",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateAuth(Sys_Auth auth){
        boolean addOrUpdate = authService.addOrUpdateAuth(auth);
        return addOrUpdate?"ok":"no";
    }

    @RequiresPermissions("禁用权限")
    @RequestMapping(value = "/updateAuthStatus",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateStatus(Sys_Auth auth){
        boolean update = authService.updateStatus(auth);

        return update?"ok":"no";
    }



}

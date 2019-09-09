package com.hwua.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Dept;
import com.hwua.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 关于部门的增删改查
 *
 *
 *
 */
@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    //查询部门列表
    @RequestMapping(value = "/getJsonDepts",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonDepts(Integer page,Integer limit){
        JSONObject jo = deptService.getAllDepts(page,limit);
        return jo.toJSONString();
    }

    @RequiresPermissions("添加部门")
    @RequestMapping("/admin_dept_add")
    public ModelAndView deptAdd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dept/admin_dept_edit");
        List<Map<String,Object>> deptManager = deptService.getDeptManager();
        mv.addObject("manager",deptManager);
        mv.addObject("add","no");
        return mv;
    }

    @RequiresPermissions("编辑部门")
    @RequestMapping("/admin_dept_edit")
    public ModelAndView deptEdit(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dept/admin_dept_edit");
        List<Map<String,Object>> deptManager = deptService.getDeptManager();
        mv.addObject("manager",deptManager);
        return mv;
    }

    //添加或编辑部门列表
    @RequestMapping(value = "/addOrUpdateDept",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateDept(Dept dept){
        System.out.println(dept);
        boolean addOrUpdate = deptService.addOrUpdateDept(dept);
        return addOrUpdate?"ok":"no";
    }

    @RequiresPermissions("删除部门")
    @RequestMapping(value = "/delDept",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delDept(Integer dept_id){
        boolean del = deptService.delDept(dept_id);
        return del?"ok":"no";
    }

    @RequiresPermissions("删除部门")
    @RequestMapping(value = "/delDepts",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String delDepts(@RequestParam("ids") List<Integer> ids){
        boolean dels = deptService.delDepts(ids);
        return dels?"ok":"no";
    }







}

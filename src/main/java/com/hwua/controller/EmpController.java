package com.hwua.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.*;
import com.hwua.service.DeptService;
import com.hwua.service.EmpService;
import com.hwua.service.JobService;
import com.hwua.service.SysService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 关于员工的增删改查
 *
 *
 *
 */
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private JobService jobService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private SysService sysService;
    //查询员工列表
    @RequestMapping(value = "/getJsonEmps",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonEmps(Integer page,Integer limit,String keyword,Integer sex){
        JSONObject jo = empService.getAllEmps(page,limit,keyword,sex);
        return jo.toJSONString();
    }
    //个人信息
    @RequestMapping("/emp/info")
    public ModelAndView empInfo(String username){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("emp/admin_emp_info");
        Sys_User userByName = sysService.findUserByName(username);
        mv.addObject("user",userByName);
        List<Job> jobType = jobService.getJobName();
        mv.addObject("jobName",jobType);
        List<Dept> deptType = deptService.getDeptName();
        mv.addObject("deptType",deptType);
        return mv;
    }

    //员工信息
    @RequiresPermissions("添加员工")
    @RequestMapping("/admin_emp_add")
    public ModelAndView empAdd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("emp/admin_emp_edit");
        List<Job> jobType = jobService.getJobName();
        mv.addObject("jobName",jobType);
        List<Dept> deptType = deptService.getDeptName();
        mv.addObject("deptType",deptType);
        return mv;
    }

    //验证帐号是否重复
    @RequestMapping(value = "/checkEmp",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkEmp(String username){
        Sys_User userByName = sysService.findUserByName(username);
        JSONObject jo = new JSONObject();

        if (userByName==null){
            jo.put("status","ok");
            System.err.println("没有重复的帐号");
        }else {
            jo.put("status","no");
            jo.put("msg","帐号已存在,请重新输入");
        }

        return jo.toJSONString();
    }

    //验证手机号是否在数据库中


    @RequiresPermissions("编辑员工")
    @RequestMapping("/admin_emp_edit")
    public ModelAndView empEdit(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("emp/admin_emp_edit");
        List<Job> jobType = jobService.getJobName();
        mv.addObject("jobName",jobType);
        List<Dept> deptType = deptService.getDeptName();
        mv.addObject("deptType",deptType);
        mv.addObject("bj","yg");
        return mv;
    }



    @RequestMapping(value = "/addOrUpdateEmp",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateEmp(/*String hiredate,*/Sys_User emp) throws ParseException {
        System.out.println(emp);

        //密码
        //用户输入的密码
        String password = emp.getPassword();
        System.err.println("------------------------------未加密的密码："+password);
        String username = emp.getUsername();
        System.err.println(username);
        Md5Hash hash = new Md5Hash(password,username,3);
        password = hash.toString();
        emp.setPassword(password);
        System.err.println("------------------------------加密后的密码："+password);
        boolean addOrUpdate = empService.addOrUpdateEmp(emp);
        return addOrUpdate?"ok":"no";
    }

    @RequiresPermissions("禁用员工")
    @RequestMapping(value = "/updateEmpStatus",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateEmpStatus(Sys_User emp){
        System.out.println(">>>>>>>>>>>>>>>>>>"+emp);
        boolean update = empService.updateStatus(emp);
        return update?"ok":"no";
    }

    //查询请假记录列表
    @RequestMapping(value = "/getJsonLeaves",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonLeaves(Integer page,Integer limit){
        JSONObject jo = empService.getAllLeaveRecord(page,limit);
        return jo.toJSONString();
    }
    @RequiresPermissions("请假")
    @RequestMapping("emp/leave")
    public String leaveEdit(){
        return "leave/admin_leave_edit";
    }

    @RequiresPermissions("请假")
    @RequestMapping(value = "/addOrUpdateLeave",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateLeave(Leave_Record leaveRecord){
        boolean addOrUpdate = empService.addAndEditLeaveRecord(leaveRecord);
        return addOrUpdate?"ok":"no";
    }

    //查询出差记录列表
    @RequestMapping(value = "/getJsonTrips",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonTrips(Integer page,Integer limit){
        JSONObject jo = empService.getAllTripRecord(page,limit);
        return jo.toJSONString();
    }

    @RequiresPermissions("出差")
    @RequestMapping("emp/trip")
    public String tripEdit(){
        return "emp_trip_edit";
    }

    @RequiresPermissions("出差")
    @RequestMapping(value = "/addOrUpdateTrip",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateTrip(Trip_Record tripRecord){
        boolean addOrUpdate = empService.addAndEditTripRecord(tripRecord);
        return addOrUpdate?"ok":"no";
    }

    //处理时间
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }


}

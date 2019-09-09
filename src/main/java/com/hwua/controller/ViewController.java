package com.hwua.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/sys")
public class ViewController {

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/forget")
    public String forget(){
        return "forget_pass";
    }



    /*//进入管理列表界面
    @RequestMapping("/{param}/list")
    public String manageList(@PathVariable String param){
        return param+"/admin_"+param;
    }
*/





    //进入管理列表界面
    @RequiresPermissions("权限管理")
    @RequestMapping("/auth/list")
    public String authList(){
        return "auth/admin_auth";
    }


    @RequiresPermissions("角色管理")
    @RequestMapping("/role/list")
    public String roleList(){
        return "role/admin_role";
    }

    @RequiresPermissions("赋予角色")
    @RequestMapping("/userRole/list")
    public String userRoleList(){
        return "role/admin_empRole";
    }





    @RequiresPermissions("职务信息")
    @RequestMapping("/job/list")
    public String jobList(){
        return "job/admin_job";
    }


    @RequiresPermissions("部门信息")
    @RequestMapping("/dept/list")
    public String deptList(){
        return "dept/admin_dept";
    }



    @RequiresPermissions("员工信息")
    @RequestMapping("/emp/list")
    public String userList(){
        return "emp/admin_emp";
    }

    @RequiresPermissions("请假记录")
    @RequestMapping("/leave/list")
    public String leaveList(){
        return "leave/admin_leave";
    }

    @RequiresPermissions("出差记录")
    @RequestMapping("/trip/list")
    public String tripList(){
        return "trip/admin_trip";
    }



    @RequiresPermissions("个人银行账户")
    @RequestMapping("/pbank/list")
    public String pBankList(){
        return "pbank/admin_pbank";
    }




    //进入添加或修改界面

    //权限
    @RequiresPermissions("添加权限")
    @RequestMapping("/admin_auth_add")
    public String authAdd(){
        return "auth/admin_auth_edit";
    }

    @RequiresPermissions("编辑权限")
    @RequestMapping("/admin_auth_edit")
    public String authEdit(){
        return "auth/admin_auth_edit";
    }

    //角色
    @RequiresPermissions("添加角色")
    @RequestMapping("/admin_role_add")
    public String roleAdd(){
        return "role/admin_role_edit";
    }

    @RequiresPermissions("编辑角色")
    @RequestMapping("/admin_role_edit")
    public String roleEdit(){
        return "role/admin_role_edit";
    }





    //职务信息
    @RequiresPermissions("添加职务")
    @RequestMapping("/admin_job_add")
    public String jobAdd(){
        return "job/admin_job_edit";
    }

    @RequiresPermissions("编辑职务")
    @RequestMapping("/admin_job_edit")
    public String jobEdit(){
        return "job/admin_job_edit";
    }






}

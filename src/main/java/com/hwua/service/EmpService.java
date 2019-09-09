package com.hwua.service;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Leave_Record;
import com.hwua.po.Sys_User;
import com.hwua.po.Trip_Record;

public interface EmpService {

    //查询所有员工信息
    JSONObject getAllEmps(Integer page,Integer limit,String keyword,Integer sex);

    //添加或修改员工信息
    boolean addOrUpdateEmp(Sys_User emp);

    //修改 员工（用户） 有效/无效
    boolean updateStatus(Sys_User emp);

    //查询 员工的请假记录
    JSONObject getAllLeaveRecord(Integer page,Integer limit);

    //查询员工的出差记录
    JSONObject getAllTripRecord(Integer page,Integer limit);

    //请假

    boolean addAndEditLeaveRecord(Leave_Record leaveRecord);

    boolean updateLeaveStatus(Leave_Record leaveRecord);

    //出差

    boolean addAndEditTripRecord(Trip_Record tripRecord);


}

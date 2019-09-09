package com.hwua.dao;

import com.hwua.po.Leave_Record;
import com.hwua.po.Sys_User;
import com.hwua.po.Trip_Record;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    //查询员工个数
    Integer countEmp(Map<String,Object> map);

    //查询所有员工信息
    List<Map<String,Object>> getAllEmps(Map<String,Object> map);

    //添加员工信息
    Integer addEmp(Sys_User emp);

    //修改员工信息
    Integer editEmp(Sys_User emp);

    //修改 员工（用户） 有效/无效
    Integer updateStatus(Sys_User emp);

    //查询员工请假记录的条数
    Integer countLeave();

    //查询 员工的请假记录
    List<Map<String,Object>> getAllLeaveRecord();

    //查询员工出差记录的条数
    Integer countTrip();

    //查询员工的出差记录
    List<Map<String,Object>> getAllTripRecord();

    //请假

    Integer addLeaveRecord(Leave_Record leaveRecord);

    Integer editLeaveRecord(Leave_Record leaveRecord);

    Integer updateLeaveStatus(Leave_Record leaveRecord);

    //出差

    Integer addTripRecord(Trip_Record tripRecord);

    Integer editTripRecord(Trip_Record tripRecord);

}

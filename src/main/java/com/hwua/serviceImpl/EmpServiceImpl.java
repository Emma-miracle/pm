package com.hwua.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.hwua.dao.EmpMapper;
import com.hwua.po.Leave_Record;
import com.hwua.po.Sys_User;
import com.hwua.po.Trip_Record;
import com.hwua.service.EmpService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public JSONObject getAllEmps(Integer page,Integer limit,String keyword,Integer sex) {
        PageHelper.startPage(page,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("keyword",keyword);
        map.put("sex",sex);
        List<Map<String, Object>> allEmps = empMapper.getAllEmps(map);
        String s = JSON.toJSONString(allEmps);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = empMapper.countEmp(map);
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("data",array);
        jo.put("count",count);
        return jo;
    }

    @Override
    public boolean addOrUpdateEmp(Sys_User emp) {
        if(emp.getUser_id()==null){
            //添加员工
            Integer add = empMapper.addEmp(emp);
            return add==1;
        }else {

            //编辑员工 修改员工信息
            Integer update = empMapper.editEmp(emp);
            return update==1;
        }
    }


    @Override
    public boolean updateStatus(Sys_User emp) {

        Integer update = empMapper.updateStatus(emp);

        return update==1;
    }

    @Override
    public JSONObject getAllLeaveRecord(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> allLeaveRecord = empMapper.getAllLeaveRecord();
        String s = JSON.toJSONString(allLeaveRecord);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = empMapper.countLeave();
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("data",array);
        jo.put("count",count);
        return jo;
    }

    @Override
    public JSONObject getAllTripRecord(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> allTripRecord = empMapper.getAllTripRecord();
        String s = JSON.toJSONString(allTripRecord);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = empMapper.countTrip();
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("data",array);
        jo.put("count",count);
        return jo;
    }

    @Override
    public boolean addAndEditLeaveRecord(Leave_Record leaveRecord) {
        if(leaveRecord.getLeave_id()==null){
            Integer add = empMapper.addLeaveRecord(leaveRecord);
            return add==1;
        }else {
            Integer update = empMapper.editLeaveRecord(leaveRecord);
            return update==1;
        }
    }

    @Override
    public boolean updateLeaveStatus(Leave_Record leaveRecord) {
        Integer update = empMapper.updateLeaveStatus(leaveRecord);
        return update==1;
    }

    @Override
    public boolean addAndEditTripRecord(Trip_Record tripRecord) {
        if (tripRecord.getTrip_id()==null){
            Integer add = empMapper.addTripRecord(tripRecord);
            return add==1;
        }else {
            Integer update = empMapper.editTripRecord(tripRecord);
            return update==1;
        }
    }


}

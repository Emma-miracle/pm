package com.hwua.service;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {

    //查询所有部门信息
    JSONObject getAllDepts(Integer page,Integer limit);

    //查询部门编号和部门名称
    List<Dept> getDeptName();

    //查询部门经理 部门经理编号
    List<Map<String,Object>> getDeptManager();

    //添加或修改部门信息
    boolean addOrUpdateDept(Dept dept);

    //删除单条
    boolean delDept(Integer dept_id);

    //批量删除
    boolean delDepts(List<Integer> ids);


}

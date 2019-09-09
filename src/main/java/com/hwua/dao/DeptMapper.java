package com.hwua.dao;

import com.hwua.po.Dept;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    //查询部门信息条数
    Integer countDept();

    //查询所有部门信息
    List<Map<String,Object>> getAllDepts();

    //查询部门编号和部门名称
    List<Dept> getDeptName();

    //查询部门经理 部门经理编号
    List<Map<String,Object>> getDeptManager();

    //添加部门信息
    Integer addDept(Dept dept);

    //修改部门信息
    Integer editDept(Dept dept);
    //删除单条
    Integer delDept(Integer dept_id);

    //批量删除
    Integer delDepts(List<Integer> ids);

}

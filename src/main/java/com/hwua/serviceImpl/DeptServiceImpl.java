package com.hwua.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.hwua.dao.DeptMapper;
import com.hwua.po.Dept;
import com.hwua.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    //查看所有部门信息
    @Override
    public JSONObject getAllDepts(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> allDepts = deptMapper.getAllDepts();
        String s = JSON.toJSONString(allDepts);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = deptMapper.countDept();
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("data",array);
        jo.put("count",count);
        return jo;
    }

    @Override
    public List<Dept> getDeptName() {
        List<Dept> deptName = deptMapper.getDeptName();
        return deptName;
    }

    @Override
    public List<Map<String,Object>> getDeptManager() {
        List<Map<String,Object>> deptManager = deptMapper.getDeptManager();
        return deptManager;
    }

    //更新或添加部门信息
    @Override
    public boolean addOrUpdateDept(Dept dept) {
        if(dept.getDept_id()==null){
            Integer add = deptMapper.addDept(dept);
            return add==1;
        }else {
            Integer update = deptMapper.editDept(dept);
            return update==1;
        }
    }

    //删除单条部门信息
    @Override
    public boolean delDept(Integer dept_id) {
        Integer del = deptMapper.delDept(dept_id);
        return del==1;
    }


    //批量删除部门信息
    @Override
    public boolean delDepts(List<Integer> ids) {
        Integer dels = deptMapper.delDepts(ids);
        return dels!=0;
    }

}

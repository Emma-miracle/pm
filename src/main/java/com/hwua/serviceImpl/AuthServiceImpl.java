package com.hwua.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.hwua.dao.AuthMapper;
import com.hwua.po.Sys_Auth;
import com.hwua.po.Sys_Role_Auth;
import com.hwua.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthMapper authMapper;
    //查看所有权限
    @Override
    public JSONObject getAllAuths() {
        List<Map<String, Object>> allAuths = authMapper.getAllAuths();
        String s = JSON.toJSONString(allAuths);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = authMapper.countAuth();
        JSONObject jo = new JSONObject();
        jo.put("data",array);
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("count",count);
        return jo;
    }

    @Override
    public List<Sys_Auth> getAllAuthName() {
        List<Sys_Auth> allAuthName = authMapper.getAllAuthName();
        return allAuthName;
    }

    @Override
    public JSONObject getAllRoleAuths(Integer page,Integer limit,Integer role_id,Integer auth_id) {
        PageHelper.startPage(page,limit);
        Map<String,Object> map = new HashMap<>();
        map.put("role_id",role_id);
        map.put("auth_id",auth_id);
        List<Map<String, Object>> allRoleAuths = authMapper.getAllRoleAuths(map);
        String s = JSON.toJSONString(allRoleAuths);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = authMapper.countRoleAuth(map);
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("data",array);
        jo.put("count",count);
        return jo;
    }


    //添加或修改权限
    @Override
    public boolean addOrUpdateAuth(Sys_Auth auth) {
        if(auth.getAuth_id()==null){
            //添加权限
            Integer add = authMapper.addAuth(auth);
            return add==1;

        }else {
            //修改权限
            Integer edit = authMapper.editAuth(auth);
            return edit==1;
        }
    }

    @Override
    public boolean updateStatus(Sys_Auth auth) {
        Integer is_valid = auth.getIs_valid();
        System.err.println(is_valid);
        Integer auth_id = auth.getAuth_id();
        System.err.println(auth_id);
        Integer update = authMapper.updateStatus(auth);
        return update==1;
    }

    @Override
    public boolean addOrUpdateRoleAuth(Sys_Role_Auth roleAuth) {
        if (roleAuth.getDbid()==null){
            Integer add = authMapper.addRoleAuth(roleAuth);
            return add==1;
        }else {
            Integer update = authMapper.updateRoleAuth(roleAuth);
            return update==1;
        }
    }

    @Override
    public boolean delRoleAuth(Integer dbid) {
        Integer del = authMapper.delRoleAuth(dbid);
        return del==1;
    }
}

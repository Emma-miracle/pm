package com.hwua.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.hwua.dao.AccountMapper;
import com.hwua.po.CBank;
import com.hwua.po.PBank;
import com.hwua.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    //公司银行账户

    @Override
    public List<Map<String, Object>> getAllCBank() {
        List<Map<String, Object>> allCBank = accountMapper.getAllCBank();
        return allCBank;
    }

    @Override
    public boolean addOrEditCBank(CBank cBank) {
        if(cBank.getCbank_id()==null){
            Integer add = accountMapper.addCBank(cBank);
            return add==1;
        }else {
            Integer update = accountMapper.editCBank(cBank);
            return update==1;
        }
    }

    //员工银行账户

    @Override
    public JSONObject getAllPBank(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> allPBank = accountMapper.getAllPBank();
        String s = JSON.toJSONString(allPBank);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = accountMapper.countPBank();
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("data",array);
        jo.put("count",count);
        return jo;
    }

    @Override
    public boolean addOrEditPBank(PBank pBank) {
        if (pBank.getPbank_id()==null){
            Integer add = accountMapper.addPBank(pBank);
            return add==1;
        }else {
            Integer update = accountMapper.editPBank(pBank);
            return update==1;
        }
    }

}

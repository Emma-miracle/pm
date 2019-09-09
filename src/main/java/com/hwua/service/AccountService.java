package com.hwua.service;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.CBank;
import com.hwua.po.PBank;

import java.util.List;
import java.util.Map;



public interface AccountService {
    //公司银行账户

    List<Map<String,Object>> getAllCBank();

    boolean addOrEditCBank(CBank cBank);



    //员工银行账户

    JSONObject getAllPBank(Integer page,Integer limit);

    boolean addOrEditPBank(PBank pBank);


}

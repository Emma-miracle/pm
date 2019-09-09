package com.hwua.service;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.CBank;
import com.hwua.po.PBank;

import java.util.List;
import java.util.Map;

/**
 * @Author:王新凤
 * @Date:2019/1/19 22:27
 * @Version 1.0
 */


public interface AccountService {
    //公司银行账户

    List<Map<String,Object>> getAllCBank();

    boolean addOrEditCBank(CBank cBank);



    //员工银行账户

    JSONObject getAllPBank(Integer page,Integer limit);

    boolean addOrEditPBank(PBank pBank);


}

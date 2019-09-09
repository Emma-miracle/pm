package com.hwua.dao;

import com.hwua.po.CBank;
import com.hwua.po.PBank;

import java.util.List;
import java.util.Map;

/**
 * @Author:王新凤
 * @Date:2019/1/19 18:49
 * @Version 1.0
 */


public interface AccountMapper {

    //公司银行账户

    Integer countCBank();

    List<Map<String,Object>> getAllCBank();

    Integer addCBank(CBank cBank);

    Integer editCBank(CBank cBank);


    //员工银行账户

    Integer countPBank();

    List<Map<String,Object>> getAllPBank();

    Integer addPBank(PBank pBank);

    Integer editPBank(PBank pBank);

}

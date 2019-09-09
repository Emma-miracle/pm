package com.hwua.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.CBank;
import com.hwua.po.PBank;
import com.hwua.service.AccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author:王新凤
 * @Date:2019/1/19 22:41
 * @Version 1.0
 */

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    //查看公司银行账户

    @RequiresPermissions("公司银行账户")
    @RequestMapping("/cbank/list")
    public ModelAndView cBankList(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cbank/admin_cbank");
        List<Map<String, Object>> allCBank = accountService.getAllCBank();
        mv.addObject("cbank",allCBank);
        return mv;
    }


    //添加或编辑操作
    @RequiresPermissions("编辑公司账户")
    @RequestMapping(value = "/addOrUpdateCBank",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdateCBank(CBank cBank){
        boolean addOrUpdate = accountService.addOrEditCBank(cBank);
        return addOrUpdate?"ok":"no";
    }



    //查看员工银行账户
    @RequestMapping(value = "/getJsonPBanks",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getJsonPBanks(Integer page,Integer limit){
        JSONObject jo = accountService.getAllPBank(page,limit);
        return jo.toJSONString();
    }


    //添加和编辑页面
    @RequiresPermissions("编辑个人账户")
    @RequestMapping("/admin_pbank_edit")
    public String pbankAdd(){
        return "pbank/admin_pbank_edit";
    }


    //添加或编辑操作

    @RequestMapping(value = "/addOrUpdatePBank",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addOrUpdatePBank(PBank pBank){
        boolean addOrUpdate = accountService.addOrEditPBank(pBank);
        return addOrUpdate?"ok":"no";
    }


}

package com.hwua.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Job;
import com.hwua.service.JobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 关于职务的增删改查
 *
 *
 *
 */
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping("/getJsonJobs")
    public String getJsonJobs(Integer page,Integer limit){
        JSONObject jo = jobService.getAllJobs(page,limit);
        return jo.toJSONString();
    }

    @RequestMapping("/addOrUpdateJob")
    public String addOrUpdateJob(Job job){
        boolean addOrUpdateJob = jobService.addOrUpdateJob(job);
        return addOrUpdateJob?"ok":"no";
    }

    @RequiresPermissions("删除职务")
    @RequestMapping("/delJob")
    public String delJob(Integer job_id){
        boolean delJob = jobService.delJob(job_id);
        return delJob?"ok":"no";
    }

    @RequiresPermissions("删除职务")
    @RequestMapping("/delJobs")
    public String delJobs(@RequestParam("ids") List<Integer> ids){
        boolean delJobs = jobService.delJobs(ids);
        return delJobs?"ok":"no";
    }



}

package com.hwua.service;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Job;

import java.util.List;

public interface JobService {


    //查询所有职务信息
    JSONObject getAllJobs(Integer page,Integer limit);

    //查询职务id 职务名称
    List<Job> getJobName();

    //查询不重复的职务类型
    List<Job> getJobType();

    //添加或编辑职务信息
    boolean addOrUpdateJob(Job job);

    //删除单条
    boolean delJob(Integer job_id);

    //批量删除
    boolean delJobs(List<Integer> ids);


}

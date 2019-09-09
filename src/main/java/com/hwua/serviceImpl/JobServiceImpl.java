package com.hwua.serviceImpl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.hwua.dao.JobMapper;
import com.hwua.po.Job;
import com.hwua.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    //查看所有职务信息
    @Override
    public JSONObject getAllJobs(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> allJobs = jobMapper.getAllJobs();
        String s = JSON.toJSONString(allJobs);
        JSONArray array = JSONArray.parseArray(s);
        Integer count = jobMapper.countJob();
        JSONObject jo = new JSONObject();
        jo.put("code",0);
        jo.put("msg","ok");
        jo.put("data",array);
        jo.put("count",count);
        return jo;
    }

    @Override
    public List<Job> getJobName() {
        List<Job> jobName = jobMapper.getJobName();
        return jobName;
    }

    @Override
    public List<Job> getJobType() {
        List<Job> jobType = jobMapper.getJobType();
        return jobType;
    }

    //添加 和 更新 职务信息
    @Override
    public boolean addOrUpdateJob(Job job) {
        if(job.getJob_id()==null){
            //添加职务
            Integer add = jobMapper.addJob(job);
            return add==1;
        }else {
            //编辑职务
            Integer update = jobMapper.editJob(job);
            return update==1;
        }
    }

    @Override
    public boolean delJob(Integer job_id) {
        Integer del = jobMapper.delJob(job_id);
        return del==1;
    }

    //删除
    @Override
    public boolean delJobs(List<Integer> ids) {
        Integer dels = jobMapper.delJobs(ids);
        return dels!=0;
    }
}

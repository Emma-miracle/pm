package com.hwua.dao;

import com.hwua.po.Job;

import java.util.List;
import java.util.Map;

public interface JobMapper {
    //查询职务信息条数
    Integer countJob();

    //查询所有职务信息
    List<Map<String,Object>> getAllJobs();

    //查询职务id 职务名称
    List<Job> getJobName();

    //查询不重复的职务类型
    List<Job> getJobType();

    //添加职务信息
    Integer addJob(Job job);

    //修改职务信息
    Integer editJob(Job job);

    //删除单条
    Integer delJob(Integer job_id);

    //批量删除
    Integer delJobs(List<Integer> ids);

}

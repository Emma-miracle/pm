package com.hwua.service;

/**
 * @Author:王新凤
 * @Date:2019/1/22 15:01
 * @Version 1.0
 */


public interface CountService {
    //查询员工个数
    Integer countEmps();

    //查询职务个数
    Integer countJobs();

    //查询部门个数
    Integer countDepts();

    //查询权限个数
    Integer countAuths();
}

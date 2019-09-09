package com.hwua.dao;

/**
 * @Author:王新凤
 * @Date:2019/1/22 14:55
 * @Version 1.0
 */


public interface CountMapper {
    //查询员工个数
    Integer countEmps();

    //查询职务个数
    Integer countJobs();

    //查询部门个数
    Integer countDepts();

    //查询权限个数
    Integer countAuths();



}

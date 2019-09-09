package com.hwua.dao;



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

package com.hwua.serviceImpl;

import com.hwua.dao.CountMapper;
import com.hwua.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;

/**
 * @Author:王新凤
 * @Date:2019/1/22 15:02
 * @Version 1.0
 */

@Service
public class CountServiceImpl implements CountService {
    @Autowired
    private CountMapper countMapper;
    @Override
    public Integer countEmps() {
        Integer empCount = countMapper.countEmps();
        return empCount;
    }

    @Override
    public Integer countJobs() {
        Integer jobCount = countMapper.countJobs();
        return jobCount;
    }

    @Override
    public Integer countDepts() {
        Integer deptCount = countMapper.countDepts();
        return deptCount;
    }

    @Override
    public Integer countAuths() {
        Integer authCount = countMapper.countAuths();
        return authCount;
    }
}

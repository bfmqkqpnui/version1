package com.emp.service.impl;

import com.emp.domain.Employee;
import com.emp.mapper.EmpMapper;
import com.emp.service.EmpService;
import com.limovue.common.util.CommonUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Employee> queryAll() {
        return empMapper.queryAll();
    }

    @Override
    public List<Employee> queryByParams(Map<String, Object> param) {
        List<Employee> emps = null;
        if (CommonUtils.isExist(param)) {
            emps = empMapper.queryByParams(param);
        }
        return emps;
    }

}

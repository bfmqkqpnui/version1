package com.emp.service.impl;

import com.emp.dao.EmployeeDao;
import com.emp.domain.Employee;
import com.emp.service.EmployeeService;
import com.limovue.common.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public List<Employee> queryAll() {
        return dao.findAll();
    }

    @Override
    public List<Employee> queryByParams(Map<String, Object> param) {
        return null;
    }
}

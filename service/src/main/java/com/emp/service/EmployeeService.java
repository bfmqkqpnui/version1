package com.emp.service;

import com.emp.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    /**
     * 查询所有职员信息
     * @return
     */
    List<Employee> queryAll();

    /**
     * 根据条件查询
     * @param param
     * @return
     */
    List<Employee> queryByParams(Map<String,Object> param);
}

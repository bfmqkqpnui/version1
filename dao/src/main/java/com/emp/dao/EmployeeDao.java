package com.emp.dao;

import com.emp.domain.Employee;
import com.emp.vo.QueryEmpParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {

    /**
     * 查询所有
     *
     * @return
     */
    List<Employee> findAll();

    /**
     * 更新
     *
     * @param params
     * @return
     */
    int updateByParams(QueryEmpParams params);

    /**
     * 新增
     *
     * @param params
     * @return
     */
    int addByParams(QueryEmpParams params);

    /**
     * 删除(物理删除)
     *
     * @param id
     * @return
     */
    int delById(Integer id);

    /**
     * 批量新增
     *
     * @param params
     * @return
     */
    int batchSave(@Param("emps") List<QueryEmpParams> params);
}

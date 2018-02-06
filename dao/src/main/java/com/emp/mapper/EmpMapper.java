package com.emp.mapper;

import com.emp.domain.Employee;
import com.emp.query.EmpProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "EmpMapper")
public interface EmpMapper {


    /**
     * 根据不同的条件查询
     *
     * @param param
     * @return
     */
    @SelectProvider(type = EmpProvider.class, method = "queryByParams")
    List<Employee> queryByParams(Map<String, Object> param);

    /**
     * 查询所有的数据
     *
     * @return
     */
    @SelectProvider(type = EmpProvider.class, method = "queryAll")
    List<Employee> queryAll();
}

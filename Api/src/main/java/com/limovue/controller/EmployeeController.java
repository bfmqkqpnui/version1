package com.limovue.controller;

import com.emp.domain.Employee;
import com.emp.service.EmpService;
import com.emp.service.EmployeeService;
import com.emp.vo.QueryEmpParams;
import com.limovue.common.ReturnDTO;
import com.limovue.common.util.CommonUtils;
import com.limovue.common.util.JedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    /**
     * 查询所有职员信息
     *
     * @return
     */
    @RequestMapping(value = "/emp/queryAll", method = {RequestMethod.GET, RequestMethod.POST})
    public ReturnDTO queryAllEmployee() {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);

        List<Employee> empList = service.queryAll();

        if (CommonUtils.isExist(empList)) {
            dto.setSuccess(true);
            dto.setResCode("200");
            dto.setObj(empList);
        } else {
            dto.setResCode("801");
            dto.setErrMsg("数据库中未查询到相关数据");
        }
        //JedisUtil.getJedis();
        return dto;
    }

    /**
     * 查询满足条件的所有职员信息
     *
     * @return
     */
    @RequestMapping("/emp/queryEmpByParams")
    public ReturnDTO queryEmpByParams(@RequestBody QueryEmpParams params) {
        ReturnDTO dto = new ReturnDTO();
        dto.setSuccess(false);
        if (null != params) {
            Integer id = params.getId();
            String birthday = params.getBirthday();
            String email = params.getEmail();
            String gender = params.getGender();
            String name = params.getName();

            if (null != id || StringUtils.isNotBlank(birthday) || StringUtils.isNotBlank(email) || StringUtils.isNotBlank(gender) || StringUtils.isNotBlank(name)) {
                Map<String, Object> param = new HashMap<String, Object>();

                if (null != id) {
                    param.put("id", id);
                }
                if (StringUtils.isNotBlank(birthday)) {
                    param.put("birthday", birthday);
                }
                if (StringUtils.isNotBlank(email)) {
                    param.put("email", email);
                }
                if (StringUtils.isNotBlank(gender)) {
                    param.put("gender", gender);
                }
                if (StringUtils.isNotBlank(name)) {
                    param.put("name", name);
                }

                List<Employee> emps = service.queryByParams(param);

                if (CommonUtils.isExist(emps)) {
                    dto.setSuccess(true);
                    dto.setResCode("200");
                    dto.setObj(emps);
                } else {
                    dto.setResCode("800");
                    dto.setErrMsg("未查询到数据");
                }
            }
        } else {
            List<Employee> empList = service.queryAll();
            if (CommonUtils.isExist(empList)) {
                dto.setSuccess(true);
                dto.setResCode("200");
                dto.setObj(empList);
            } else {
                dto.setResCode("802");
                dto.setErrMsg("数据库中未查询到相关数据");
            }
        }

        return dto;
    }
}

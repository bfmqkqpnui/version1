package com.emp.query;

import com.limovue.common.util.CommonUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 职员构建sql实体类
 */
public class EmpProvider {
    /**
     * 查询所有满足条件的职员
     *
     * @param param
     * @return
     */
    public String queryByParams(Map<String, Object> param) {
        if (CommonUtils.isExist(param)) {
            return new SQL() {{
                SELECT("id,name,gender,birthday,email,remark");
                FROM("employee");
                if (param.get("id") != null && param.get("id").toString() != "") {
                    WHERE("id = #{id}");
                }
                if (param.get("birthday") != null && param.get("birthday").toString() != "") {
                    WHERE("birthday = #{birthday}");
                }
                if (param.get("email") != null && param.get("email").toString() != "") {
                    WHERE("email = #{email}");
                }
                if (param.get("gender") != null && param.get("gender").toString() != "") {
                    WHERE("gender = #{gender}");
                }
                if (param.get("name") != null && param.get("name").toString() != "") {
                    WHERE("name like concat('%',#{name},'%')");
                }
            }}.toString();
        }
        return null;
    }

    /**
     * 查询所有职员
     *
     * @return
     */
    public String queryAll() {
        return new SQL() {{
            SELECT("id,name,gender,birthday,email,remark");
            FROM("employee");
            WHERE("1 = 1");
        }}.toString();
    }
}

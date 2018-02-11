package com.emp.vo;

/**
 * 查询职员所需要的参数
 */
public class QueryEmpParams {
    /**
     * 职员编号
     */
    private Integer id;
    /**
     * 职员名字
     */
    private String name;
    /**
     * 职员性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 职员邮箱
     */
    private String email;
    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

package com.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "employee")
public class Employee {
    /**
     * 职员编号
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 职员名字
     */
    @Column(name = "name")
    private String name;
    /**
     * 职员性别
     */
    @Column(name = "gender")
    private String gender;
    /**
     * 出生日期
     */
    @Column(name = "birthday")
    private String birthday;
    /**
     * 职员邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 备注
     */
    @Column(name = "remark")
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

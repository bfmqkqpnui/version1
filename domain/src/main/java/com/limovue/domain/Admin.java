package com.limovue.domain;


import com.limovue.common.util.Md5Utils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 管理员表
 */
@Entity(name = "t_admin")
public class Admin {

    @Id
    @GeneratedValue
    private Integer id;

    // 登录账户
    @Column
    private String userName = "admin";

    // 密码
    @Column
    private String passWord = Md5Utils.MD5Encode("admin","UTF-8",false);

    // 管理员昵称
    @Column
    private String nickName = "爱时刻管理员";

    // 角色主键
    @Column
    private String roleId = "";

    // 管理员名字
    @Column
    private String name = "";

    // 管理员手机号
    @Column
    private String phone = "";

    // 状态(0禁用，1启用)
    @Column
    private int status = 1;

    // 登录验证令牌
    @Column
    private String token = "";

    // 管理员头像地址
    @Column
    private String headImg = "";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}

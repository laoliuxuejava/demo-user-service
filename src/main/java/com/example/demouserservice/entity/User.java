package com.example.demouserservice.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-11-23 15:32:50
 */
public class User implements Serializable {
    private static final long serialVersionUID = -37511010141282115L;
    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private Integer age;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 所在地址
     */
    private String address;
    /**
     * 账户密码
     */
    private String password;
    /**
     * 账户头像
     */
    private String icon;
    /**
     * 用户注册时间
     */
    private Date createTime;
    /**
     * 信息更新时间
     */
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}


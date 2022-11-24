package com.example.demouserservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Date;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-11-24 16:47:04
 */
public class User {
    private static final long serialVersionUID = 143996525303347145L;
    /**
     * 用户id,系统自动生成
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
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
    @Builder.Default
    private String icon = "https://cn.bing.com/images/search?q=%e5%a4%b4%e5%83%8f&id=B7D4FD37CAE8DBF666B9B700A835C602789CC3FA&FORM=IQFRBA";
    /**
     * 用户注册时间
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createTime;
    /**
     * 信息更新时间
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date updateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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


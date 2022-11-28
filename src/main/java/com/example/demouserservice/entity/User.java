package com.example.demouserservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

import static com.example.demouserservice.constants.SystemConstants.DEFAULT_NICK;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-11-24 16:47:04
 */
//这是实体类映射的表名
@TableName("user")
@Data
public class User {
    private static final long serialVersionUID = 143996525303347145L;
    /**
     * 用户id,系统自动生成
     */
    @TableId(value = "id")  //将属性所对应的字段制定为主键，value值用于指定主键字段,type用于主键的生成策略(默认采用雪花算法，即UUID)
    private Long id;
    /**
     * 用户昵称
     */
    //用于指定属性所对应的字段名
    @TableField(value = "nick_name")
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
    private String icon = DEFAULT_NICK;
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

//    @Version //表示乐观锁的版本号
//    private Integer version;

}


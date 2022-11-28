package com.example.demouserservice.dto;

import lombok.Data;

/**
 * @Author guser
 * @Date 2022/11/23
 */
@Data
public class UserDTO {
    private Long id;
    private String nickName;
    private String sex;
    private Integer age;
    private String address;
    private String icon;
}

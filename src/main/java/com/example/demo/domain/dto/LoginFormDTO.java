package com.example.demo.domain.dto;

import lombok.Data;

/**
 * @Author guser
 * @Date 2022/11/23
 */
@Data
public class LoginFormDTO {

    private String phone;
    private String code;
    private String password;
}

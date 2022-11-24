package com.example.demouserservice.service;

import com.example.demouserservice.dto.LoginFormDTO;
import com.example.demouserservice.dto.Result;
import com.example.demouserservice.entity.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-11-23 11:22:07
 */
public interface UserService {

    Result loginByCode(LoginFormDTO loginFormDTO);

    Result sendCode(String phone);

    Result loginByPassword(LoginFormDTO loginFormDTO);

    Result register(User user);
}

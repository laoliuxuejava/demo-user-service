package com.example.demo.app.service;

import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.Result;
import com.example.demo.domain.entity.User;

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

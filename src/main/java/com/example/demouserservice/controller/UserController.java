package com.example.demouserservice.controller;

import com.example.demouserservice.dto.LoginFormDTO;
import com.example.demouserservice.dto.Result;
import com.example.demouserservice.entity.User;
import com.example.demouserservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-11-23 11:22:05
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "sendCode")
    public Result sendCode(@RequestParam String phone) {
        return userService.sendCode(phone);
    }

    @PostMapping(value = "register")
    public Result register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping(value = "loginByCode")
    public Result loginByCode(@RequestBody LoginFormDTO loginFormDTO) {
        return userService.loginByCode(loginFormDTO);
    }

    @PostMapping("loginByPassword")
    public Result loginByPassword(@RequestBody LoginFormDTO loginFormDTO) {
        return userService.loginByPassword(loginFormDTO);
    }
}


package com.example.demo.utils;

import com.example.demo.dto.UserDTO;

/**
 * @Author guser
 * @Date 2022/11/28
 */
public class UserHolder {
    private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();

    public static void saveUser(UserDTO userDTO) {
        tl.set(userDTO);
    }

    public static UserDTO getUser() {
        return tl.get();
    }

    public static void removeUser() {
        tl.remove();
    }
}

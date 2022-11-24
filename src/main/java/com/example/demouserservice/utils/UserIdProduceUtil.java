package com.example.demouserservice.utils;

import cn.hutool.core.lang.UUID;

import static com.example.demouserservice.constants.SystemConstants.USER_ID_PREFIX;

/**
 * @Author guser
 * @Date 2022/11/24
 */
public class UserIdProduceUtil {
    public static String userId() {
        return USER_ID_PREFIX + UUID.randomUUID().toString(true);
    }
}

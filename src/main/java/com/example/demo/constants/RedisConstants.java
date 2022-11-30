package com.example.demo.constants;

/**
 * @Author guser
 * @Date 2022/11/23
 */
public class RedisConstants {
    public static final String LOGIN_CODE_KEY = "login:code:";
    public static final Long LOGIN_CODE_TTL = 2L;

    public static final String LOGIN_PASSWORD_KEY = "login:password:";
    public static final Long LOGIN_PASSWORD_TTL = 5L;

    public static final String LOGIN_USER_KEY = "login:token:";
    public static final Long LOGIN_USER_TTL = 30L;
}

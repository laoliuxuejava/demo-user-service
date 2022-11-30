package com.example.demo.utils;

import cn.hutool.core.util.StrUtil;

/**
 * @Author guser
 * @Date 2022/11/23
 */
public class RegexUtil {
    /**
     * 是否是无效手机格式
     * @param phone
     * @return
     */
    public static boolean isPhoneInvalid(String phone) {
        return mismatch(phone, RegexRule.PHONE_REGEX);
    }

    /**
     * 是否是无效邮箱格式
     * @param email
     * @return
     */
    public static boolean isEmailInvalid(String email) {
        return mismatch(email, RegexRule.EMAIL_REGEX);
    }

    /**
     * 是否是无效验证码格式
     * @param code
     * @return
     */
    public static boolean isCodeInvalid(String code) {
        return mismatch(code, RegexRule.VERIFY_CODE_REGEX);
    }

    //校验是否不符合正则格式
    private static boolean mismatch(String str, String regex) {
        if (StrUtil.isBlank(str)) {
            return true;
        }
        return !str.matches(regex);
    }
}

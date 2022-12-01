package com.example.demo.infra.utils;

import cn.hutool.core.bean.BeanUtil;
import com.example.demo.domain.dto.UserDTO;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static com.example.demo.constants.RedisConstants.LOGIN_USER_KEY;

/**
 * @Author guser
 * @Date 2022/11/23
 */
public class LoginInterceptor implements HandlerInterceptor {

    private StringRedisTemplate stringRedisTemplate;

    public LoginInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求头的token
        String token = request.getHeader("authorization");
        //2.拼接key
        String key = LOGIN_USER_KEY + token;
        //3.基于token从redis获取用户信息
        Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(key);
        //4.判断用户是否存在
        if (userMap.isEmpty()) {
            //4.1不存在，返回拦截
            return false;
        }
        //5.存在，转为UserDTO对象并保存在ThreadLocal中
        UserDTO user = BeanUtil.fillBeanWithMap(userMap, new UserDTO(), false);
        UserHolder.saveUser(user);
        //6.放行
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //移除用户
        UserHolder.removeUser();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

package com.example.demouserservice.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demouserservice.dao.mapper.UserMapper;
import com.example.demouserservice.dto.LoginFormDTO;
import com.example.demouserservice.dto.Result;
import com.example.demouserservice.dto.UserDTO;
import com.example.demouserservice.entity.User;
import com.example.demouserservice.service.UserService;
import com.example.demouserservice.utils.RegexUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.example.demouserservice.constants.RedisConstants.*;
import static com.example.demouserservice.utils.DateUtil.generationDateTime;
import static com.example.demouserservice.utils.UserIdProduceUtil.userId;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-11-23 11:22:07
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    @Override
    public Result sendCode(String phone) {
        //1.校验手机号
        if (RegexUtil.isPhoneInvalid(phone)) {
            //2.如果不符合，返回错误信息
            return Result.fail("手机号格式不正确！");
        }
        //3.符合，生成随机验证码
        String code = RandomUtil.randomNumbers(6);
        //4.保存验证码到redis set key value ex 120 （ex 120 表示有效期120秒）
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY +  phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);
        //5.发送验证码
        logger.info("发送短信验证码成功，验证码：{}", code);
        return Result.ok();
    }

    /**
     * 通过密码登录
     * @param loginFormDTO
     * @return
     */
    @Override
    public Result loginByPassword(LoginFormDTO loginFormDTO) {
        //1.获取手机号，并校验手机号格式
        String phone = loginFormDTO.getPhone();
        if (RegexUtil.isPhoneInvalid(phone)) {
            return Result.fail("手机号格式有误，请重试");
        }
        //2.判断用户是否存在
        User user = query().eq("phone", phone).one();
        if (user == null) {
            //3.不存在，返回错误信息
            return Result.fail("用户不存在，请注册");
        }
        //4.存在，则验证用户信息
        String password = loginFormDTO.getPassword();
        String oldPassword = user.getPassword();
        if (!password.equals(oldPassword)) {
            //5.验证不通过，返回错误信息
            return Result.fail("密码错误，请重新输入");
        }
        //6.验证通过，保存用户信息到redis
        //6.1 随机生成token作为登录令牌
        String token = UUID.randomUUID().toString(true);
        //6.2将user对象转换成HashMap存储
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        logger.info("存储对象数据：{}",userDTO);
        Map<String, Object> map = BeanUtil.beanToMap(userDTO, new HashMap<>(), CopyOptions.create().setIgnoreNullValue(true).setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
        //6.3存储
        stringRedisTemplate.opsForHash().putAll(LOGIN_USER_KEY + phone, map);
        //6.4设置token有效期
        stringRedisTemplate.expire(LOGIN_USER_KEY + token ,LOGIN_USER_TTL, TimeUnit.MINUTES);
        //7.返回token
        logger.info("登录成功！");
        return Result.ok(token);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {
        //1.判断用户是否已经注册
        User oldUser = query().eq("phone", user.getPhone()).one();
        if (oldUser != null) {
            return Result.fail("用户已存在！");
        }
        //2.对用户传进来的参数进行封装
        user.setId(userId());
        user.setCreateTime(generationDateTime());
        save(user);
        logger.info("{}用户注册成功!", user.getNickName());
        return Result.ok("注册成功！");
    }
    /**
     * 通过手机验证码登录
     * @param loginFormDTO
     * @return
     */
    @Override
    public Result loginByCode(LoginFormDTO loginFormDTO) {
        //1.校验手机号
        String phone = loginFormDTO.getPhone();
        if (RegexUtil.isPhoneInvalid(phone)) {
            //2.如果不符合，返回错误信息
            return Result.fail("手机号格式错误");
        }
        //3.从redis获取验证码并校验
        String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + phone);
        String code = loginFormDTO.getCode();
        //3.1选择登录方式（验证码或者密码）
        if (cacheCode == null || !cacheCode.equals(code)) {
            //3.1 不一致，返回错误信息
            return Result.fail("验证码错误");
        }
        //4.一致，根据手机号查询用户 select * from demo-user-service where phone = ? (这里的query方法需要继承mybatis里面的ServiceImpl实现类）
        User user = query().eq("phone", phone).one();
        //5.判断用户是否存在'
        if (user == null) {
            //6.不存在，创建新用户并保存到数据库
            return Result.fail("用户尚未注册，请注册后登录");
        }
        //7.保存用户信息到redis中
        //7.1随机生成token，作为登录令牌
        String token = UUID.randomUUID().toString(true);
        //7.2 将User对象转为HashMap存储
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO, new HashMap<>(), CopyOptions.create().setIgnoreNullValue(true).setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
        //7.3 存储
        stringRedisTemplate.opsForHash().putAll(LOGIN_USER_KEY + token, userMap);
        //7.4 设置token有效期
        stringRedisTemplate.expire(LOGIN_USER_KEY + token, LOGIN_USER_TTL, TimeUnit.MINUTES);
        //8.返回token
        logger.info("登录成功");
        return Result.ok(token);
    }
}

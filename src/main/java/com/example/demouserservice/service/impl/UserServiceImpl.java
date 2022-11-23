package com.example.demouserservice.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.example.demouserservice.dto.LoginFormDto;
import com.example.demouserservice.dto.Result;
import com.example.demouserservice.entity.User;
import com.example.demouserservice.dao.UserDao;
import com.example.demouserservice.service.UserService;
import com.example.demouserservice.utils.RegexUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.concurrent.TimeUnit;

import static com.example.demouserservice.constants.RedisConstants.*;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-11-23 11:22:07
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public Result sendCode(String phone, HttpSession session) {
        //1.校验手机号
        if (RegexUtil.isPhoneInvalid(phone)) {
            //2.如果不符合，返回错误信息
            return Result.fail("手机号格式不正确！");
        }
        //3.符合，生成随机验证码
        String code = RandomUtil.randomNumbers(6);
        //4.保存验证码到redis set key value ex 120 （ex 120 表示有效期120秒）
        redisTemplate.opsForValue().set(LOGIN_CODE_KEY +  phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);
        //5.发送验证码
        logger.info("发送短信验证码成功，验证码：{}", code);
        return Result.ok();
    }

    @Override
    public Result login(LoginFormDto loginFormDto, HttpSession session) {
        //1.校验手机号
        String phone = loginFormDto.getPhone();
        if (RegexUtil.isPhoneInvalid(phone)) {
            //2.如果不符合，返回错误信息
            return Result.fail("手机号格式错误");
        }
        //3.从redis获取验证码并校验
        //4.一致，根据手机号查询用户 select * from demo-user-service where phone = ?
        //5.判断用户是否存在
        //6.不存在，创建新用户并保存
        //7.保存用户信息到redis中
        //7.1随机生成token，作为登录令牌
        //7.2 将User对象转为HashMap存储
        //7.3 存储
        //7.4 设置token有效期
        //8.返回token
        return null;
    }


}

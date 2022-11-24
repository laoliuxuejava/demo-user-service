package com.example.demouserservice.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demouserservice.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author guser
 * @Date 2022/11/24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

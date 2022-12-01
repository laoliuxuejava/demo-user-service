package com.example.demo.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author guser
 * @Date 2022/12/1
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

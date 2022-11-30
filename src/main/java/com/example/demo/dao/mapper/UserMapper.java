package com.example.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author guser
 * @Date 2022/11/24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //自定义分页查询，需要配置映射文件，即xml文件
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}

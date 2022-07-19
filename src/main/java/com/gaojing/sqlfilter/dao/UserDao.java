package com.gaojing.sqlfilter.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaojing.sqlfilter.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User>{
    List<User> filterQuery(String sqlQuery);
}

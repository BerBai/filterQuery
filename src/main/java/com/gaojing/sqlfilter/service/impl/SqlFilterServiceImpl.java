package com.gaojing.sqlfilter.service.impl;

import com.gaojing.sqlfilter.dao.UserDao;
import com.gaojing.sqlfilter.entity.Query;
import com.gaojing.sqlfilter.entity.User;
import com.gaojing.sqlfilter.service.ISqlFilterService;
import com.gaojing.sqlfilter.utils.FilterQueryBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SqlFilterServiceImpl implements ISqlFilterService {
    @Autowired
    UserDao userDao;
    @Autowired
    FilterQueryBuilderUtil filterQueryBuilderUtil;

    @Override
    public List<User> filterQuery(Query query) throws IOException {
        String sql = filterQueryBuilderUtil.buildSql(query);
        System.out.println(sql);
        return userDao.filterQuery(sql);
    }
}

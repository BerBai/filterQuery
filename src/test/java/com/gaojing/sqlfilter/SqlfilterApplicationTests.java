package com.gaojing.sqlfilter;

import com.gaojing.sqlfilter.dao.UserDao;
import com.gaojing.sqlfilter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlfilterApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testMybatisPlus() {
        User user = new User(3,"王","男",28,"深圳");
        userDao.insert(user);
    }
}

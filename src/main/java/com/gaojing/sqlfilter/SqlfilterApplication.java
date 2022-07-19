package com.gaojing.sqlfilter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gaojing.sqlfilter.dao")
public class SqlfilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqlfilterApplication.class, args);
    }

}

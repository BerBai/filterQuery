package com.gaojing.sqlfilter.controller;

import com.gaojing.sqlfilter.entity.Query;
import com.gaojing.sqlfilter.entity.User;
import com.gaojing.sqlfilter.service.ISqlFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/filter")
public class SqlFilterController {
    @Autowired
    ISqlFilterService sqlFilterService;

    @PostMapping("/query")
    public List<User> filterQuery(@RequestBody Query query) throws IOException {
        System.out.println(query.toString());
        return sqlFilterService.filterQuery(query);
    }
}

package com.gaojing.sqlfilter.service;

import com.gaojing.sqlfilter.entity.Query;
import com.gaojing.sqlfilter.entity.User;

import java.io.IOException;
import java.util.List;

public interface ISqlFilterService {
    List<User>  filterQuery(Query query) throws IOException;
}

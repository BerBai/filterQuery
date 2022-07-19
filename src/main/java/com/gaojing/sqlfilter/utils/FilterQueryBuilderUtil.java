package com.gaojing.sqlfilter.utils;

import cn.hutool.core.util.StrUtil;
import com.gaojing.sqlfilter.entity.Children;
import com.gaojing.sqlfilter.entity.FilterQueryBuilderProperties;
import com.gaojing.sqlfilter.entity.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class FilterQueryBuilderUtil {

    @Autowired
    FilterQueryBuilderProperties filterQueryBuilderProperties;

    public String buildSql(Query query) {
        return "select * from user where " + buildSql("", query) + ";";
    }

    public String buildSql(String sql, Query query) {
        List<String> list = new ArrayList<>();
        for (Children child : query.getChildren()) {
            if (child.getType().equals("query-builder-rule")) {
                Query childQuery = child.getQuery();
                list.add(childQuery.getRule());
                list.add(filterQueryBuilderProperties.getMapping().getOrDefault(childQuery.getOperator(), ""));

                if (StrUtil.isNotEmpty(childQuery.getValue())) {
                    String field = "'";
                    if ("contains".equals(childQuery.getOperator()) || "does not contain".equals(childQuery.getOperator())) {
                        field += ("%" + childQuery.getValue() + "%");
                    } else {
                        if ("ends with".equals(childQuery.getOperator())) {
                            field += "%";
                        }
                        field += childQuery.getValue();
                        if ("begins with".equals(childQuery.getOperator())) {
                            field += "%";
                        }
                    }
                    field += "'";
                    list.add(field);
                }
            } else {
                list.add(" ( ");
                list.add(buildSql(sql, child.getQuery()));
                list.add(" ) ");
            }
            list.add(filterQueryBuilderProperties.getMapping().get(query.getLogicalOperator()));
        }
        list.remove(list.size() - 1);
        return sql + listToStr(list);
    }

    private <T> String listToStr(List<T> deque) {
        StringBuilder sb = new StringBuilder();
        for (T t : deque) {
            sb.append(t).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}

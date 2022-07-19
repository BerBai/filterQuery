package com.gaojing.sqlfilter.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "filter-query-builder")
public class FilterQueryBuilderProperties {
    private Map<String, String> mapping;
}

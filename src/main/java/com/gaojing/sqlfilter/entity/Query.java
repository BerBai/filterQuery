package com.gaojing.sqlfilter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Query {
    private String rule;
    private String selectedOperator;
    private String selectedOperand;
    private String value;
    private String operator;
    private String logicalOperator;
    private List<Children> children;

}

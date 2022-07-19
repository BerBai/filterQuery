package com.gaojing.sqlfilter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String address;

}

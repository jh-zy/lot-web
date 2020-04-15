package com.sinodata.lottery.serviceexample.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class User {
    private Long id;
    private String name;
    private String address;
    private String phone;

    @TableField(exist = false)
    private Integer count;
}

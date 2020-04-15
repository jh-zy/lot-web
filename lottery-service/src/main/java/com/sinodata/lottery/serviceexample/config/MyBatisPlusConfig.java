package com.sinodata.lottery.serviceexample.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sinodata.lottery.serviceexample.mapper")
public class MyBatisPlusConfig {
}
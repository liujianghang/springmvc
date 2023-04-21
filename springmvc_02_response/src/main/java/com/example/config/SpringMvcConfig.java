package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// 3 创建配置文件 加载bean
@Configuration
@ComponentScan("com.example.controller")
@EnableWebMvc // 1.开启了json数据转为对象的功能 2.根据类型匹配对应的类型转换器
public class SpringMvcConfig {
}


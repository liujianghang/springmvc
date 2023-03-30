package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 3 创建配置文件 加载bean
@Configuration
@ComponentScan("com.example.controller")
public class SpringMvcConfig {
}


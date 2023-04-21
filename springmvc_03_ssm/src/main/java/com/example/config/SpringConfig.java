package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.example.service"})
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class, MyBatisconfig.class})
public class SpringConfig {
}

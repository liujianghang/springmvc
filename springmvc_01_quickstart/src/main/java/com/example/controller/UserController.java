package com.example.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 1 定义controller
// 使用@Component定义bean
@Controller
public class UserController {
    // 1.2 设置当前访问的路径
    @RequestMapping("/save")
    // 1.3 设置当前值的返回值类型
    @ResponseBody
    public String save(){
        System.out.println("user save ...");
        return "{'module':'springmvc'}";
    }
}

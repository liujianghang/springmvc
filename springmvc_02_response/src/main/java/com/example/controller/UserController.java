package com.example.controller;

import com.example.domin.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

// 1 定义controller
// 使用@Component定义bean
@Controller
@RequestMapping("/")
public class UserController {
    @RequestMapping("/toJumpPage")
    // 跳转页面
    public String toJumpPage(){
        System.out.println("跳转页面");
        return "index.jsp";
    }
    // 直接返回文本
    @RequestMapping("/toText")
    @ResponseBody // 返回字符串
    public String toText(){
        System.out.println("返回文本");
        return "返回了文本";
    }
    // 直接POJO对象(json)
    @RequestMapping("/toJsonPOJO")
    @ResponseBody // 返回自定义的字符串
    public User toJsonPOJO(){
        System.out.println("返回json对象数据");
        User user = new User();
        user.setName("jack");
        user.setAge(16);
        return user;
    }
    // 直接POJO对象集合(自动变json)
    @RequestMapping("/toJsonList")
    @ResponseBody // 返回自定义的字符串
    public List<User> toJsonList(){
        System.out.println("返回json对象数据");
        User user1 = new User();
        user1.setName("jack");
        user1.setAge(16);
        User user2 = new User();
        user2.setName("jack");
        user2.setAge(16);
        User user3 = new User();
        user3.setName("jack");
        user3.setAge(16);
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return userList;
    }
}

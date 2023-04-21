package com.example.controller;

import com.example.domin.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// 1 定义controller
// 使用@Component定义bean
@Controller
// @ResponseBody
// @RestController 将@Controller和@ResponseBody合二为一
@RequestMapping("/user")

public class UserController {
    // 1.2 设置当前访问的路径
//    @RequestMapping(value = "/users", method = RequestMethod.POST)  // 修改为restful形式
    @PostMapping // 再简化
    // 1.3 设置当前值的返回值类型
    @ResponseBody
    public String save() {
        System.out.println("user save ...");
        return "{'User':'Save'}";
    }

//    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)  // 修改为restful形式
    // 1.3 设置当前值的返回值类型
    @DeleteMapping("/{id}") // 再简化
    @ResponseBody
    public String delete(@PathVariable int id) { //对应路径中的变量
        System.out.println("user delete ... " + id);
        return "{'User':'delete'}";
    }


    @RequestMapping("/commonParam")
    // 1.3 设置当前值的返回值类型
    @ResponseBody
    public String commonParam(@RequestParam("name") String username, int age) { // 可以绑定参数关系,如果属性名一样可以自动注入
        System.out.println("普通参数传递：username==>" + username);
        System.out.println("普通参数传递：age==>" + age);
        return "{'module':'common param'}";
    }

    // POJO参数
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user) {
        System.out.println("pojo参数传递 user==>" + user);
        return "{'module':'pojo contain pojo param'}";
    }

    // 嵌套POJO参数
    /*
       http://localhost/user/pojoContainPojoParam?name=jack&age=15&address.city=beijing&address.province=beijing
     */
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User user) {
        System.out.println("pojo嵌套pojo参数传递 user==>" + user);
        return "{'module':'pojo contain pojo param'}";
    }

    // 多个的数据格式
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes) {
        System.out.println("数组参数传递 likes==>" + Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    // 集合参数 由于默认使用的是pojo的模式，需要手动添加注释表示传入参数
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes) {
        System.out.println("集合参数传递 likes==>" + likes);
        return "{'module':'list param'}";
    }

    // 集合参数：json格式
    /*
    需要添加@RequestBody注解
     */
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes) {
        System.out.println("listParam(Json) likes ==>" + likes);
        return "{'module':'list Param For Json'}";
    }

    // pojo参数：json格式
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojotParamForJson(@RequestBody User user) {
        System.out.println("pojoParam(Json) likes ==>" + user);
        return "{'module':'pojo Param For Json'}";
    }

    // 集合参数：json格式
    @RequestMapping("/pojoParamForJsonList")
    @ResponseBody
    public String listPojotParamForJson(@RequestBody List<User> users) {
        System.out.println("listPojoParam(Json) likes ==>" + users);
        return "{'module':'list Pojo Param For Json List'}";
    }

    // 日期参数
    /*
    标准格式是：yyyy/mm/dd
    直接在params中传，可以指定格式
     */
    @RequestMapping("/dataParam")
    @ResponseBody
    public String dataParam(Data date, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date1) {
        System.out.println("data ==>" + date);
        System.out.println("data1 ==>" + date1);
        return "{'module':'data'}";
    }
}

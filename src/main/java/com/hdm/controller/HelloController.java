package com.hdm.controller;

import com.hdm.pojo.User;
import com.hdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author HDM
 * @Date 2024-07-28 17:57
 */

@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello world");
        return "HelloWorld!";
    }


    @RequestMapping("/findById")
    public User findById(Integer id) {
        User user = userService.findById(id);
        System.out.println(user);
        return user;
    }
}

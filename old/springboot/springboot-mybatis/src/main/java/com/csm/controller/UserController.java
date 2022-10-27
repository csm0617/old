package com.csm.controller;

import com.csm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author 快乐小柴
 * @Date 2022/10/14 20:56
 * @Version 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(){
        return "index";
    }


}

package com.thylovezj.hospital.controller;

import com.thylovezj.hospital.model.pojo.User;
import com.thylovezj.hospital.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/test")
    @ApiOperation("第一个Api接口")
    public User test(Integer userId){
        return userService.getUser();
    }
}

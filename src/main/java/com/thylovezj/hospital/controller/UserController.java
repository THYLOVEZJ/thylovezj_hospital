package com.thylovezj.hospital.controller;

import com.thylovezj.hospital.common.ApiRestResponse;
import com.thylovezj.hospital.exception.ThylovezjHospitalException;
import com.thylovezj.hospital.exception.ThylovezjHospitalExceptionEnum;
import com.thylovezj.hospital.model.pojo.User;
import com.thylovezj.hospital.model.request.AddUserReq;
import com.thylovezj.hospital.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/rigister")
    @ApiOperation("添加用户")
    public ApiRestResponse register(@RequestBody AddUserReq addUserReq) {
        if (StringUtils.isEmpty(addUserReq.getUsername())) {
            return ApiRestResponse.error(ThylovezjHospitalExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(addUserReq.getPassword())) {
            return ApiRestResponse.error(ThylovezjHospitalExceptionEnum.NEED_PASSWORD);
        }
        int role = addUserReq.getRole();
        if (role != 0 && role != 1 && role != 2) {
            return ApiRestResponse.error(ThylovezjHospitalExceptionEnum.ROLE_ERROR);
        }
        userService.Register(addUserReq.getUsername(), addUserReq.getPassword(), role);
        return ApiRestResponse.success();
    }
}

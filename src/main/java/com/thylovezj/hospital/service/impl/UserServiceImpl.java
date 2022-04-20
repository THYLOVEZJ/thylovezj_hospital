package com.thylovezj.hospital.service.impl;

import com.thylovezj.hospital.exception.ThylovezjHospitalException;
import com.thylovezj.hospital.exception.ThylovezjHospitalExceptionEnum;
import com.thylovezj.hospital.model.dao.UserMapper;
import com.thylovezj.hospital.model.pojo.User;
import com.thylovezj.hospital.service.UserService;
import com.thylovezj.hospital.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public void Register(String username, String password, int role) {
        User res = userMapper.selectByUserName(username);
        if (res != null) {
            throw new ThylovezjHospitalException(ThylovezjHospitalExceptionEnum.USERNAME_EXISTS);
        }
        User user = new User();
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user.setUsername(username);
        user.setRole(role);
        user.setBonus(0);
        int count = userMapper.insertSelective(user);
        if (count == 0) {
            throw new ThylovezjHospitalException(ThylovezjHospitalExceptionEnum.INSERT_FAILED);
        }
    }
}

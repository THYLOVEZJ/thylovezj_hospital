package com.thylovezj.hospital.service.impl;

import com.thylovezj.hospital.model.dao.UserMapper;
import com.thylovezj.hospital.model.pojo.User;
import com.thylovezj.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUser(){
        return userMapper.selectByPrimaryKey(1l);
    }
}

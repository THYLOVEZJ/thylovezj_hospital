package com.thylovezj.hospital.service;

import com.thylovezj.hospital.model.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void Register(String username, String password,int role);
}

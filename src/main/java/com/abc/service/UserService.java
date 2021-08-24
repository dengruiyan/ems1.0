package com.abc.service;

import com.abc.bean.User;

public interface UserService {
    //登录
    User login(String username);
    //注册：添加用户
    void insert(User user);

    User selectByName(String username);
}

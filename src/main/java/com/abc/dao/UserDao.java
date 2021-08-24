package com.abc.dao;

import com.abc.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    //登录时根据用户名查询
    User login(@Param("username") String username);
    //注册：添加用户
    void insert(User user);
}

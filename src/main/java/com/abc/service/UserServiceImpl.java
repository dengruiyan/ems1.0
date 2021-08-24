package com.abc.service;

import com.abc.dao.UserDao;
import com.abc.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = java.lang.RuntimeException.class)
public class UserServiceImpl implements UserService{
    //声明日志成员变量
    private static final Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
    //声明成员变量dao
    @Resource
    private UserDao userDao;

    @Override
    @Transactional(propagation =Propagation.SUPPORTS)
    public User login(String username) {
        User user = userDao.login(username);
        return user;
    }

    @Override
    public void insert(User user) {
        user.setId(UUID.randomUUID().toString());
        log.debug("id:{},name:{} , password:{}",user.getId(),user.getUsername(), user.getPassword());
        userDao.insert(user);
    }

    @Override
    @Transactional(propagation =Propagation.SUPPORTS)
    public User selectByName(String username) {
        User user = userDao.login(username);
        return user;
    }
}

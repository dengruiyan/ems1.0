package com.abc.test;

import com.abc.bean.User;
import com.abc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    @Test
    public void testLogin(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       /* SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        Connection connection = sqlSessionFactory.openSession().getConnection();
        System.out.println(connection);*/
        /*UserDao userDao = (UserDao) context.getBean("userDao");
        User user = userDao.login("deng");*/

        UserService service = (UserService) context.getBean("userService");
        User user = service.login("deng");
        System.out.println(user);
    }
    @Test
    public void testInsert(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = (UserService) context.getBean("userService");
        //service.insert(new User(null,"xiaoming","123456"));

    }
}

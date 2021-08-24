package com.abc.test;

import com.abc.bean.Employee;
import com.abc.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestEmployee {
    ApplicationContext context = null;
    @Before
    public void before(){
        context = new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void testFindAll(){

       /* SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        Connection connection = sqlSessionFactory.openSession().getConnection();
        System.out.println(connection);*/
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        List<Employee> list = service.findAll();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    @Test
    public void deleteById(){
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        service.deleteById("1");
    }
    @Test
    public void selectById(){
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        Employee employee = service.selectById("3");
        System.out.println(employee);
    }
    @Test
    public void update(){
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        Employee employee = new Employee("3","李明",6500.0,25);
        service.update(employee);
    }
    @Test
    public void insert(){
        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        Employee employee = new Employee(null,"李华",6500.0,25);
        service.insert(employee);
    }
}

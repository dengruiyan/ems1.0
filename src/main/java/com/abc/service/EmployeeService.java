package com.abc.service;

import com.abc.bean.Employee;

import java.util.List;

public interface EmployeeService {
    //查询所有
    List<Employee> findAll();
    //根据id删除员工
    void deleteById(String id);
    //根据id查询员工
    Employee selectById(String id);
    //修改员工信息
    void update(Employee employee);
    //添加员工信息
    void insert(Employee employee);
}

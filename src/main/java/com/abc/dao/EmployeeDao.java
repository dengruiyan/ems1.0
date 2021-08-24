package com.abc.dao;

import com.abc.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    //查询所有员工
    List<Employee> findAll();
    //根据id删除员工
    void deleteById(@Param("id") String id);
    //根据id查询员工信息
    Employee selectById(@Param("id") String id);
    //修改员工信息
    void update(Employee employee);
    //添加员工信息
    void insert(Employee employee);
}

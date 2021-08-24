package com.abc.service;

import com.abc.dao.EmployeeDao;
import com.abc.bean.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service("employeeService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = java.lang.RuntimeException.class)
public class EmployeeServiceImpl implements EmployeeService{
    @Resource
    private EmployeeDao employeeDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findAll() {
        List<Employee> list = employeeDao.findAll();
        return list;
    }

    @Override
    public void deleteById(String id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee selectById(String id) {
        return employeeDao.selectById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void insert(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employeeDao.insert(employee);
    }
}

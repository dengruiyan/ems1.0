package com.abc.action;

import com.abc.bean.Employee;
import com.abc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeAction {
    @Autowired
    private EmployeeService employeeService;
    private List<Employee> list;
    //查询所有员工信息
    public String findAll(){
        list = employeeService.findAll();
        return "findAll";
    }
    //根据id删除员工信息
    public String deleteById(){
        employeeService.deleteById(id);
        return "deleteByIdToFindAll";
    }
    //根据id查询员工信息----修改前查询信息
    public String selectById(){
        employee = employeeService.selectById(id);
        return "selectByIdToUpdate";
    }
    //修改员工信息
    public String update(){
        employeeService.update(employee);
        return "updateToFindAll";
    }
    //添加员工信息
    public String add(){
        employeeService.insert(employee);
        return "addToFindAll";
    }
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }
}

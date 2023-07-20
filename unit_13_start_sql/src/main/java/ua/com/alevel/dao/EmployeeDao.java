package ua.com.alevel.dao;

import ua.com.alevel.entity.Employee;

import java.util.List;

public interface EmployeeDao extends CrudDao<Employee> {

    List<Employee> findAllEmployeesByDepartment(Long departmentId);
    List<Employee> findAllEmployeesByExcludeDepartment(Long departmentId);
}

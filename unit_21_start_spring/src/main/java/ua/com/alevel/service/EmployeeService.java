package ua.com.alevel.service;

import ua.com.alevel.entity.Employee;

import java.util.List;

public interface EmployeeService extends CrudService<Employee> {

    List<Employee> findAllEmployeesByDepartment(Long depId);
    List<Employee> findAllEmployeesByExcludeDepartment(Long depId);
}

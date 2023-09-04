package ua.com.alevel.facade.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.alevel.dto.DepartmentDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.DepartmentFacade;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;

@Service
public class DepartmentFacadeImpl implements DepartmentFacade {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void create(DepartmentDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        departmentService.create(department);
    }

    @Override
    public void update(Long id, DepartmentDto dto) {
        Department department = departmentService.findById(id);
        department.setName(dto.getName());
        departmentService.update(department);
    }

    @Override
    public void delete(Long id) {
        departmentService.delete(id);
    }

    @Override
    public DepartmentDto findById(Long id) {
        return new DepartmentDto(departmentService.findById(id));
    }

    @Override
    public Collection<DepartmentDto> findAll() {
        return departmentService.findAll().stream().map(DepartmentDto::new).toList();
    }

    @Override
    public Collection<DepartmentDto> findByEmployee(Long id) {
        Employee employee = employeeService.findById(id);
        Collection<Department> departments = Collections.emptyList();
        if (CollectionUtils.isNotEmpty(employee.getDepartments())) {
            departments = employee.getDepartments();
        }
        return departments.stream().map(DepartmentDto::new).toList();
    }
}

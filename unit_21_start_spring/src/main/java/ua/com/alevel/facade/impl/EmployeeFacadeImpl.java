package ua.com.alevel.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alevel.dto.EmployeeDto;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeFacadeImpl implements EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void create(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        employeeService.create(employee);
    }

    @Override
    public void update(Long id, EmployeeDto dto) {
        Employee employee = employeeService.findById(id);
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        employeeService.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeService.delete(id);
    }

    @Override
    public EmployeeDto findById(Long id) {
        return new EmployeeDto(employeeService.findById(id));
    }

    @Override
    public Collection<EmployeeDto> findAll() {
        return employeeService.findAll().stream().map(EmployeeDto::new).toList();
    }

    @Override
    public List<EmployeeDto> findAllEmployeesByDepartment(Long depId) {
        return employeeService.findAllEmployeesByDepartment(depId).stream().map(EmployeeDto::new).toList();
    }

    @Override
    public List<EmployeeDto> findAllEmployeesByExcludeDepartment(Long depId) {
        return employeeService.findAllEmployeesByExcludeDepartment(depId).stream().map(EmployeeDto::new).toList();
    }
}

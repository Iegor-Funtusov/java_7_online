package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.repository.EmployeeRepository;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    public void update(Employee entity) {
        checkExists(entity.getId());
        employeeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        checkExists(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        checkExists(id);
        return employeeRepository.findById(id).get();
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }

    private void checkExists(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
    }
}

package ua.com.alevel.service.impl;

import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.dao.impl.EmployeeDaoImpl;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void create(Employee entity) {
        employeeDao.create(entity);
    }

    @Override
    public void update(Employee entity) {
        checkExistById(entity.getId());
        employeeDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        checkExistById(id);
        employeeDao.delete(id);
    }

    @Override
    public Employee findById(Long id) {
        checkExistById(id);
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    private void checkExistById(Long id) {
        if (!employeeDao.existsById(id)) {
            throw new RuntimeException("Entity not found");
        }
    }

    @Override
    public List<Employee> findAllEmployeesByDepartment(Long departmentId) {
        return employeeDao.findAllEmployeesByDepartment(departmentId);
    }

    @Override
    public List<Employee> findAllEmployeesByExcludeDepartment(Long departmentId) {
        return employeeDao.findAllEmployeesByExcludeDepartment(departmentId);
    }
}

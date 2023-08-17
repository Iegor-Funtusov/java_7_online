package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.com.alevel.dto.datatable.DatatableRequest;
import ua.com.alevel.dto.datatable.DatatableResponse;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.repository.EmployeeRepository;
import ua.com.alevel.service.EmployeeService;

import java.util.Collections;
import java.util.List;

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
        checkExistById(entity.getId());
        employeeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        checkExistById(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        checkExistById(id);
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public DatatableResponse<Employee> findALL(DatatableRequest request) {
        Page<Employee> employeePage;
        if (request.sort().equals("desc")) {
            employeePage = employeeRepository
                    .findAll(
                            PageRequest.of(
                                    request.currentPage() - 1,
                                    request.pageSize(),
                                    Sort.by(request.orderBy()).descending()));
        } else {
            employeePage = employeeRepository
                    .findAll(
                            PageRequest.of(
                                    request.currentPage() - 1,
                                    request.pageSize(),
                                    Sort.by(request.orderBy()).ascending()));
        }

        DatatableResponse<Employee> response = new DatatableResponse<>();
        response.setOrderBy(request.orderBy());
        response.setSort(request.sort());
        response.setPageSize(request.pageSize());
        response.setCurrentPage(request.currentPage());
        response.setItems(employeePage.getContent());
        return response;
    }

    private void checkExistById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Entity not found");
        }
    }

    @Override
    public List<Employee> findAllEmployeesByDepartment(Long departmentId) {
        return Collections.emptyList();
    }

    @Override
    public List<Employee> findAllEmployeesByExcludeDepartment(Long departmentId) {
        return Collections.emptyList();
    }
}

package ua.com.alevel.facade.impl;

import ua.com.alevel.dto.EmployeeRequetsDto;
import ua.com.alevel.dto.EmployeeResponseDto;
import ua.com.alevel.dto.datatable.DatatableRequest;
import ua.com.alevel.dto.datatable.DatatableResponse;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;
import ua.com.alevel.service.EmployeeService;
import ua.com.alevel.service.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeFacadeImpl implements EmployeeFacade {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void create(EmployeeRequetsDto employeeRequetsDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequetsDto.firstName());
        employee.setLastName(employeeRequetsDto.lastName());
        employee.setAge(employeeRequetsDto.age());
        employeeService.create(employee);
    }

    @Override
    public void update(EmployeeRequetsDto employeeRequetsDto, Long id) {
        Employee employee = employeeService.findById(id);
        employee.setFirstName(employeeRequetsDto.firstName());
        employee.setLastName(employeeRequetsDto.lastName());
        employee.setAge(employeeRequetsDto.age());
        employeeService.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeService.delete(id);
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        Employee employee = employeeService.findById(id);
        return new EmployeeResponseDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAge());
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return employeeService.findAll().stream().map(employee -> new EmployeeResponseDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAge()))
                .toList();
    }

    @Override
    public DatatableResponse<EmployeeResponseDto> findAll(DatatableRequest datatableRequest) {
        DatatableResponse<Employee> response = employeeService.findALL(datatableRequest);
        List<Employee> employees = response.getItems();
        List<EmployeeResponseDto> responseDtos = employees.stream().map(employee -> new EmployeeResponseDto(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getAge()))
                .toList();
        DatatableResponse<EmployeeResponseDto> datatableResponse = new DatatableResponse<>();
        datatableResponse.setItems(responseDtos);
        datatableResponse.setCurrentPage(response.getCurrentPage());
        datatableResponse.setPageSize(response.getPageSize());
        datatableResponse.setSort(response.getSort());
        datatableResponse.setOrderBy(response.getOrderBy());
        return datatableResponse;
    }
}

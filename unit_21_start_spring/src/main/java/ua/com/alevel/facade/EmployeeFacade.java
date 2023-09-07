package ua.com.alevel.facade;

import ua.com.alevel.dto.EmployeeDto;

import java.util.List;

public interface EmployeeFacade extends CrudFacade<EmployeeDto> {
    List<EmployeeDto> findAllEmployeesByDepartment(Long depId);
    List<EmployeeDto> findAllEmployeesByExcludeDepartment(Long depId);
}

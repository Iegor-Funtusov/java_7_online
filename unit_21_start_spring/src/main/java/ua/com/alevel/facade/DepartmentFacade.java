package ua.com.alevel.facade;

import ua.com.alevel.dto.DepartmentDto;

import java.util.Collection;

public interface DepartmentFacade extends CrudFacade<DepartmentDto> {

    Collection<DepartmentDto> findByEmployee(Long id);
}

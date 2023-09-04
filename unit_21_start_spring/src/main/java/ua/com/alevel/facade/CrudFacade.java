package ua.com.alevel.facade;

import ua.com.alevel.dto.BaseDto;

import java.util.Collection;

public interface CrudFacade<DTO extends BaseDto> {

    void create(DTO dto);
    void update(Long id, DTO dto);
    void delete(Long id);
    DTO findById(Long id);
    Collection<DTO> findAll();
}

package ua.com.alevel.dao;

import ua.com.alevel.dto.datatable.DatatableRequest;
import ua.com.alevel.dto.datatable.DatatableResponse;
import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface CrudDao<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Long id);
    boolean existsById(Long id);
    E findById(Long id);
    List<E> findAll();
    DatatableResponse<E> findALL(DatatableRequest request);
}

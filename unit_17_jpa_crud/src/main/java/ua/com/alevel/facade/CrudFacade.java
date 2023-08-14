package ua.com.alevel.facade;

import ua.com.alevel.dto.datatable.DatatableRequest;
import ua.com.alevel.dto.datatable.DatatableResponse;

import java.util.List;

public interface CrudFacade<REQUEST, RESPONSE> {

    void create(REQUEST request);
    void update(REQUEST request, Long id);
    void delete(Long id);
    RESPONSE findById(Long id);
    List<RESPONSE> findAll();
    DatatableResponse<RESPONSE> findAll(DatatableRequest datatableRequest);
}

package ua.com.alevel.facade;

import ua.com.alevel.api.data.request.RequestDto;
import ua.com.alevel.api.data.response.ResponseDto;

import java.util.Collection;

public interface CrudFacade<REQUEST extends RequestDto, RESPONSE extends ResponseDto> {

    void create(REQUEST request);
    void update(REQUEST request, Long id);
    RESPONSE findById(Long id);
    Collection<RESPONSE> findAll();
}

package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.Collection;

public interface CrudService<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    E findById(Long id);
    Collection<E> findAll();
}

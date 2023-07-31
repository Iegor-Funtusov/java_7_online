package ua.com.alevel.dao.impl;

import ua.com.alevel.annotations.BeanClass;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.entity.Department;

import java.util.List;

@Deprecated
@BeanClass
public class DepartmentDao2Impl implements DepartmentDao {

    @Override
    public void create(Department entity) {

    }

    @Override
    public void update(Department entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Department findById(Long id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}

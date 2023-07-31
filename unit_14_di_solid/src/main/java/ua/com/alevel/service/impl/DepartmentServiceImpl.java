package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.BeanClass;
import ua.com.alevel.annotations.InjectBean;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.entity.Department;
import ua.com.alevel.service.DepartmentService;

import java.io.Serializable;
import java.util.List;

@BeanClass
public class DepartmentServiceImpl implements DepartmentService, Serializable {

    @InjectBean
    private DepartmentDao departmentDao;

    @Override
    public void create(Department entity) {
        departmentDao.create(entity);
    }

    @Override
    public void update(Department entity) {
        departmentDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentDao.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}

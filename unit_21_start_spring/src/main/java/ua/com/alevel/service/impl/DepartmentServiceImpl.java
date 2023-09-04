package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.entity.Department;
import ua.com.alevel.repository.DepartmentRepository;
import ua.com.alevel.service.DepartmentService;

import java.util.Collection;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void create(Department entity) {
        departmentRepository.save(entity);
    }

    @Override
    public void update(Department entity) {
        checkExists(entity.getId());
        departmentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        checkExists(id);
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        checkExists(id);
        return departmentRepository.findById(id).get();
    }

    @Override
    public Collection<Department> findAll() {
        return departmentRepository.findAll();
    }

    private void checkExists(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
    }
}

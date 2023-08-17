package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.com.alevel.dto.datatable.DatatableRequest;
import ua.com.alevel.dto.datatable.DatatableResponse;
import ua.com.alevel.entity.Department;
import ua.com.alevel.repository.DepartmentRepository;
import ua.com.alevel.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void create(Department entity) {
        departmentRepository.save(entity);
    }

    @Override
    public void update(Department entity) {
        departmentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public DatatableResponse<Department> findALL(DatatableRequest request) {
        Page<Department> departmentPage;
        if (request.sort().equals("desc")) {
            departmentPage = departmentRepository
                    .findAll(
                            PageRequest.of(
                                    request.currentPage() - 1,
                                    request.pageSize(),
                                    Sort.by(request.orderBy()).descending()));
        } else {
            departmentPage = departmentRepository
                    .findAll(
                            PageRequest.of(
                                    request.currentPage() - 1,
                                    request.pageSize(),
                                    Sort.by(request.orderBy()).ascending()));
        }

        DatatableResponse<Department> response = new DatatableResponse<>();
        response.setOrderBy(request.orderBy());
        response.setSort(request.sort());
        response.setPageSize(request.pageSize());
        response.setCurrentPage(request.currentPage());
        response.setItems(departmentPage.getContent());
        return response;
    }
}

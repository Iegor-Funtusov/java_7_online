package ua.com.alevel.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.dto.datatable.DatatableRequest;
import ua.com.alevel.dto.datatable.DatatableResponse;
import ua.com.alevel.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void create(Employee entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Employee entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Employee emp where emp.id = :id")
                .setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean existsById(Long id) {
        Query query = entityManager.createQuery("select count(emp.id) from Employee emp where emp.id = :id")
                .setParameter("id", id);
        return (Long) query.getSingleResult() == 1;
    }

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("select e from Employee e").getResultList();
    }

    @Override
    public DatatableResponse<Employee> findALL(DatatableRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> rootFrom = criteriaQuery.from(Employee.class);
        if (request.sort().equals("desc")) {
            criteriaQuery.orderBy(criteriaBuilder.desc(rootFrom.get(request.orderBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.asc(rootFrom.get(request.orderBy())));
        }
        int page = (request.currentPage() - 1) * request.pageSize();
        List<Employee> employees = entityManager.createQuery(criteriaQuery)
                .setFirstResult(page)
                .setMaxResults(request.pageSize())
                .getResultList();
        DatatableResponse<Employee> response = new DatatableResponse<>();
        response.setCurrentPage(request.currentPage());
        response.setPageSize(request.pageSize());
        response.setSort(request.sort());
        response.setOrderBy(request.orderBy());
        response.setItems(employees);
        return response;
    }

    @Override
    public List<Employee> findAllEmployeesByDepartment(Long departmentId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Employee e join e.departments ed where ed.id = :depId")
                .setParameter("depId", departmentId);
        List<Employee> employees = (List<Employee>) query.getResultList();
        entityManager.getTransaction().commit();
        return employees;
    }

    @Override
    public List<Employee> findAllEmployeesByExcludeDepartment(Long departmentId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select e from Employee e where e.id not in (select e.id from Employee e join e.departments ed where ed.id = :depId)")
                .setParameter("depId", departmentId);
        List<Employee> employees = (List<Employee>) query.getResultList();
        entityManager.getTransaction().commit();
        return employees;
    }
}

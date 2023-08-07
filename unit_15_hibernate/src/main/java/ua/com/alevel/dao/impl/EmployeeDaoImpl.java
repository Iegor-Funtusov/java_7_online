package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Employee entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Employee entity) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public boolean existsById(Long id) {

        return true;
    }

    @Override
    public Employee findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select e from Employee e"); // HQL -> JPQL
//            Query query = session.createNativeQuery("select * from employees"); // SQL
            List<Employee> employees = query.getResultList();
            transaction.commit();
            return employees;
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<Employee> findAllEmployeesByDepartment(Long departmentId) {
        List<Employee> employees = new ArrayList<>();

        return employees;
    }

    @Override
    public List<Employee> findAllEmployeesByExcludeDepartment(Long departmentId) {
        List<Employee> employees = new ArrayList<>();

        return employees;
    }
}

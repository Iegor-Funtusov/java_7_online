package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

import java.util.Collections;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Student student) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(student);
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
    public void update(Student student) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Student findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Student employee = session.find(Student.class, id);
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
    public List<Student> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s"); // HQL -> JPQL
//            Query query = session.createNativeQuery("select * from employees"); // SQL
            List<Student> employees = query.getResultList();
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
}

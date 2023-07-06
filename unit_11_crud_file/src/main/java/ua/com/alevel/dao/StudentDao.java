package ua.com.alevel.dao;

import ua.com.alevel.entity.Student;

import java.util.Collection;

public interface StudentDao {

    void create(Student student);
    void update(Student student);
    void deleteById(String id);
    Student findById(String id);
    Collection<Student> findAll();
    boolean existById(String id);
}

package ua.com.alevel.dao;

import ua.com.alevel.entity.Student;

import java.util.List;

public interface StudentDao {

    void create(Student student);
    List<Student> findAll();
}

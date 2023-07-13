package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

import java.util.List;

public interface StudentService {

    void create(Student student);
    void update(Student student);
    void delete(Long id);
    Student findById(Long id);
    List<Student> findAll();
}

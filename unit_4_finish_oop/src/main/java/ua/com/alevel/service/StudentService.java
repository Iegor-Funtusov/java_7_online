package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

public abstract interface StudentService {

    public abstract void create(Student student);
    void update(Student student);
    void delete(String id);
    Student findById(String id);
    Student[] findAll();
}

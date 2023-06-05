package ua.com.alevel.dao.impl;

import ua.com.alevel.db.StudentStorage;
import ua.com.alevel.entity.Student;
import ua.com.alevel.util.AppUtil;

public class StudentDao {

    private StudentStorage studentStorage = StudentStorage.getInstance();

    public void create(Student student) {
        studentStorage.create(student);
    }

    public void update(Student student) {
        studentStorage.update(student);
    }

    public void delete(String id) {
        studentStorage.delete(id);
    }

    public Student findOne(String id) {
        return studentStorage.findOne(id);
    }

    public Student[] findAll() {
        return studentStorage.findAll();
    }
}

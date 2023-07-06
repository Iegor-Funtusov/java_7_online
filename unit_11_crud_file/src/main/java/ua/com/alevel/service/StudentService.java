package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.impl.CsvStudentDao;
import ua.com.alevel.dao.impl.JsonStudentDao;
import ua.com.alevel.entity.Student;

import java.util.Collection;
import java.util.Collections;

public class StudentService {

//    private StudentDao studentDao = new JsonStudentDao();
    private StudentDao studentDao = new CsvStudentDao();

    public void create(Student student) {
        if (student.getAge() == 0) {
            throw new RuntimeException("Incorrect age!!!");
        }
        studentDao.create(student);
    }

    public void update(Student student) {
        if (student.getAge() == 0) {
            throw new RuntimeException("Incorrect age!!!");
        }
        studentDao.create(student);
    }

    public void deleteById(String id) {
        if (!studentDao.existById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentDao.deleteById(id);
    }

    public Student findById(String id) {
        if (!studentDao.existById(id)) {
            throw new RuntimeException("Student not found");
        }
        return studentDao.findById(id);
    }

    public Collection<Student> findAll() {
        return studentDao.findAll();
    }
}

package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

public class StudentService {

    private StudentDao studentDao = new StudentDao();

    public void create(Student student) {
        if (student.getAge() <= 0 || student.getAge() > 100) {
            System.out.println("you are stupid");
        } else {
            studentDao.create(student);
        }
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void delete(String id) {
        studentDao.delete(id);
    }

    public Student findById(String id) {
        return studentDao.findOne(id);
    }

    public Student[] findAll() {
        return studentDao.findAll();
    }

//    private static final class BlaBla { }
}

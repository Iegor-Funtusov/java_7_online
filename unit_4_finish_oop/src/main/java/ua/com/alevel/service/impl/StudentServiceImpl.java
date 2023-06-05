package ua.com.alevel.service.impl;

import ua.com.alevel.dao.impl.StudentDao;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDao();

    @Override
    public void create(Student student) {
        if (student.getAge() <= 0 || student.getAge() > 100) {
            System.out.println("you are stupid");
        } else {
            studentDao.create(student);
        }
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(String id) {
        studentDao.delete(id);
    }

    @Override
    public Student findById(String id) {
        return studentDao.findOne(id);
    }

    @Override
    public Student[] findAll() {
        return studentDao.findAll();
    }

//    private static final class BlaBla { }
}

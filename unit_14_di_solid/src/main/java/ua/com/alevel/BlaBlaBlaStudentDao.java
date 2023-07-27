package ua.com.alevel;

import java.util.Collection;

@UseClass
public class BlaBlaBlaStudentDao implements StudentDao {

    public BlaBlaBlaStudentDao() {
        System.out.println("BlaBlaBlaStudentDao.BlaBlaBlaStudentDao");
    }

    @Override
    public void create(Student student) {

    }

    @Override
    public Collection<Student> findAll() {
        return null;
    }
}

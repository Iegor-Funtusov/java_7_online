package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

//@UseClass
public class ListStudentDao implements StudentDao {

    private List<Student> students = new ArrayList<>();

    public ListStudentDao() {
        System.out.println("ListStudentDao.ListStudentDao");
    }

    @Override
    public void create(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }
}

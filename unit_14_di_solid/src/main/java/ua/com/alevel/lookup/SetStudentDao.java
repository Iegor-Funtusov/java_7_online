package ua.com.alevel.lookup;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//@UseClass
public class SetStudentDao implements StudentDao {

    Set<Student> students = new HashSet<>();

    public SetStudentDao() {
        System.out.println("SetStudentDao.SetStudentDao");
    }

    @Override
    public void create(Student student) {
        students.add(student);
    }

    @Override
    public Collection<Student> findAll() {
        return students;
    }
}

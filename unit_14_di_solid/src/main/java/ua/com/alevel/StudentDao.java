package ua.com.alevel;

import java.util.Collection;

public interface StudentDao {

    void create(Student student);
    Collection<Student> findAll();
}

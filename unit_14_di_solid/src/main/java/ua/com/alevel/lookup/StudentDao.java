package ua.com.alevel.lookup;

import java.util.Collection;

public interface StudentDao {

    void create(Student student);
    Collection<Student> findAll();
}

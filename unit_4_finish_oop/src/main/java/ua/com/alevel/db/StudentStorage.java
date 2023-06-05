package ua.com.alevel.db;

import ua.com.alevel.entity.Student;
import ua.com.alevel.util.AppUtil;

//Singleton
public class StudentStorage {

    private static StudentStorage instance;
    private Student[] students = new Student[10];

    private StudentStorage() {}

    public static StudentStorage getInstance() {
        if (instance == null) {
            instance = new StudentStorage();
        }
        return instance;
    }

    public void create(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                String id = AppUtil.getUUID();
                student.setId(id);
                students[i] = student;
                break;
            }
        }
    }

    public void update(Student student) {
        System.out.println("StudentStorage.update");
    }

    public void delete(String id) {
        System.out.println("StudentStorage.delete");
    }

    public Student findOne(String id) {
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student != null) {
                if (student.getId().equals(id)) {
                    return student;
                }
            }
        }
        return null;
    }

    public Student[] findAll() {
        return students;
    }
}

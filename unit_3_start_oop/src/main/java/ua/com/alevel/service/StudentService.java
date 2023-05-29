package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

import java.util.UUID;

public class StudentService {
    
    private Student[] students = new Student[10];

    public void create(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                String id = UUID.randomUUID().toString();
                student.setId(id);
                students[i] = student;
                break;
            }
        }
    }

    public void update() {
        System.out.println("UserController.update");
    }

    public void delete() {
        System.out.println("UserController.delete");
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

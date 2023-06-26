package ua.com.alevel.oop;

public class StudentService {

    public void create(Student student) {
        System.out.println("StudentService.create");
        if (student.getAge() == 0) {
            throw new RuntimeException("Incorrect age!!!");
        }
        System.out.println("student = " + student);
    }
}

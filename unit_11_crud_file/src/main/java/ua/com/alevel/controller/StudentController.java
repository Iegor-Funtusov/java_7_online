package ua.com.alevel.controller;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class StudentController {

    private final StudentService studentService = new StudentService();

    public void start() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to first crud application!");
            System.out.println("Please, select your options:");
            String select;
            menu();
            while ((select = bufferedReader.readLine()) != null) {
                crud(bufferedReader, select);
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want create student, please enter 1");
        System.out.println("If you want update student, please enter 2");
        System.out.println("If you want delete student, please enter 3");
        System.out.println("If you want find student, please enter 4");
        System.out.println("If you want find all students, please enter 5");
        System.out.println("If you want close application, please enter 6");
    }

    private void crud(BufferedReader bufferedReader, String select) throws IOException {
        switch (select) {
            case "1" -> create(bufferedReader);
            case "2" -> update(bufferedReader);
            case "3" -> delete(bufferedReader);
            case "4" -> findOne(bufferedReader);
            case "5" -> findAll(bufferedReader);
            case "6" -> System.exit(0);
        }
        menu();
    }

    private void create(BufferedReader bufferedReader) throws IOException {
        System.out.println("StudentController.create");
        Student student = new Student();
        generateStudent(bufferedReader, student);
        // 1
//        try {
//            studentService.create(student);
//        } catch (RuntimeException e) {
//            System.out.println("e = " + e.getMessage());
//        }
        //2
        studentService.create(student);
    }

    private void update(BufferedReader bufferedReader) throws IOException {
        System.out.println("StudentController.update");
        String id = bufferedReader.readLine();
        System.out.println("id = " + id);
        Student student = studentService.findById(id);
        generateStudent(bufferedReader, student);
        studentService.update(student);
    }

    private void delete(BufferedReader bufferedReader) throws IOException {
        System.out.println("StudentController.delete");
        String id = bufferedReader.readLine();
        System.out.println("id = " + id);
        studentService.deleteById(id);
    }

    private void findOne(BufferedReader bufferedReader) throws IOException {
        System.out.println("StudentController.findOne");
        String id = bufferedReader.readLine();
        System.out.println("id = " + id);
        Student student = studentService.findById(id);
        System.out.println("student = " + student);
    }

    private void findAll(BufferedReader bufferedReader) {
        System.out.println("StudentController.findAll");
        Collection<Student> students = studentService.findAll();
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }

    private void generateStudent(BufferedReader bufferedReader, Student student) throws IOException {
        System.out.println("Please enter first name");
        String firstName = bufferedReader.readLine();
        System.out.println("Please enter last name");
        String lastName = bufferedReader.readLine();
        System.out.println("Please enter age");
        String ageString = bufferedReader.readLine();
        int age = 0;
        try {
            // while !!!!!!!!!!!!!!!!!!!!!!!!
            age = Integer.parseInt(ageString);
        } catch (NumberFormatException e) {
            System.out.println("incorrect value: " + e.getMessage());
        }

        student.setAge(age);
        student.setFirstName(firstName);
        student.setLastName(lastName);
    }
}

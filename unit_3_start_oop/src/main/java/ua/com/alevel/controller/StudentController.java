package ua.com.alevel.controller;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentController {

    private StudentService studentService = new StudentService();

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to first crud application!");
        System.out.println("Please, select your options:");
        String select;
        menu();
        while ((select = bufferedReader.readLine()) != null) {
            crud(bufferedReader, select);
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
        System.out.println("Please enter first name");
        String firstName = bufferedReader.readLine();
        System.out.println("Please enter last name");
        String lastName = bufferedReader.readLine();
        System.out.println("Please enter age");
        String ageString = bufferedReader.readLine();
        int age = Integer.parseInt(ageString);
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        studentService.create(student);
    }

    private void update(BufferedReader bufferedReader) {
        System.out.println("UserController.update");
    }

    private void delete(BufferedReader bufferedReader) {
        System.out.println("UserController.delete");
    }

    private void findOne(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter id");
        String id = bufferedReader.readLine();
        Student student = studentService.findOne(id);
        if (student != null) {
            System.out.println("FirstName: " + student.getFirstName() + ", LastName: " + student.getLastName() + ", Age: " + student.getAge());
        } else {
            System.out.println("Student not found");
        }
    }

    private void findAll(BufferedReader bufferedReader) {
        Student[] students = studentService.findAll();
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student != null) {
                System.out.println("Id: " + student.getId() + ", FirstName: " + student.getFirstName() + ", LastName: " + student.getLastName() + ", Age: " + student.getAge());
            }
        }
    }
}

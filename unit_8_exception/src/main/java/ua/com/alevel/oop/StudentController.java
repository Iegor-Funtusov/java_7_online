package ua.com.alevel.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentController {

    private StudentService studentService = new StudentService();

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

        Student student = new Student();
        student.setAge(age);
        student.setFirstName(firstName);
        student.setLastName(lastName);
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
    }

    private void delete(BufferedReader bufferedReader) throws IOException {
        System.out.println("StudentController.delete");
        String id = bufferedReader.readLine();
        System.out.println("id = " + id);
    }

    private void findOne(BufferedReader bufferedReader) throws IOException {
        System.out.println("StudentController.findOne");
        String id = bufferedReader.readLine();
        System.out.println("id = " + id);
    }

    private void findAll(BufferedReader bufferedReader) {
        System.out.println("StudentController.findAll");
    }
}

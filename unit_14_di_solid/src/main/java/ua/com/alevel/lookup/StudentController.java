package ua.com.alevel.lookup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentController {

    private final StudentDao studentDao = StudentDaoFactory.getFactory().getStudentDao();

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
            case "1" -> createStudent(bufferedReader);
            case "2" -> updateStudent(bufferedReader);
            case "3" -> deleteStudent(bufferedReader);
            case "4" -> findOneStudent(bufferedReader);
            case "5" -> findAllStudents(bufferedReader);
            case "13" -> System.exit(0);
        }
        menu();
    }

    private void findOneStudent(BufferedReader bufferedReader) {

    }

    private void findAllStudents(BufferedReader bufferedReader) {
        for (Student student : studentDao.findAll()) {
            System.out.println("student = " + student);
        }
    }

    private void deleteStudent(BufferedReader bufferedReader) {

    }

    private void updateStudent(BufferedReader bufferedReader) {

    }

    private void createStudent(BufferedReader bufferedReader) throws IOException {
        System.out.println("StudentController.createDepartment");
        System.out.println("Please enter a student name");
        String name = bufferedReader.readLine();
        Student student = new Student();
        student.setName(name);
        studentDao.create(student);
    }
}

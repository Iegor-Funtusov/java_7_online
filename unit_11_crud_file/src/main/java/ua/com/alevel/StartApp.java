package ua.com.alevel;

import com.google.gson.Gson;
import ua.com.alevel.controller.StudentController;
import ua.com.alevel.entity.Student;

import java.util.UUID;

public class StartApp implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        StudentController studentController = new StudentController();
        studentController.start();

//        Student student = new Student();
//        student.setId(UUID.randomUUID().toString());
//        student.setFirstName("fsfgs");
//        student.setLastName("fsfsfs");
//        student.setFullName("fsfsfs gsgsgs");
//        student.setAge(45);
//
//        Gson gson = new Gson();
//        String json = gson.toJson(student);
//        System.out.println("json = " + json);
//
//        Student student1 = gson.fromJson(json, Student.class);
//        System.out.println("student1 = " + student1);
    }
}

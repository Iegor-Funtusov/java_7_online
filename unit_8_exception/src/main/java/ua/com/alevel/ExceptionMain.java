package ua.com.alevel;

import ua.com.alevel.oop.StartApp;
import ua.com.alevel.oop.StudentController;

public class ExceptionMain {
    public static void main(String[] args) {
//        System.out.println("start ExceptionMain!");
//        Thread thread = Thread.currentThread();
//        System.out.println("thread = " + thread.getName());
//        System.out.println(10/0);
//        CustomThread customThread = new CustomThread("testThread");
//        customThread.start();


//        1. Input/Output - IOException
//        2. Logical process - RuntimeException
//        3. SLQ - SQLException

//        System.out.println("main finish");


//        ExceptionProcess process = new ExceptionProcess();
//        process.run();

//        StudentController controller = new StudentController();
//        controller.start();

        StartApp startApp = new StartApp();
        startApp.run();
        System.out.println("finish");
    }
}

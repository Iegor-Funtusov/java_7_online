package ua.com.alevel.oop;

public class StartApp implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        StudentController studentController = new StudentController();
        studentController.start();
    }
}

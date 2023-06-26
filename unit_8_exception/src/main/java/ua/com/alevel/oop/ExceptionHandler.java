package ua.com.alevel.oop;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        new Thread(new StartApp()).start();
    }
}

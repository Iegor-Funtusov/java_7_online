package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionProcess {

    public void run() {
        methodA();
    }

    private void methodA() {
        System.out.println("ExceptionProcess.methodA");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            methodB(s);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void methodB(String s) {
        System.out.println("ExceptionProcess.methodB");
        try {
            Integer v = Integer.parseInt(s);
            methodC(v);
        } catch (NumberFormatException e) {
            System.out.println("e : " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("e :: " + e.getMessage());
        }
    }

    private void methodC(int v) throws RuntimeException {
        System.out.println("ExceptionProcess.methodC");
        System.out.println(10/ v);
    }
}

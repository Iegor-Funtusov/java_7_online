package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomThread extends Thread {

    public CustomThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println("CustomThread.run");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter value:");
        try {
            String value = bufferedReader.readLine();
            if (value.matches("[0-9]")) {
                Integer v = Integer.parseInt(value);
                if (v != 0) {
                    System.out.println(10/v);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("CustomThread.stop");
    }
}

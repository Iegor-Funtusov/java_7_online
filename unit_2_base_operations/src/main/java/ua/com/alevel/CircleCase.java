package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircleCase {

    public void circleTest() {
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);

        sum = 0;
        int count = 0;
        while (count <= 10) {
            sum += count;
            count++;
        }
        System.out.println("sum = " + sum);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please, enter the text: \n");
            String text;
            while ((text = bufferedReader.readLine()) != null && !text.equals("exit")) {
                System.out.println("text = " + text);
//                System.out.println("text: " + text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

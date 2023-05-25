package ua.com.alevel;

public class IfCase {

    public void ifTest() {
        boolean b = false;
        if (b) {
            System.out.println("b = " + b);
        }
        if (!b) {
            System.out.println("not b = " + b);
        }

        boolean bb = true;
        if (bb) {
            System.out.println("bb = " + bb);
        } else {
            System.out.println("not bb = " + bb);
        }

        int a = 0;
        if (a <= 5) {
            System.out.println("a <= 5");
        } else if (a < 10 && a > 5) {
            System.out.println("a < 10");
        } else if (a == 10) {
            System.out.println("a == 10");
        } else {
            System.out.println("a > 10");
        }

        int aa = 4;
        if (aa == 5) {
            System.out.println("aa == 5");
        }
        if (aa == 7) {
            System.out.println("aa == 7");
        }
        if (aa == 10) {
            System.out.println("aa == 10");
        }

        switch (aa) {
            case 1,2,3,4,5 -> System.out.println("aa == 5");
            case 6,7,8,9 -> System.out.println("aa == 7");
            case 10,11 -> System.out.println("aa == 10");
            default -> System.out.println("aa == something");
        }
    }
}

package ua.com.alevel;

public class ArrayTest {

    public void test() {
        add(10);
        add1(new int[]{1, 5, 8});
        add2(new int[]{1, 5, 8});
        add2(new int[]{1, 5, 8}, new int[]{1, 5, 8});
        add2(new int[]{1, 5, 8}, new int[]{1, 5, 8}, new int[]{1, 5, 8});
    }

    public void add(int a) {

    }

    public void add1(int[] ints) {

    }

    public void add2(int[] ... ints) {}
}

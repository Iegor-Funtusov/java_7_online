package ua.com.alevel;

@FunctionalInterface
public interface IAnonim {

    int sum(int a, int b);

    default int sum1(int a, int b) {
        return a + b;
    }

    default int sum2(int a, int b) {
        return a + b;
    }
}

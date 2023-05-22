import java.math.*;

public class HelloWorld {
    public static void main(String[] args) {
        Message m = new Message();
        m.print(m.getClass().getName());

        byte bMax = Byte.MAX_VALUE;
        byte bMin = Byte.MIN_VALUE;
        m.print("bMax: " + bMax);
        m.print("bMin: " + bMin);

        short sMax = Short.MAX_VALUE;
        short sMin = Short.MIN_VALUE;
        m.print("sMax: " + sMax);
        m.print("sMin: " + sMin);

        int iMax = Integer.MAX_VALUE;
        int iMin = Integer.MIN_VALUE;
        m.print("iMax: " + iMax);
        m.print("iMin: " + iMin);

        long lMax = Long.MAX_VALUE;
        long lMin = Long.MIN_VALUE;
        m.print("lMax: " + lMax);
        m.print("lMin: " + lMin);

        float fMax = Float.MAX_VALUE;
        float fMin = Float.MIN_VALUE;
        m.print("fMax: " + fMax);
        m.print("fMin: " + fMin);

        double dMax = Double.MAX_VALUE;
        double dMin = Double.MIN_VALUE;
        m.print("dMax: " + dMax);
        m.print("dMin: " + dMin);

        char c = 34;
        m.print("c: " + c);

        boolean b = true;
        m.print("b: " + b);

        System.out.println();
        System.out.println("fin ar:");
        System.out.println(2.0 - 1.1);

        BigDecimal left = new BigDecimal("2.0");
        BigDecimal right = new BigDecimal("1.1");
        BigDecimal res = left.subtract(right);
        System.out.println("res = " + res);
    }
}

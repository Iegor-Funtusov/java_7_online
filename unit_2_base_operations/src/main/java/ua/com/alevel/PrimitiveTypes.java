package ua.com.alevel;

public class PrimitiveTypes {
    int a = 10;

    public void observTypes() {
        byte bMax = Byte.MAX_VALUE;
        byte bMin = Byte.MIN_VALUE;
        System.out.println("bMax: " + bMax);
        System.out.println("bMin: " + bMin);

        short sMax = Short.MAX_VALUE;
        short sMin = Short.MIN_VALUE;
        System.out.println("sMax: " + sMax);
        System.out.println("sMin: " + sMin);

        int iMax = Integer.MAX_VALUE;
        int iMin = Integer.MIN_VALUE;
        System.out.println("iMax: " + iMax);
        System.out.println("iMin: " + iMin);

        long lMax = Long.MAX_VALUE;
        long lMin = Long.MIN_VALUE;
        System.out.println("lMax: " + lMax);
        System.out.println("lMin: " + lMin);

        float fMax = Float.MAX_VALUE;
        float fMin = Float.MIN_VALUE;
        System.out.println("fMax: " + fMax);
        System.out.println("fMin: " + fMin);

        double dMax = Double.MAX_VALUE;
        double dMin = Double.MIN_VALUE;
        System.out.println("dMax: " + dMax);
        System.out.println("dMin: " + dMin);

        char c = 34;
        System.out.println("c: " + c);

        boolean b = true;
        System.out.println("b: " + b);
    }
}

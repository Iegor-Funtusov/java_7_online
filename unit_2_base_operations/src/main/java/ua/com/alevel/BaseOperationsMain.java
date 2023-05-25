package ua.com.alevel;

public class BaseOperationsMain {

    public static void main(String[] args) {
        int a = 10;
        int b = 15;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a = 0;
//        a = a + 7;
        a += 7; //eq a = a + 7;


        System.out.println("a = " + a);


        PrimitiveTypes pt1 = new PrimitiveTypes();
        PrimitiveTypes pt2 = new PrimitiveTypes();

        pt1.a = 10;
        pt2.a = 15;

        System.out.println("pt1 = " + pt1.a);
        System.out.println("pt2 = " + pt2.a);

        pt1 = pt2;

        System.out.println("pt1 = " + pt1.a);
        System.out.println("pt2 = " + pt2.a);

        pt1.a = 56;

        System.out.println("pt1 = " + pt1.a);
        System.out.println("pt2 = " + pt2.a);

        pt1.observTypes();

        byte bb = Byte.MAX_VALUE;

        System.out.println("bb = " + bb);

        bb = (byte) (bb + (byte) 1);

        System.out.println("bb = " + bb);

        a = 0;

        System.out.println("a = " + a++);

//        a = 0;

        System.out.println("a = " + ++a);

        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = false;

        System.out.println("&& = " + (b1 && b2));
        System.out.println("|| = " + (b1 || b2 || b3));

        IfCase ifCase = new IfCase();
        ifCase.ifTest();

        CircleCase circleCase = new CircleCase();
        circleCase.circleTest();
    }
}

package ch6.MyMath;

public class MyMathTest {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        long result = mm.add(5L, 3L);
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L); // double 대신 long 값을 인자로 호출하였으나, double로 자동현변환된다.

        System.out.println("add(5L, 3L) = " + result);
        System.out.println("subtract(5L, 3L) = " + result2);
        System.out.println("multiply(5L, 3L) = " + result3);
        System.out.println("divide(5L, 3L) = " + result4);
    }
}

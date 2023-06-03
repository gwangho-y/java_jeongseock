package ch6.CallStatck;

public class FactorialTest {
    public static void main(String[] args) {
        int result = factorial(4);
    }

    static int factorial(int n) {
        int result = 0;
        if (n == 1) result =1;
        else result = n * factorial(n-1);
        System.out.println(result);
        return result;
    }
}
